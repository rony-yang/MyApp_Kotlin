package com.example.ex05_project2_calculate

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "계산기"

        var Edit1 = findViewById<EditText>(R.id.Edit1)
        var Edit2 = findViewById<EditText>(R.id.Edit2)
        var numButtons = ArrayList<Button>(10)
        var numBtnIDs = arrayOf(R.id.BtnNum0, R.id.BtnNum1, R.id.BtnNum2, R.id.BtnNum3,
                                R.id.BtnNum4, R.id.BtnNum5, R.id.BtnNum6, R.id.BtnNum7,
                                R.id.BtnNum8, R.id.BtnNum9)

        var BtnAdd = findViewById<Button>(R.id.BtnAdd)
        var BtnDelete = findViewById<Button>(R.id.BtnDelete)
        var BtnMultiple = findViewById<Button>(R.id.BtnMultiple)
        var BtnDivide = findViewById<Button>(R.id.BtnDivide)

        var TextResult = findViewById<TextView>(R.id.TextResult)

        for (i in 0..9 step 1) {
            numButtons.add(findViewById<Button>(numBtnIDs[i]))
        }

        for (i in 0..numBtnIDs.size-1 step 1) {
            numButtons[i].setOnClickListener {
                if (Edit1.isFocused == true) {
                    var num1 = Edit1.text.toString() + numButtons[i].getText().toString()
                    Edit1.setText(num1)
                } else if (Edit2.isFocused == true) {
                    var num2 = Edit2.text.toString() + numButtons[i].getText().toString()
                    Edit2.setText(num2)
                } else {
                    Toast.makeText(applicationContext, "먼저 숫자를 선택하세요", Toast.LENGTH_SHORT).show()
                }
            }
        }



        BtnAdd.setOnTouchListener { view, motionEvent ->
            var num1 = Edit1.text.toString();
            var num2 = Edit2.text.toString();

            var Result = Integer.parseInt(num1) + Integer.parseInt(num2);
            TextResult.text = "계산결과 : " + Result.toString();
            false
        }

        BtnDelete.setOnTouchListener { view, motionEvent ->
            var num1 = Edit1.text.toString();
            var num2 = Edit2.text.toString();

            var Result = Integer.parseInt(num1) - Integer.parseInt(num2);
            TextResult.text = "계산결과 : " + Result.toString();
            false
        }

        BtnMultiple.setOnTouchListener { view, motionEvent ->
            var num1 = Edit1.text.toString();
            var num2 = Edit2.text.toString();

            var Result = Integer.parseInt(num1) * Integer.parseInt(num2);
            TextResult.text = "계산결과 : " + Result.toString();
            false
        }

        BtnDivide.setOnTouchListener { view, motionEvent ->
            var num1 = Edit1.text.toString();
            var num2 = Edit2.text.toString();

            if(num2.trim() == "0") {
                Toast.makeText(this,"0으로 나눌 수 없습니다", Toast.LENGTH_SHORT).show();
                return@setOnTouchListener false
            }
            var res = num1.toDouble() / num2.toDouble();
            res = (res*100).toInt() / 100.0;
            TextResult.text = "계산결과 : " + res;
            false;
        }























    }
}