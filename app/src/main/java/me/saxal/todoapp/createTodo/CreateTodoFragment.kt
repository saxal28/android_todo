package me.saxal.todoapp.createTodo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import me.saxal.todoapp.R
import me.saxal.todoapp.databinding.FragmentCreateTodoBinding

class CreateTodoFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // View Model
        val binding: FragmentCreateTodoBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_create_todo, container, false)
        val viewModel: CreateTodoViewModel = ViewModelProviders.of(activity!!).get(CreateTodoViewModel::class.java)
        binding.lifecycleOwner = activity
        binding.viewModel = viewModel

        return binding.root
    }

}