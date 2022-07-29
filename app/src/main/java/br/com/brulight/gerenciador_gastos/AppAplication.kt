package br.com.brulight.gerenciador_gastos

import android.app.Application
import br.com.brulight.gerenciador_gastos.di.modules.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppAplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@AppAplication)
            modules(appModules)
        }
    }
}