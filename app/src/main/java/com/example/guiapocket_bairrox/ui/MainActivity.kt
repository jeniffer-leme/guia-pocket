package com.example.guiapocket_bairrox.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.guiapocket_bairrox.R
import com.example.guiapocket_bairrox.adapter.ContatoAdapter
import com.example.guiapocket_bairrox.databinding.ActivityMainBinding
import com.example.guiapocket_bairrox.model.Contato

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var estabelecimentos: List<Contato>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadData()
        setupViews()
        setupListeners()
    }
    fun loadData(){
        estabelecimentos = listOf(
            Contato(
                1,
                R.drawable.varejao_opini,
                getString(R.string.varejao_opini_name), // Nome (Assumindo R.string.varejao_opini_name)
                getString(R.string.category_supermarket),
                getString(R.string.varejao_opini_description),
                getString(R.string.varejao_opini_address),
                getString(R.string.varejao_opini_phone)
            ),
            Contato(
                2,
                R.drawable.restaurante_kekantu,
                getString(R.string.kekantu_name),
                getString(R.string.category_restaurant),
                getString(R.string.kekantu_description),
                getString(R.string.kekantu_address),
                getString(R.string.kekantu_phone)
            ),
            Contato(
                3,
                R.drawable.loja_malibu_modas,
                getString(R.string.malibu_modas_name),
                getString(R.string.category_store),
                getString(R.string.malibu_modas_description),
                getString(R.string.malibu_modas_address),
                getString(R.string.malibu_modas_phone)
            ),
            Contato(
                4,
                R.drawable.barbearia_atemporal,
                getString(R.string.barbearia_atemporal_name),
                getString(R.string.category_barbershop),
                getString(R.string.barbearia_atemporal_description),
                getString(R.string.barbearia_atemporal_address),
                getString(R.string.barbearia_atemporal_phone)
            ),
            Contato(
                5,
                R.drawable.padaria_sao_jose,
                getString(R.string.padaria_sao_jose_name),
                getString(R.string.category_bakery),
                getString(R.string.padaria_sao_jose_description),
                getString(R.string.padaria_sao_jose_address),
                getString(R.string.padaria_sao_jose_phone)
            ),
            Contato(
                6,
                R.drawable.gui_lanches,
                getString(R.string.gui_lanches_name),
                getString(R.string.category_snackbar),
                getString(R.string.gui_lanches_description),
                getString(R.string.gui_lanches_address),
                getString(R.string.gui_lanches_phone)
            )
        ).sortedBy { it.nome }
    }
    fun setupViews(){
        val adapter = ContatoAdapter(this, estabelecimentos)
        binding.listViewContatos.adapter = adapter
    }
    fun setupListeners(){
        binding.listViewContatos.setOnItemClickListener { _, _, position, _ ->
            val estabelecimento = estabelecimentos[position]
            val intent = Intent(this, DetalheServicoActivity::class.java)
            intent.putExtra(DetalheServicoActivity.EXTRA_CONTATO, estabelecimento)
            startActivity(intent)
            Toast.makeText(this, "Estabelecimento: ${estabelecimento.nome}", Toast.LENGTH_SHORT).show()
        }
    }
}