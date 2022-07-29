package br.com.brulight.gerenciador_gastos.ui.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import br.com.brulight.gerenciador_gastos.R
import br.com.brulight.gerenciador_gastos.ui.fragment.ExpensesFragment

class ExpensesActivity : AppCompatActivity(R.layout.activity_expenses) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.expenses_container, ExpensesFragment())
            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_meses, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.menu_item_close -> {
                finish()
            }
        }

        return super.onOptionsItemSelected(item)
    }
}