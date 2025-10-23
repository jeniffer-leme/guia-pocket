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
                "Varejão Opini",
                "Supermercado",
                "blabla-descricao",
                "rua blabla",
                "123456789"
            ),
            Contato(
                2,
                R.drawable.restaurante_kekantu,
                "Kekantu",
                "Restaurante",
                "blabla-descricao",
                "rua blabla",
                "123456789"
            ),
            Contato(
                3,
                R.drawable.loja_malibu_modas,
                "Malibu Modas",
                "Loja",
                "blabla-descricao",
                "rua blabla",
                "123456789"
            ),
            Contato(
                4,
                R.drawable.barbearia_atemporal,
                "Barbearia Atemporal",
                "Barbearia",
                "blabla-descricao",
                "rua blabla",
                "123456789"
            ),
            Contato(
                5,
                R.drawable.padaria_sao_jose,
                "Padaria São José",
                "Padaria",
                "blabla-descricao",
                "rua blabla",
                "123456789"
            ),
            Contato(
                6,
                R.drawable.gui_lanches,
                "Gui Lanches",
                "Lanchonete",
                "blabla-descricao",
                "rua blabla",
                "123456789"
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