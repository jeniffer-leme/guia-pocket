package com.example.guiapocket_bairrox.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.guiapocket_bairrox.databinding.ActivityDetalheServicoBinding // Importação do Binding
import com.example.guiapocket_bairrox.model.Contato

class DetalheServicoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetalheServicoBinding

    companion object {
        const val EXTRA_CONTATO = "contato_selecionado"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalheServicoBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
        if (contato.imagemUri.isNotBlank()) {
            binding.imgFoto.setImageURI(Uri.parse(contato.imagemUri))
        }
        binding.tvDetalheNome.text = contato.nome
        binding.tvDetalheCategoria.text = contato.categoria
        binding.tvDetalheDescricao.text = contato.descricao
        binding.tvDetalheEndereco.text = contato.endereco
        binding.tvDetalheTelefone.text = contato.telefone
    }

    private fun setupActionListeners(contato: Contato) {
        binding.btnLigar.setOnClickListener {
            val telefoneLimpo = contato.telefone.replace("[^0-9]".toRegex(), "")
            val intentLigar = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$telefoneLimpo")
            }
            startActivity(intentLigar)
        }

        binding.btnVerNoMapa.setOnClickListener {
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

        binding.btnCompartilhar.setOnClickListener {
            val textoCompartilhar =
                "Confira: ${contato.nome} (${contato.categoria}). Endereço: ${contato.endereco}. Telefone: ${contato.telefone}."

            val intentCompartilhar = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, textoCompartilhar)
            }

            val seletor =
                Intent.createChooser(intentCompartilhar, "Compartilhar ${contato.nome} via...")
            startActivity(seletor)
        }
    }
}
