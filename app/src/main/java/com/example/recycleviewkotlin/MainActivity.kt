package com.example.recycleviewkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycleviewkotlin.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val todoList = mutableListOf(
            Todo("Follow my youtube",false),
            Todo("Learn about Recycle View",true),
            Todo("Take care my dog",false),
            Todo("Take the trash",true),
            Todo("Learn React with documentation",false),
            Todo("Walk with me",false),
            Todo("Watch movie and eat popcorm",false)
        )

        val adapter = TodoAdapter(todoList)
        binding.rvTodo.adapter = adapter
        binding.rvTodo.layoutManager = LinearLayoutManager(this)

        binding.btnAddTodo.setOnClickListener {
            val title = binding.etTodo.text.toString()
            val todo = Todo(title,false)
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size-1)
        }
    }
}