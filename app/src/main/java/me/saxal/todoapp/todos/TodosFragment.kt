package me.saxal.todoapp.todos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import me.saxal.todoapp.R
import me.saxal.todoapp.databinding.FragmentTodosBinding


class TodosFragment: Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate the layout for this fragment
        val binding: FragmentTodosBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_todos, container, false)
        val viewModel: TodosViewModel = ViewModelProviders.of(activity!!).get(TodosViewModel::class.java)
        binding.lifecycleOwner = activity
        binding.viewModel = viewModel

        viewManager = LinearLayoutManager(this.context)
        viewAdapter = TodosListAdapter(viewModel.todos, viewModel = viewModel)

        // inflate recycler view
        recyclerView = binding.root.findViewById<RecyclerView>(R.id.todos_recycler).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        } as RecyclerView

        viewModel.navigateToCreate.observe(viewLifecycleOwner, Observer {
            if(viewModel.navigateToCreate.value == true) {
                val action = TodosFragmentDirections.actionTodosFragmentToCreateTodoFragment()
                findNavController().navigate(action)
                viewModel.doneNavigatingToCreate()
            }
        })

        return binding.root
    }
}