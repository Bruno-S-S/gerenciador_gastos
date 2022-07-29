package br.com.brulight.gerenciador_gastos.database.dao

import androidx.room.Dao
import androidx.room.Insert
import br.com.brulight.gerenciador_gastos.model.Expense

@Dao
interface ExpenseDAO {

    @Insert
    suspend fun insertExpense(expense: Expense)
}