package com.example.ex06_2_viewflipper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.ViewFlipper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnPrev = findViewById<Button>(R.id.btnPrev)
        var btnStop = findViewById<Button>(R.id.btnStop)
        var viewFli1 = findViewById<ViewFlipper>(R.id.viewFli1)
        var api50 = findViewById<ImageView>(R.id.api50)
        var api60 = findViewById<ImageView>(R.id.api60)
        var api70 = findViewById<ImageView>(R.id.api70)

        btnPrev.setOnClickListener {
            viewFli1.startFlipping()
            viewFli1.flipInterval = 1000
        }

        btnStop.setOnClickListener {
            viewFli1.stopFlipping()
        }
    }
}