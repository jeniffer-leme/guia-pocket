package com.example.guiapocket_bairrox.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.guiapocket_bairrox.model.Contato

@Database(
    entities = [Contato::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun contatoDao(): ContatoDao

    companion object {
        // A anotação @Volatile garante que a variável INSTANCE seja sempre atualizada
        // e visível para todas as threads.
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            // O operador ?: (elvis) retorna a instância se ela não for nula,
            // ou executa o bloco synchronized para criá-la se for nula.
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "guia_pocket_db"
                )
                // AVISO: allowMainThreadQueries() é um atalho para evitar o erro de crash.
                // Em um app real, as queries devem ser feitas em uma background thread (ex: com Coroutines).
                .allowMainThreadQueries()
                .build()
                INSTANCE = instance
                // Retorna a instância recém-criada.
                instance
            }
        }
    }
}
