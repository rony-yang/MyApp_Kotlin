package com.example.ex10_3_activity_calculate

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity

class secondActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second)
        title = "Second 액티비티"

        var inIntent = intent
        var calculate = inIntent.getStringExtra("calculate")

        var calValue = 0
        if (calculate == "+") {
            calValue = inIntent.getIntExtra("Num1", 0) + inIntent.getIntExtra("Num2", 0)
        } else if (calculate == "-") {
            calValue = inIntent.getIntExtra("Num1", 0) - inIntent.getIntExtra("Num2", 0)
        } else if (calculate == "*") {
            calValue = inIntent.getIntExtra("Num1", 0) * inIntent.getIntExtra("Num2", 0)
        } else {
            calValue = inIntent.getIntExtra("Num1", 0) / inIntent.getIntExtra("Num2", 0)
        }

        var btnReturn = findViewById<Button>(R.id.btnReturn)
        btnReturn.setOnClickListener {
            var outIntent = Intent(applicationContext, MainActivity::class.java)
            outIntent.putExtra("Hap", calValue)
            setResult(AppCompatActivity.RESULT_OK, outIntent)
            finish()
        }
    }
}