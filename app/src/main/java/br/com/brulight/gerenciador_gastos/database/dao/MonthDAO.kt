package br.com.brulight.gerenciador_gastos.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import br.com.brulight.gerenciador_gastos.model.Month
import br.com.brulight.gerenciador_gastos.model.MonthWithExpensive

@Dao
interface MonthDAO {

    @Insert
    suspend fun insertMonth(month: Month)

    @Query("SELECT * FROM Month WHERE id = 1")
    fun getMonth(): LiveData<Month?>

    @Query("SELECT * FROM Month")
    fun getAllMonths(): LiveData<List<Month>>

    @Transaction
    @Query("SELECT * FROM Month")
    fun getMonthWithExpenses(): LiveData<List<MonthWithExpensive?>>
}