package br.com.brulight.gerenciador_gastos.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import br.com.brulight.gerenciador_gastos.databinding.FragmentExpensesBinding
import br.com.brulight.gerenciador_gastos.model.Month
import br.com.brulight.gerenciador_gastos.reciclerview.adapter.ExpenseListAdapter
import br.com.brulight.gerenciador_gastos.ui.activity.MONTH_KEY

class ExpensesFragment : Fragment() {

    private lateinit var binding: FragmentExpensesBinding

    private var month: Month? = null

    private val adapter by lazy {
        context?.let {
            ExpenseListAdapter(it)
        } ?: throw IllegalArgumentException("Contexto inválido")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getExtra()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentExpensesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupReciclerView()
        setFabAction()
        activity?.title = "${month?.name} de ${month?.year}"
    }

    private fun setupReciclerView() {
        binding.rcvExpensesList.adapter = adapter
    }

    private fun setFabAction() {
        binding.fabNewExpense.setOnClickListener {
            Toast.makeText(context, "Clicou no FAB do dinheirinho", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getExtra() {
        month = activity?.intent?.getParcelableExtra(MONTH_KEY)
    }
}