package br.com.brulight.gerenciador_gastos.reciclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.brulight.gerenciador_gastos.databinding.ItemMonthBinding
import br.com.brulight.gerenciador_gastos.model.Month

class MonthListAdapter(
    private val context: Context,
    months: List<Month> = emptyList(),
    private val monthClick: (month: Month) -> Unit
) : RecyclerView.Adapter<MonthListAdapter.ViewHolder>() {

    private val months = months.toMutableList()

    inner class ViewHolder(private val binding: ItemMonthBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private lateinit var month: Month

        init {
            itemView.setOnClickListener {
                monthClick(month)
            }
        }

        fun bind(month: Month) {
            this.month = month
            binding.txtMonthName.text = month.name
            binding.txtItensCount.text = "0"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMonthBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val month = months[position]
        holder.bind(month)
    }

    override fun getItemCount(): Int = months.size

    fun update(monthList: List<Month>) {
        this.months.clear()
        this.months.addAll(monthList)
        notifyDataSetChanged()
    }
}