package com.example.guiapocket_bairrox.adapter

import android.annotation.SuppressLint
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.guiapocket_bairrox.databinding.ItemServicoBinding
import com.example.guiapocket_bairrox.model.Contato

class ContatoRecyclerAdapter(
    private var contatos: List<Contato>,
    private val onClick: (Contato) -> Unit
) : RecyclerView.Adapter<ContatoRecyclerAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemServicoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemServicoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = contatos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contato = contatos[position]

        if (contato.imagemUri.isNotBlank()) {
            holder.binding.imgFoto.setImageURI(Uri.parse(contato.imagemUri))
        }

        holder.binding.tvNome.text = contato.nome
        holder.binding.tvCategoria.text = contato.categoria

        holder.itemView.setOnClickListener {
            onClick(contato)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(novaLista: List<Contato>) {
        contatos = novaLista
        notifyDataSetChanged()
    }
}