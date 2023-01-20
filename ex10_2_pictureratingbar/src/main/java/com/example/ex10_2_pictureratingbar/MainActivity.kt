package com.example.ex10_2_pictureratingbar

import android.content.Intent
import android.media.Rating
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "명화 선호도 투표"

        var voteCount = IntArray(9)
        for (i in 0..8)
            voteCount[i] = 0
        var image = arrayOfNulls<ImageView>(9)
        var imagId = arrayOf(R.id.pic1, R.id.pic2, R.id.pic3, R.id.pic4,
                     R.id.pic5, R.id.pic6, R.id.pic7, R.id.pic8, R.id.pic9)
        var imgName = arrayOf("독서하는 소녀", "꽃장식 모자 소녀", "부채를 든 소녀",
                      "이레느깡 단 베르앙", "잠자는 소녀", "테라스의 두 자매",
                      "피아노 레슨", "피아노 앞의 소녀들", "해변에서")

        for (i in imagId.indices) {
            image[i] = findViewById<ImageView>(imagId[i])
            image[i]!!.setOnClickListener {
                voteCount[i]++
                Toast.makeText(applicationContext, imgName[i] + ": 총 " +
                voteCount[i] + " 표", Toast.LENGTH_SHORT).show()
            }
        }

        var btnFinish = findViewById<Button>(R.id.btnResult)
        btnFinish.setOnClickListener {
            var intent = Intent(applicationContext, ResultActivity::class.java)
            intent.putExtra("VoteCount", voteCount)
            intent.putExtra("ImageName", imgName)
            startActivity(intent)
        }



    }
}