package com.example.ex10_intent_function6

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "암시적 인텐트 예제"

        var btnDial = findViewById<Button>(R.id.btnDial)
        var btnWeb = findViewById<Button>(R.id.btnWeb)
        var btnGoogle = findViewById<Button>(R.id.btnGoogle)
        var btnSearch = findViewById<Button>(R.id.btnSearch)
        var btnSms = findViewById<Button>(R.id.btnSms)
        var btnPhoto = findViewById<Button>(R.id.btnPhoto)

        btnDial.setOnClickListener {
            var uri = Uri.parse("tel: 010-1234-5678")
            var intent = Intent(Intent.ACTION_DIAL, uri)
            startActivity(intent)
        }

        btnWeb.setOnClickListener {
            var uri = Uri.parse("https://www.naver.com")
            var intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        btnGoogle.setOnClickListener {
            var uri = Uri.parse("https://maps.google.com/maps?q="+37.559133+","+126.927824)
            var intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        btnSearch.setOnClickListener {
            var intent = Intent(Intent.ACTION_WEB_SEARCH)
            intent.putExtra(SearchManager.QUERY, "안드로이드")
            startActivity(intent)
        }

        btnSms.setOnClickListener {
            var intent = Intent(Intent.ACTION_SENDTO)
            intent.putExtra("sms_body", "안녕하세요")
            intent.data = Uri.parse("smsto:" + Uri.encode("010-1234-5678"))
            startActivity(intent)
        }

        btnPhoto.setOnClickListener {
            var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }
        
    }
}