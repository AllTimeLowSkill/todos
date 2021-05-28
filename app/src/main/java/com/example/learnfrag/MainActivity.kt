package com.example.learnfrag

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

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
    }
}