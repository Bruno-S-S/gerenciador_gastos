package br.com.brulight.gerenciador_gastos.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import br.com.brulight.gerenciador_gastos.databinding.FragmentMonthsBinding
import br.com.brulight.gerenciador_gastos.model.Month
import br.com.brulight.gerenciador_gastos.reciclerview.adapter.MonthListAdapter
import br.com.brulight.gerenciador_gastos.viewmodel.MonthViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MonthsFragment : Fragment() {

    private val adapter by lazy {
        context?.let {
            MonthListAdapter(context = it, monthClick = listener::openExpenseFragment)
        } ?: throw IllegalArgumentException("Contexto inválido")
    }

    private val viewModel: MonthViewModel by viewModel()

    private lateinit var listener: MonthFragmentListener
    private lateinit var binding: FragmentMonthsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        searchMonths()
        listener = activity as MonthFragmentListener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMonthsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupReciclerView()
        setFabAction()
        activity?.title = "Controle de gastos"
    }

    private fun setFabAction() {
        binding.fabNewMonth.setOnClickListener {
            listener.openNewMonthFragment()
        }
    }

    private fun setupReciclerView() {
        binding.rcvMonthList.adapter = adapter
    }

    private fun searchMonths() {
        lifecycleScope.launch {
            viewModel.allMonths().observe(this@MonthsFragment) { months ->
                months.let { adapter.update(it) }
            }
        }
    }

    interface MonthFragmentListener {
        fun openNewMonthFragment()
        fun openExpenseFragment(month: Month)
    }
}