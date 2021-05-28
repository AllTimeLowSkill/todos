package com.example.learnfrag

import androidx.lifecycle.ViewModel

class TodoViewModel : ViewModel() {
    var todos = mutableListOf<Todo>()

    init {
        for (i in 0 until 100) {
            val todo = Todo()

            todo.title = "todo #${ i  }"

            todos += todo
        }
    }
}