package com.example.guiapocket_bairrox.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
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
    private lateinit var btnLigar: Button
    private lateinit var btnVerNoMapa: Button
    private lateinit var btnCompartilhar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_servico)

        imgFoto = findViewById(R.id.imgFoto)
        tvNome = findViewById(R.id.tvDetalheNome)
        tvCategoria = findViewById(R.id.tvDetalheCategoria)
        tvDescricao = findViewById(R.id.tvDetalheDescricao)
        tvEndereco = findViewById(R.id.tvDetalheEndereco)
        tvTelefone = findViewById(R.id.tvDetalheTelefone)
        btnLigar = findViewById(R.id.btnLigar)
        btnVerNoMapa = findViewById(R.id.btnVerNoMapa)
        btnCompartilhar = findViewById(R.id.btnCompartilhar)

        @Suppress("DEPRECATION")
        val contato: Contato? = intent.getParcelableExtra(EXTRA_CONTATO)
        if (contato != null) {
            preencherDados(contato)
            setupActionListeners(contato)
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

    private fun setupActionListeners(contato: Contato) {
        //Botão de ligar(tel)
        btnLigar.setOnClickListener {
            val telefoneLimpo = contato.telefone.replace("[^0-9]".toRegex(), "")
            val intentLigar = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$telefoneLimpo")
            }
            startActivity(intentLigar)
        }

        //Botão de abrir no maps
        btnVerNoMapa.setOnClickListener {
            val enderecoEncoded = Uri.encode(contato.endereco)
            val uriMapa = Uri.parse("geo:0,0?q=$enderecoEncoded")

            val intentMapa = Intent(Intent.ACTION_VIEW, uriMapa)
            intentMapa.setPackage("com.google.android.apps.maps")

            if (intentMapa.resolveActivity(packageManager) != null) {
                startActivity(intentMapa)
            } else {
                Toast.makeText(this, "Nenhum aplicativo de mapas encontrado.", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        //Botão de compartilhar p/ outros apps
        btnCompartilhar.setOnClickListener {
            val textoCompartilhar =
                "Confira: ${contato.nome} (${contato.categoria}). Endereço: ${contato.endereco}. Telefone: ${contato.telefone}."

            val intentCompartilhar = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain" // Define que o conteúdo é texto simples
                putExtra(Intent.EXTRA_TEXT, textoCompartilhar)
            }

            val seletor =
                Intent.createChooser(intentCompartilhar, "Compartilhar ${contato.nome} via...")
            startActivity(seletor)
        }
    }
}