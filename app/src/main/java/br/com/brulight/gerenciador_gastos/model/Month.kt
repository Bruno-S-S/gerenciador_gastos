package br.com.brulight.gerenciador_gastos.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Month(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val name: String,
    val year: Int
)
