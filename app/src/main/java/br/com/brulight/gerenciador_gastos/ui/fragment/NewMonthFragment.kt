package br.com.brulight.gerenciador_gastos.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import br.com.brulight.gerenciador_gastos.databinding.FragmentNewMonthBinding
import br.com.brulight.gerenciador_gastos.extensions.monthNumberToText
import br.com.brulight.gerenciador_gastos.model.Month
import br.com.brulight.gerenciador_gastos.viewmodel.NewMonthViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewMonthFragment : Fragment() {

    private val viewModel: NewMonthViewModel by viewModel()

    private lateinit var binding: FragmentNewMonthBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentNewMonthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.title = "Adicionar mês"
        setBtnSelectAction()
    }

    private fun setBtnSelectAction() {
        binding.btnFragmentNewMonthSelect.setOnClickListener {
            lifecycleScope.launch {
                viewModel.createMonth(
                    Month(
                        name = binding.dtpMonth.month.monthNumberToText(),
                        year = binding.dtpMonth.year
                    )
                )
                activity?.supportFragmentManager?.popBackStack()
            }
        }
    }
}