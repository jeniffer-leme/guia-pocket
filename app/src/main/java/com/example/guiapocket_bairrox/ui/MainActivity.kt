package com.example.guiapocket_bairrox.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.guiapocket_bairrox.R
import com.example.guiapocket_bairrox.adapter.ContatoAdapter
import com.example.guiapocket_bairrox.databinding.ActivityMainBinding
import com.example.guiapocket_bairrox.model.Contato

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var contatos: List<Contato>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadData()
        setupViews()
        setupListeners()
    }
    fun loadData(){
        contatos = listOf(
            Contato(
                R.drawable.minkey,
                "Minkey",
                "(16) 98888-7777"
            ),
            Contato(
                R.drawable.mennie,
                "Mennie",
                "(16) 97777-6666"
            ),
            Contato(
                R.drawable.patetla,
                "Patleta",
                "(16) 96666-5555"
            ),
            Contato(
                R.drawable.truco,
                "Truco",
                "(16) 98888-7777"
            ),
            Contato(
                R.drawable.donaldo,
                "Donaldo",
                "(16) 97777-6666"
            ),
            Contato(
                R.drawable.carlos,
                "Carlos",
                "(16) 96666-5555"
            )
        ).sortedBy { it.nome }
    }
    fun setupViews(){
        val adapter = ContatoAdapter(this, contatos)
        binding.listViewContatos.adapter = adapter
    }
    fun setupListeners(){
        binding.listViewContatos.setOnItemClickListener { _, _, position, _ ->
            val contato = contatos[position]
            Toast.makeText(this, "Estabelecimento: ${contato.nome}", Toast.LENGTH_SHORT).show()
        }
    }
}