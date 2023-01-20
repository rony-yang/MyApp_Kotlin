package com.example.ex04_3_gugudan

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    /*이곳은 MainActivity 클래스의 멤버변수 영역*/

    @SuppressLint("ClickableViewAccessibility", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        /*이곳은 onCreate의 메소드 영역*/

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        var edt1 = findViewById<EditText>(R.id.edt1);
        var edt2 = findViewById<EditText>(R.id.edt2);
        var btn1 = findViewById<Button>(R.id.btn1);
        var btn2 = findViewById<Button>(R.id.btn2);
        var btn3 = findViewById<Button>(R.id.btn3);
        var btn4 = findViewById<Button>(R.id.btn4);
        var btn5 = findViewById<Button>(R.id.btn5);

        var tv1 = findViewById<TextView>(R.id.tv1);

        /*btn1.setOnClickListener {
            //실행할 내용 작성
            var num1 = edt1.text.toString();
            var num2 = edt2.text.toString();
            //var num2 = edt2.getText().toString();   //getText() 함수를 강제로 지정해줄수도있음. text = getText()

            //var res = Integer.parseInt(num1) + Integer.parseInt(num2)   // 이렇게 써도 되는데 굳이 ㄴㄴ, 그냥 이렇게 쓸 수 있다는 것만 알아두면 된다.
            var res = num1.toInt() + num2.toInt();

            *//*출력*//*
            //tv1.setText(res);
            //tv1.text = res.toString();
            tv1.text = "계산결과 : " + res;    //setText, getText 를 할 필요 없이 그냥 text를 쓰면 된다.

        }*/

        btn1.setOnTouchListener { view, motionEvent ->
            var num1 = edt1.text.toString();
            var num2 = edt2.text.toString();

            //var res = Integer.parseInt(num1) + Integer.parseInt(num2);
            var res = num1.toInt() + num2.toInt();
            tv1.text = "계산결과 : " + res.toString();
            false
        }

        btn2.setOnClickListener {
            var num1 = edt1.text.toString();
            var num2 = edt2.text.toString();

            var res = num1.toInt() - num2.toInt();

            tv1.text = "계산결과 : " + res;

        }

        btn3.setOnClickListener {
            var num1 = edt1.text.toString();
            var num2 = edt2.text.toString();

            var res = num1.toInt() * num2.toInt();

            tv1.text = "계산결과 : " + res;
        }

        btn4.setOnTouchListener { view, motionEvent ->

            var num1 = edt1.text.toString();
            var num2 = edt2.text.toString();

            if(num1.trim() == "" || num2.trim() == "") {
                Toast.makeText(this,"빈값있음!", Toast.LENGTH_SHORT).show();
                false;
            } else {
                if(num2.trim() == "0") {
                    Toast.makeText(this,"0으로 나눌 수 없습니다", Toast.LENGTH_SHORT).show();
                    return@setOnTouchListener false
                }
                var res = num1.toDouble() / num2.toDouble();
                res = (res*100).toInt() / 100.0;
                tv1.text = "계산결과 : " + res;
                false;
            }
        }

        btn5.setOnClickListener {
            var num1 = edt1.text.toString();
            var num2 = edt2.text.toString();

            var res = num1.toInt() % num2.toInt();

            tv1.text = "계산결과 : " + res;
        }

    }
}