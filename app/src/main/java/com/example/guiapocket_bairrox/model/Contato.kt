package com.example.guiapocket_bairrox.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Contato(
    val id: Int,
    val foto: Int,
    val nome: String,
    val categoria: String,
    val descricao: String,
    val endereco: String,
    val telefone: String
) : Parcelable