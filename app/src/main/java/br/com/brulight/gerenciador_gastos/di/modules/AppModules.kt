package br.com.brulight.gerenciador_gastos.di.modules

import androidx.room.Room
import br.com.brulight.gerenciador_gastos.database.AppDatabase
import br.com.brulight.gerenciador_gastos.viewmodel.MonthViewModel
import br.com.brulight.gerenciador_gastos.viewmodel.NewMonthViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private const val DB_NAME = "gerenciadorGastos.db"

val appModules = module {

    single {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            DB_NAME
        ).build()
    }

    single {
        get<AppDatabase>().monthDAO()
    }

    single {
        get<AppDatabase>().expenseDAO()
    }

    viewModel {
        MonthViewModel(get())
    }

    viewModel {
        NewMonthViewModel(get())
    }

}