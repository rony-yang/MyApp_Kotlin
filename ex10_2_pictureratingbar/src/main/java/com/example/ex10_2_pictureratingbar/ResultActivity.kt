package com.example.ex10_2_pictureratingbar

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView

class ResultActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result)
        title = "투표 결과"

        //  앞 화면에서 보낸 투표 결과 값을 받는다
        var intent = intent
        var voteResult = intent.getIntArrayExtra("VoteCount")
        var imageName = intent.getStringArrayExtra("ImageName")


        val imageFileId = arrayOf(R.drawable.pic1, R.drawable.pic2, R.drawable.pic3,
                          R.drawable.pic4, R.drawable.pic5, R.drawable.pic6,
                          R.drawable.pic7, R.drawable.pic8, R.drawable.pic9)
        var tvTop = findViewById<TextView>(R.id.tvTop)
        var ivtop = findViewById<ImageView>(R.id.ivTop)

        // 최다득표된 이미지를 출력
        var maxIndex = 0
        for (i in 0..voteResult!!.size-1) {
            if (voteResult[i] > voteResult[maxIndex])
                maxIndex = i
        }

        tvTop.text = imageName!![maxIndex]
        ivtop.setImageResource(imageFileId[maxIndex])


        // 9개의 TextView, RatingBar 객체배열
        var tv = arrayOfNulls<TextView>(imageName!!.size)
        var rbar = arrayOfNulls<RatingBar>(imageName.size)
        var tvID = arrayOf(R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5,
                   R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9)
        var rbarID = arrayOf(R.id.rbar1, R.id.rbar2, R.id.rbar3, R.id.rbar4,
                     R.id.rbar5, R.id.rbar6, R.id.rbar7, R.id.rbar8, R.id.rbar9)


        // 9개의 TextView, RatingBar ID 배열
        for (i in voteResult!!.indices) {
            tv[i] = findViewById<TextView>(tvID[i])
            rbar[i] = findViewById<RatingBar>(rbarID[i])
        }


        // TextView, RatingBar 개체 찾기
        for (i in voteResult.indices) {
            tv[i]!!.setText(imageName!![i])
            rbar[i]!!.setRating(voteResult[i].toFloat())
        }


        // 각 TextView, RatingBar에 넘겨받은 값을 반영
        var btnReturn = findViewById<Button>(R.id.btnReturn)
        btnReturn.setOnClickListener {
            finish()
        }

    }
}