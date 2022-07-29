package br.com.brulight.gerenciador_gastos.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal

@Entity
data class Expense(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val name: String,
    val value: BigDecimal,
    val monthId: Long,
    val description: String
)
