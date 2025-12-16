package com.example.guiapocket_bairrox.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "contatos")
data class Contato(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val imagemUri: String,
    val nome: String,
    val categoria: String,
    val descricao: String,
    val endereco: String,
    val telefone: String
) : Parcelable
