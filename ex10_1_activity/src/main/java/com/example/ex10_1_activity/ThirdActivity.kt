package com.example.ex10_1_activity


import android.app.Activity
import android.os.Bundle
import android.widget.Button

class ThirdActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.third)

        var btnReturn2 = findViewById<Button>(R.id.btnReturn2)
        btnReturn2.setOnClickListener {
            finish()
        }
    }

}