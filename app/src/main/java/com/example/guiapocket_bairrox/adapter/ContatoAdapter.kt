package com.example.guiapocket_bairrox.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.guiapocket_bairrox.databinding.ItemServicoBinding
import com.example.guiapocket_bairrox.model.Contato

class ContatoAdapter(
    context: Context,
    lista: List<Contato>
) : ArrayAdapter<Contato>(context, 0, lista) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding: ItemServicoBinding
        val itemView: View
        if (convertView == null) {
            binding = ItemServicoBinding.inflate(LayoutInflater.from(context), parent, false)
            itemView = binding.root
            itemView.tag = binding
        } else {
            itemView = convertView
            binding = itemView.tag as ItemServicoBinding
        }

        val contato = getItem(position)

        if (contato != null) {
            if (contato.imagemUri.isNotBlank()) {
                binding.imgFoto.setImageURI(Uri.parse(contato.imagemUri))
            }
            binding.tvNome.text = contato.nome
            binding.tvCategoria.text = contato.categoria
        }

        return itemView
    }
}
