package com.example.recyclerviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MyAdapter.OnItemClickListener {
    private lateinit var binding : ActivityMainBinding

    private val studentList = listOf(
        Student("W001", "John", "RST", "M"),
        Student("W002", "Alex", "RST", "M"),
        Student("W003", "Mark", "RST", "M"),
        Student("W004", "Alice", "RST", "F"),
        Student("W005", "Steven", "RST", "M"),
        Student("W006", "Ken", "RST", "M"),
        Student("W007", "Stella", "RST", "F")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = MyAdapter(studentList, this)

        binding.studentRecyclerView.adapter = adapter
        binding.studentRecyclerView.layoutManager = LinearLayoutManager(applicationContext)
        binding.studentRecyclerView.setHasFixedSize(true)
    }

    override fun itemClick(position: Int) {
        //...
        val selectStudent = studentList[position]
        Toast.makeText(this, selectStudent.name, Toast.LENGTH_SHORT).show()
    }
}