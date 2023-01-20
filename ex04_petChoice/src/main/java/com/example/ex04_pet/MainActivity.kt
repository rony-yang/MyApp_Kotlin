package com.example.ex04_pet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "애완동물 사진 보기"

        var text1 = findViewById<TextView>(R.id.Text1)
        var ChkAgree = findViewById<CheckBox>(R.id.ChkAgree)
        var text2 = findViewById<TextView>(R.id.Text2)
        var rGroup1 = findViewById<RadioGroup>(R.id.Rgroup1)
        var rdoDog = findViewById<RadioButton>(R.id.RdoDog)
        var rdoCat = findViewById<RadioButton>(R.id.RdoCat)
        var rdoRabbit = findViewById<RadioButton>(R.id.RdoRabbit)

        var btnOK = findViewById<Button>(R.id.BtnOK)
        var imgPet = findViewById<ImageView>(R.id.ImgPet)

        ChkAgree.setOnCheckedChangeListener { compoundButton, b ->
            // 1. 결과적으로 체크가 되었으면
//             if(ChkAgree.isChecked == true) { true를 구지 넣지 않아도 값을 가지고 있다
            if(ChkAgree.isChecked) {
                text2.visibility = View.VISIBLE
                rGroup1.visibility = View.VISIBLE
                btnOK.visibility = View.VISIBLE
                imgPet.visibility = View.VISIBLE
                // 2. 결과적으로 체크가 해지 되었으면
            } else {
                text2.visibility = View.INVISIBLE
                rGroup1.visibility = View.INVISIBLE
                btnOK.visibility = View.INVISIBLE
                imgPet.visibility = View.INVISIBLE
            }
        }

        btnOK.setOnClickListener {
            when (rGroup1.checkedRadioButtonId) { // Id를 정수값으로 받는다
                R.id.RdoDog -> imgPet.setImageResource(R.drawable.dog)
                R.id.RdoCat -> imgPet.setImageResource(R.drawable.cat)
                R.id.RdoRabbit -> imgPet.setImageResource(R.drawable.rabbit)
                else -> Toast.makeText(applicationContext, "동물 먼저 선택하세요", Toast.LENGTH_SHORT).show()
            }
        }

    }
}