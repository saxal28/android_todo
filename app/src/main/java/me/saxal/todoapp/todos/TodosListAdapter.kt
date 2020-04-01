package me.saxal.todoapp.todos

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import me.saxal.todoapp.R

private const val TYPE_HEADER = 0
private const val TYPE_ITEM = 1

class TodosListAdapter(private val myDataset: List<TodoModel>) :
    RecyclerView.Adapter<TodosListAdapter.MyViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        Log.i("VIEWMODEL", position.toString())
        return when(position) {
            0 -> TYPE_HEADER
            else -> TYPE_ITEM
        }
    }

    init {
        Log.i("VIEWMODEL", myDataset.toString())
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
    class MyViewHolder(val textView: LinearLayout) : RecyclerView.ViewHolder(textView)

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MyViewHolder {

        if(viewType == TYPE_HEADER) {
            val textView = LayoutInflater.from(parent.context)
                .inflate(R.layout.cell_todo_header, parent, false) as LinearLayout
            // set the view's size, margins, paddings and layout parameters
            return MyViewHolder(textView)
        } else {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.cell_todo, parent, false) as LinearLayout
            // set the view's size, margins, paddings and layout parameters
            return MyViewHolder(view)
        }
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
//        holder.textView.text = myDataset[position]
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = myDataset.size + 1
}