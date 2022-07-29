package br.com.brulight.gerenciador_gastos.ui.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import br.com.brulight.gerenciador_gastos.R
import br.com.brulight.gerenciador_gastos.databinding.ActivityMonthsBinding
import br.com.brulight.gerenciador_gastos.ui.fragment.MonthsFragment
import br.com.brulight.gerenciador_gastos.ui.fragment.MonthsFragment.MonthFragmentListener
import br.com.brulight.gerenciador_gastos.ui.fragment.NewMonthFragment

class MonthsActivity : AppCompatActivity(R.layout.activity_months), MonthFragmentListener {

    private val binding by lazy {
        ActivityMonthsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction().replace(R.id.months_container, MonthsFragment())
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

    override fun openNewMonthFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.months_container, NewMonthFragment())
            .addToBackStack(null)
            .commit()
    }
}