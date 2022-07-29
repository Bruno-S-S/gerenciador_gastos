package br.com.brulight.gerenciador_gastos.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import br.com.brulight.gerenciador_gastos.database.dao.MonthDAO
import br.com.brulight.gerenciador_gastos.model.Month

class MonthViewModel(
    private val monthDAO: MonthDAO
) : ViewModel() {

    fun allMonths(): LiveData<List<Month>> = monthDAO.getAllMonths()
}