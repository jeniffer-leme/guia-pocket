package com.example.guiapocket_bairrox.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.guiapocket_bairrox.R
import com.example.guiapocket_bairrox.adapter.ContatoRecyclerAdapter
import com.example.guiapocket_bairrox.data.AppDatabase
import com.example.guiapocket_bairrox.data.ContatoDao
import com.example.guiapocket_bairrox.databinding.ActivityMainBinding
import com.example.guiapocket_bairrox.model.Contato
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ContatoRecyclerAdapter
    private lateinit var contatoDao: ContatoDao
    private var masterList: List<Contato> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        contatoDao = AppDatabase.getDatabase(applicationContext).contatoDao()

        adapter = ContatoRecyclerAdapter(emptyList()) { contato ->
            val intent = Intent(this, DetalheServicoActivity::class.java).apply {
                putExtra(DetalheServicoActivity.EXTRA_CONTATO, contato)
            }
            startActivity(intent)
        }
        binding.recyclerContatos.layoutManager = LinearLayoutManager(this)
        binding.recyclerContatos.adapter = adapter

        observeContatos()

        setupListeners()
    }

    private fun observeContatos() {
        contatoDao.getAll().observe(this, Observer { contatos ->
            if (contatos.isEmpty()) {
                populateDatabase()
            } else {
                masterList = contatos
                filterList(binding.etPesquisar.query.toString())
            }
        })
    }

    private fun setupListeners() {
        binding.etPesquisar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean = false
            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }
        })

        binding.fabAdicionar.setOnClickListener {
            startActivity(Intent(this, CadastroActivity::class.java))
        }
    }

    private fun filterList(query: String?) {
        val filteredList = if (query.isNullOrBlank()) {
            masterList
        } else {
            masterList.filter { it.nome.contains(query, ignoreCase = true) }
        }
        adapter.updateList(filteredList)
    }

    private fun populateDatabase() {
        lifecycleScope.launch {
            val initialData = getInitialData()
            initialData.forEach { contatoDao.inserir(it) }
        }
    }

    private fun getInitialData(): List<Contato> {
        fun drawableToUri(drawableId: Int): String {
            return Uri.parse("android.resource://$packageName/$drawableId").toString()
        }

        return listOf(
            Contato(
                imagemUri = drawableToUri(R.drawable.varejao_opini),
                nome = getString(R.string.varejao_opini_name),
                categoria = getString(R.string.category_supermarket),
                descricao = getString(R.string.varejao_opini_description),
                endereco = getString(R.string.varejao_opini_address),
                telefone = getString(R.string.varejao_opini_phone)
            ),
            Contato(
                imagemUri = drawableToUri(R.drawable.restaurante_kekantu),
                nome = getString(R.string.kekantu_name),
                categoria = getString(R.string.category_restaurant),
                descricao = getString(R.string.kekantu_description),
                endereco = getString(R.string.kekantu_address),
                telefone = getString(R.string.kekantu_phone)
            ),
            Contato(
                imagemUri = drawableToUri(R.drawable.loja_malibu_modas),
                nome = getString(R.string.malibu_modas_name),
                categoria = getString(R.string.category_store),
                descricao = getString(R.string.malibu_modas_description),
                endereco = getString(R.string.malibu_modas_address),
                telefone = getString(R.string.malibu_modas_phone)
            ),
            Contato(
                imagemUri = drawableToUri(R.drawable.barbearia_atemporal),
                nome = getString(R.string.barbearia_atemporal_name),
                categoria = getString(R.string.category_barbershop),
                descricao = getString(R.string.barbearia_atemporal_description),
                endereco = getString(R.string.barbearia_atemporal_address),
                telefone = getString(R.string.barbearia_atemporal_phone)
            ),
            Contato(
                imagemUri = drawableToUri(R.drawable.padaria_sao_jose),
                nome = getString(R.string.padaria_sao_jose_name),
                categoria = getString(R.string.category_bakery),
                descricao = getString(R.string.padaria_sao_jose_description),
                endereco = getString(R.string.padaria_sao_jose_address),
                telefone = getString(R.string.padaria_sao_jose_phone)
            ),
            Contato(
                imagemUri = drawableToUri(R.drawable.gui_lanches),
                nome = getString(R.string.gui_lanches_name),
                categoria = getString(R.string.category_snackbar),
                descricao = getString(R.string.gui_lanches_description),
                endereco = getString(R.string.gui_lanches_address),
                telefone = getString(R.string.gui_lanches_phone)
            )
        )
    }
}
