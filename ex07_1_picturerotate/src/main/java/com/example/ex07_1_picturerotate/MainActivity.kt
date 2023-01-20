package com.example.ex07_1_picturerotate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import android.widget.EditText
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.view.SubMenu

class MainActivity : AppCompatActivity() {

       // 자료형만 주면서 멤버변수로 선언
        lateinit var baseLayout: RelativeLayout
        lateinit var imgJeju : ImageView
        lateinit var editText1 : EditText

        // 이렇게 멤버변수를 선언하면서 값을 주면 객체지향에 위배된다
        // 클래스는 값을 가질 수 없고 객체만 값을 가질 수 있다
//        var baseLayout = findViewById<RelativeLayout>(R.id.baseLayout)
//        var imgJeju = findViewById<ImageView>(R.id.imgJeju)
//        var editText1 = findViewById<EditText>(R.id.editText1)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "제주도 풍경 앱"

        // Id와 (R.id) 사이의 <ImageView> 같은 자료형은 위쪽 멤버변수에서 선언했으므로 제외
        baseLayout = findViewById(R.id.baseLayout)
        imgJeju = findViewById(R.id.imgJeju)
        editText1 = findViewById(R.id.editText1)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        var mInflater = menuInflater
        mInflater.inflate(R.menu.menu1, menu)
        return true
    }

//    각도회전 시 값을 누적시키기 위해서 사용
//    지역변수로 선언하면 선택할때마다 값이 초기화되서 멤버변수 쪽에 선언해야 함
//    var fAng : Float = 0.0f

    // static처럼 정적 객체로 만들기 위해 사용
    companion object {
        var fAng : Float = 0.0f
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.imgRotate -> {
                fAng += editText1.text.toString().toFloat()
                imgJeju.rotation = fAng
                return true
            }
            R.id.btn1 -> {
                imgJeju.setImageResource(R.drawable.jeju1)
                return true
            }
            R.id.btn2 -> {
                imgJeju.setImageResource(R.drawable.jeju2)
                return true
            }
            R.id.btn3 -> {
                imgJeju.setImageResource(R.drawable.jeju3)
                return true
            }
        }
        return false
    }

}