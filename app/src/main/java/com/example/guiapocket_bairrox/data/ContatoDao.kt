package com.example.guiapocket_bairrox.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.guiapocket_bairrox.model.Contato

@Dao
interface ContatoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserir(contato: Contato)

    @Query("SELECT * FROM contatos ORDER BY nome ASC")
    fun getAll(): LiveData<List<Contato>> // <-- CORRIGIDO: Retorna LiveData e não é suspend

    @Query("SELECT * FROM contatos WHERE nome LIKE '%' || :texto || '%' ORDER BY nome ASC")
    fun filtrarPorNome(texto: String): LiveData<List<Contato>> // <-- CORRIGIDO: Para uso futuro com busca
}