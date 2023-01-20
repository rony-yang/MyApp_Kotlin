package com.example.ex10_3_activity_calculate

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import java.lang.Integer.parseInt


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "메인 액티비티"

        var edtNum1 = findViewById<EditText>(R.id.edtNum1)
        var edtNum2 = findViewById<EditText>(R.id.edtNum2)
        var radioGroup1 = findViewById<RadioGroup>(R.id.radioGroup1)

        var btnNewActivity = findViewById<Button>(R.id.btnNewActivity)
        btnNewActivity.setOnClickListener {
            var intent = Intent(applicationContext, secondActivity::class.java)

            when (radioGroup1.checkedRadioButtonId) {
                R.id.radioAdd -> intent.putExtra("calculate", "+")
                R.id.radioDelete -> intent.putExtra("calculate", "-")
                R.id.radioMultiple -> intent.putExtra("calculate", "*")
                R.id.radioDivide -> intent.putExtra("calculate", "/")
                else -> {
                }
            }
                intent.putExtra("Num1", edtNum1.text.toString().toInt())
                intent.putExtra("Num2", edtNum2.text.toString().toInt())
                startActivityForResult(intent, 0)
            }
        }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            var hap = data!!.getIntExtra("Hap", 0)
            Toast.makeText(applicationContext, "결과 : $hap", Toast.LENGTH_SHORT).show()
        }
    }
}