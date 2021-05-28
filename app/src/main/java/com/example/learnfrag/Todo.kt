package com.example.learnfrag

import java.util.*

data class Todo(val id: UUID = UUID.randomUUID(), var title: String = "", var date: Date = Date(), var desc: String = "", var isComplited: Boolean = false) {
}