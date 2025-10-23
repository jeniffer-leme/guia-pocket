package com.example.guiapocket_bairrox.ui

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.guiapocket_bairrox.R
import com.example.guiapocket_bairrox.model.Contato

class DetalheServicoActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_CONTATO = "contato_selecionado"
    }
    private lateinit var imgFoto: ImageView
    private lateinit var tvNome: TextView
    private lateinit var tvCategoria: TextView
    private lateinit var tvDescricao: TextView
    private lateinit var tvEndereco: TextView
    private lateinit var tvTelefone: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_servico)

        imgFoto = findViewById(R.id.imgFoto)
        tvNome = findViewById(R.id.tvDetalheNome)
        tvCategoria = findViewById(R.id.tvDetalheCategoria)
        tvDescricao = findViewById(R.id.tvDetalheDescricao)
        tvEndereco = findViewById(R.id.tvDetalheEndereco)
        tvTelefone = findViewById(R.id.tvDetalheTelefone)

        @Suppress("DEPRECATION")
        val contato: Contato? = intent.getParcelableExtra(EXTRA_CONTATO)
        if (contato != null) {
            preencherDados(contato)
        } else {
            Toast.makeText(this, "Erro: Estabelecimento não encontrado.", Toast.LENGTH_LONG).show()
            finish()
        }
    }

    private fun preencherDados(contato: Contato) {
        imgFoto.setImageResource(contato.foto)
        tvNome.text = contato.nome
        tvCategoria.text = contato.categoria
        tvDescricao.text = contato.descricao
        tvEndereco.text = contato.endereco
        tvTelefone.text = contato.telefone
    }
}