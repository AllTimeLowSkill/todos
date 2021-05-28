package com.example.learnfrag

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (supportFragmentManager.findFragmentById(R.id.todo_list_fragment) == null) {
            val fragment = TodoListFragment.newInstance()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.main_container, fragment)
                .commit()
        }

        val addTodoBtn = findViewById<Button>(R.id.add_todo_btn)
        addTodoBtn.setOnClickListener {
            val addTodo = AddTodoFragment()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container, addTodo)
                .addToBackStack(UUID.randomUUID().toString())
                .commit()
        }
    }
}