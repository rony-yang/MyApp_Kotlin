package com.example.ex04_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "안드로이드 사진 보기"

        var text1 = findViewById<TextView>(R.id.Text1)
        var text2 = findViewById<TextView>(R.id.Text2)
        var SwAgree = findViewById<Switch>(R.id.SwAgree)

        var rGroup1 = findViewById<RadioGroup>(R.id.Rgroup1)
        var RdoOreo = findViewById<RadioButton>(R.id.RdoOreo)
        var RdoPie = findViewById<RadioButton>(R.id.RdoPie)
        var RdoQ10 = findViewById<RadioButton>(R.id.RdoQ10)
        var ImgAnd = findViewById<ImageView>(R.id.ImgAnd)

        var BtnClose = findViewById<Button>(R.id.BtnClose)
        var BtnStart = findViewById<Button>(R.id.BtnStart)

        SwAgree.setOnCheckedChangeListener { compoundButton, b ->

            if (SwAgree.isChecked) {
                text2.visibility = View.VISIBLE
                rGroup1.visibility = View.VISIBLE
                ImgAnd.visibility = View.VISIBLE
                BtnClose.visibility = View.VISIBLE
                BtnStart.visibility = View.VISIBLE

            } else {
                text2.visibility = View.INVISIBLE
                rGroup1.visibility = View.INVISIBLE
                ImgAnd.visibility = View.INVISIBLE
                BtnClose.visibility = View.INVISIBLE
                BtnStart.visibility = View.INVISIBLE
            }
        }
        // 라디오버튼을 선택할때마다 즉시 해당이미지가 나오도록 변경한다
        RdoOreo.setOnClickListener {
            ImgAnd.setImageResource(R.drawable.oreo)
        }

        RdoPie.setOnClickListener {
            ImgAnd.setImageResource(R.drawable.pie)
        }

        RdoQ10.setOnClickListener {
            ImgAnd.setImageResource(R.drawable.q10)
        }


        // 종료 버튼을 누르면 응용 프로그램이 완전히 종료되도록 설정
        BtnClose.setOnClickListener {
            finish()
        }

        // 처음으로 버튼을 누르면 초기화하여 처음 화면이 나오도록 한다
        BtnStart.setOnClickListener {
            text2.visibility = android.view.View.INVISIBLE
            rGroup1.visibility = android.view.View.INVISIBLE
            ImgAnd.visibility = android.view.View.INVISIBLE
            BtnClose.visibility = android.view.View.INVISIBLE
            BtnStart.visibility = android.view.View.INVISIBLE

            // 스위치 체크 해제
            SwAgree.isChecked = false
            // 라디오그룹 버튼 해제
            rGroup1.clearCheck()
            // 이미지 체크 해제
            ImgAnd.setImageResource(0)

        }


    }
}