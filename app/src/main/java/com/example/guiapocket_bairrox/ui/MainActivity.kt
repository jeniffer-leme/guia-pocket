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
                "No Varejão Opini, você encontra frutas, verduras, legumes e produtos naturais sempre fresquinhos e selecionados com carinho. Trabalhamos com produtores locais para garantir qualidade, preço justo e aquele atendimento acolhedor de sempre.",
                "Rua Atílio Chiavolone",
                "3344-2153"
            ),
            Contato(
                2,
                R.drawable.restaurante_kekantu,
                "Kekantu",
                "Restaurante",
                "No Kekantu, cada prato é preparado com ingredientes frescos e um toque especial de carinho. Servimos comidas caseiras, saborosas e bem temperadas, do jeito que você gosta! Seja para o almoço, jantar ou aquele lanche rápido, aqui você encontra qualidade, bom atendimento e um ambiente acolhedor.",
                "Av. Afonso Celestino, 260",
                "(016) 99730-1545"
            ),
            Contato(
                3,
                R.drawable.loja_malibu_modas,
                "Malibu Modas",
                "Loja",
                "Na Malibu Modas, você encontra as últimas tendências da moda com qualidade, conforto e preços que cabem no seu bolso. Trabalhamos com peças femininas e masculinas para todos os estilos e ocasiões — do casual ao elegante.",
                "Av. Manoel Gayoso, 435",
                "(016) 99607-9239"
            ),
            Contato(
                4,
                R.drawable.barbearia_atemporal,
                "Barbearia Atemporal",
                "Barbearia",
                "Na Barbearia Atemporal, unir o clássico e o moderno é o nosso diferencial. Oferecemos cortes, barbas e cuidados masculinos com qualidade, atenção e aquele ambiente acolhedor que faz você se sentir em casa.",
                "Rua Sestilio Francioli, 600",
                "(99) 99999-9999"
            ),
            Contato(
                5,
                R.drawable.padaria_sao_jose,
                "Padaria São José",
                "Padaria",
                "Na Padaria São José, cada pão é feito com carinho e aquele cheirinho irresistível de fresquinho. Oferecemos pães, bolos, doces e salgados preparados com ingredientes de qualidade e o cuidado de sempre.o",
                "Rua Atílio Chiavolone, 179",
                "(016) 33444-1526"
            ),
            Contato(
                6,
                R.drawable.gui_lanches,
                "Gui Lanches",
                "Lanchonete",
                "Na Gui Lanches, cada lanche é preparado com ingredientes frescos e muito capricho. Temos opções irresistíveis de hambúrgueres, porções, sucos e aquele refrigerante geladinho que completa o combo perfeito.",
                "Rua Domingos de Almeida, 122",
                "(016) 99715-1603"
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