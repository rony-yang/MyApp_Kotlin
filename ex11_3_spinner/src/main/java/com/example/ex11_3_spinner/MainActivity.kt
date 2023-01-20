package com.example.ex11_3_spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "스피너 테스트"
        
        var movie = arrayOf("써니","완득이","괴물","라디오스타","비열한거리","왕의남자","아일랜드",
            "웰컴투동막골","헬보이","빽투더퓨처")
        var posterID = arrayOf(
            R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04,
            R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08,
            R.drawable.mov09, R.drawable.mov10
        )

        var spinner = findViewById<Spinner>(R.id.spinner1)
        
        var adapter: ArrayAdapter<String>
        adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, movie)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.onItem


    }
}