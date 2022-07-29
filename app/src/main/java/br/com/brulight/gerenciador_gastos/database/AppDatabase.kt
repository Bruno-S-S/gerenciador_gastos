package br.com.brulight.gerenciador_gastos.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.com.brulight.gerenciador_gastos.converter.Converters
import br.com.brulight.gerenciador_gastos.database.dao.ExpenseDAO
import br.com.brulight.gerenciador_gastos.database.dao.MonthDAO
import br.com.brulight.gerenciador_gastos.model.Expense
import br.com.brulight.gerenciador_gastos.model.Month

@Database(
    entities = [
        Month::class,
        Expense::class
    ],
    version = 1,
    exportSchema = true
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun monthDAO(): MonthDAO

    abstract fun expenseDAO(): ExpenseDAO
}