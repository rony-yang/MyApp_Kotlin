package com.example.ex10_1_activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnNewActivity = findViewById<Button>(R.id.btnNewActibity)
        var radioGroup1 = findViewById<RadioGroup>(R.id.radioGroup1)
        var radioBtnSecond = findViewById<RadioButton>(R.id.radioBtnSecond)
        var radioBtnThird = findViewById<RadioButton>(R.id.radioBtnThird)

        btnNewActivity.setOnClickListener {
            when (radioGroup1.checkedRadioButtonId) {
                R.id.radioBtnSecond -> {
                    var intent = Intent(applicationContext, SecondActivity::class.java)
                    startActivity(intent)
                }
                R.id.radioBtnThird -> {
                    var intent = Intent(applicationContext, ThirdActivity::class.java)
                    startActivity(intent)
                }
                else -> Toast.makeText(applicationContext,
                    "액티비티를 먼저 선택하세요", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
