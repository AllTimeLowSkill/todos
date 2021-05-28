package com.example.learnfrag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AddTodoFragment : Fragment() {
    private lateinit var editTitle: EditText
    private lateinit var editDate: EditText
    private lateinit var addButton: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_todo, container, false)
        editTitle = view.findViewById(R.id.editTitle) as EditText
        editDate = view.findViewById(R.id.editTextDate) as EditText
        addButton = view.findViewById(R.id.edit_add_btn) as Button

        addButton.setOnClickListener {
            val title = editTitle.text.toString()

            val newTodo = Todo(title = title)

            Toast.makeText(context, "${newTodo.title} created!", Toast.LENGTH_SHORT).show()

        }

        return view

    }

    companion object {
        fun newInstance() = AddTodoFragment()
    }
}