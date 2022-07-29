package br.com.brulight.gerenciador_gastos.viewmodel

import androidx.lifecycle.ViewModel
import br.com.brulight.gerenciador_gastos.database.dao.MonthDAO
import br.com.brulight.gerenciador_gastos.model.Month

class NewMonthViewModel(
    private val monthDAO: MonthDAO
) : ViewModel() {

    suspend fun createMonth(month: Month): Boolean {

        return try {
            monthDAO.insertMonth(month)
            true
        } catch (ex: Exception) {
            false
        }
    }
}