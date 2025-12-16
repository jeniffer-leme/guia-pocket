package com.example.guiapocket_bairrox.ui

import android.net.Uri
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.guiapocket_bairrox.data.AppDatabase
import com.example.guiapocket_bairrox.databinding.ActivityCadastroBinding
import com.example.guiapocket_bairrox.model.Contato
import kotlinx.coroutines.launch


class CadastroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroBinding
    private lateinit var db: AppDatabase
    private var imagemSelecionada: Uri? = null

    private val selecionarImagem =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            uri?.let {
                imagemSelecionada = it
                binding.imgSelecionada.setImageURI(it)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEscolherImagem.setOnClickListener {
            selecionarImagem.launch("image/*")
        }

        binding.btnSalvar.setOnClickListener {
            salvarContato()
        }
    }

    private fun salvarContato() {
        val nome = binding.etNome.text.toString()
        val categoria = binding.etCategoria.text.toString()
        val descricao = binding.etDescricao.text.toString()
        val endereco = binding.etEndereco.text.toString()
        val telefone = binding.etTelefone.text.toString()

        if (nome.isBlank() || categoria.isBlank()) {
            binding.etNome.error = "Campo obrigatório"
            return
        }

        val contato = Contato(
            imagemUri = imagemSelecionada.toString(),
            nome = binding.etNome.text.toString(),
            categoria = binding.etCategoria.text.toString(),
            descricao = binding.etDescricao.text.toString(),
            endereco = binding.etEndereco.text.toString(),
            telefone = binding.etTelefone.text.toString()
        )

        lifecycleScope.launch {
            db.contatoDao().inserir(contato)
            setResult(RESULT_OK)
            finish()
        }

    }
}