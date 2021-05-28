package com.example.learnfrag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class DetailTodoFragment : Fragment() {

    private lateinit var title: TextView
    private lateinit var date: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_detail_todo, container, false)
        title = view.findViewById(R.id.detail_title) as TextView
        date = view.findViewById(R.id.detail_date) as TextView

        val titleVal = arguments?.getString("title")
        val dateVal = arguments?.getString("date")
        title.text = titleVal
        date.text = dateVal
        return  view
    }

    companion object {
        fun newInstance() = DetailTodoFragment()

    }
}