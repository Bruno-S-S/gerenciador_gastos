package br.com.brulight.gerenciador_gastos.reciclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import br.com.brulight.gerenciador_gastos.databinding.ItemExpenseBinding
import br.com.brulight.gerenciador_gastos.model.Expense

class ExpenseListAdapter(
    private val context: Context,
    expenses: List<Expense> = emptyList()
) : RecyclerView.Adapter<ExpenseListAdapter.ViewHolder>() {

    private val expenses = expenses.toMutableList()

    inner class ViewHolder(private val binding: ItemExpenseBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private lateinit var expense: Expense

        init {
            itemView.setOnClickListener {
                Toast.makeText(
                    context,
                    "Esté o mês certo? ${expense.name} ${expense.value}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        fun bind(expense: Expense) {
            this.expense = expense
            binding.txtItemExpenseName.text = expense.name
            binding.txtItemExpenseValue.text = expense.value.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemExpenseBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val expense = expenses[position]
        holder.bind(expense)
    }

    override fun getItemCount(): Int = expenses.size

    fun update(expenseList: List<Expense>) {
        this.expenses.clear()
        this.expenses.addAll(expenseList)
        notifyDataSetChanged()
    }
}