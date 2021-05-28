package com.example.learnfrag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*


class TodoListFragment : Fragment() {
    private lateinit var todoList: RecyclerView

    private var adapter: TodoAdapter? = null
    private val todoViewModel: TodoViewModel by lazy {
        ViewModelProviders.of(this).get(TodoViewModel :: class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_todo_list, container, false)
        todoList =view.findViewById(R.id.todo_list_fragment) as RecyclerView
        todoList.layoutManager = LinearLayoutManager(context)
        updateUI()
        return view
    }

    private fun updateUI() {
        val todos = todoViewModel.todos
        adapter = TodoAdapter(todos)
        todoList.adapter = adapter
    }

    private inner class TodoAdapter(var todos: List<Todo>) : RecyclerView.Adapter<TodoHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoHolder {
            val view = layoutInflater.inflate(R.layout.fragment_todo_item_list, parent, false)
            return TodoHolder(view)
        }

        override fun onBindViewHolder(
            holder: TodoHolder,
            position: Int,
        ) {
            val todo = todos[position]
            holder.apply {
                titleTodo.text = todo.title
                dateTodo.text = todo.date.toString()
            }
        }

        override fun getItemCount(): Int  = todos.size
    }

    private inner class TodoHolder(view : View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        val titleTodo: TextView = itemView.findViewById(R.id.todo_title)
        val dateTodo: TextView = itemView.findViewById(R.id.todo_date)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            Toast.makeText(context, "${titleTodo.text} passed", Toast.LENGTH_SHORT).show()

            val bundle = Bundle()
            bundle.putString("title", titleTodo.text.toString())
            bundle.putString("date", dateTodo.text.toString())

            val detail = DetailTodoFragment()
            detail.arguments = bundle
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.main_container, detail)
                .addToBackStack(UUID.randomUUID().toString())
                .commit()


        }
    }

    companion object {
        fun newInstance() = TodoListFragment()
    }

}