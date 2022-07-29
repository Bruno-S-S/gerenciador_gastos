package br.com.brulight.gerenciador_gastos.model

import androidx.room.Embedded
import androidx.room.Relation

data class MonthWithExpensive(
    @Embedded
    val month: Month,
    @Relation(
        parentColumn = "id",
        entityColumn = "monthId"
    )
    val expenses: List<Expense>
)
