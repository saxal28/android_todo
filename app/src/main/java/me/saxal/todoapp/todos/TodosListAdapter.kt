package me.saxal.todoapp.todos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import me.saxal.todoapp.databinding.CellTodoBinding
import me.saxal.todoapp.databinding.CellTodoHeaderBinding

abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: T)
}

class TodosListAdapter(private val myDataset: List<TodoModel>) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {

    companion object {
        private const val TYPE_HEADER = 0
        private const val TYPE_ITEM = 1
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> TYPE_HEADER
            else -> TYPE_ITEM
        }
    }

    inner class HeaderViewHolder(private val binding: CellTodoHeaderBinding) :
        BaseViewHolder<TodoModel>(binding.root) {
        override fun bind(item: TodoModel) {
            binding.name = "hi"
        }
    }

    inner class TodoViewHolder(val binding: CellTodoBinding) :
        BaseViewHolder<TodoModel>(binding.root) {

        override fun bind(item: TodoModel) {
            binding.todo = item
        }
    }

    // Create new views (invoked by the layout manager
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<*> {

        if (viewType == TYPE_HEADER) {
            val inflater = LayoutInflater.from(parent.context)
            val binding = CellTodoHeaderBinding.inflate(inflater, parent, false)
            return HeaderViewHolder(binding)
        } else {
            val inflater = LayoutInflater.from(parent.context)
            val binding = CellTodoBinding.inflate(inflater, parent, false)
            return TodoViewHolder(binding)
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = myDataset.size + 1

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        val element = if (position == 0) myDataset[0] else myDataset[position - 1];

        when (holder) {
            is HeaderViewHolder -> holder.bind(element)
            is TodoViewHolder -> holder.bind(element)
        }
    }
}