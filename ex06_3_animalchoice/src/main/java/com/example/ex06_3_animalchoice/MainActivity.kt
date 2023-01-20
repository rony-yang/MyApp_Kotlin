package com.example.ex06_3_animalchoice


import android.app.TabActivity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


@Suppress("deprecation")
class MainActivity : TabActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tabHost = this.tabHost // 탭호스트 변수 생성

        var tabSpec1 = tabHost.newTabSpec("TAB1").setIndicator("강아지")
        tabSpec1.setContent(R.id.iv1) // 탭스펙을 탭과 연결
        tabHost.addTab(tabSpec1) // 탭을 탭호스트에 부착

        var tabSpec2 = tabHost.newTabSpec("TAB2").setIndicator("고양이")
        tabSpec2.setContent(R.id.iv2)
        tabHost.addTab(tabSpec2)

        var tabSpec3 = tabHost.newTabSpec("TAB3").setIndicator("토끼")
        tabSpec3.setContent(R.id.iv3)
        tabHost.addTab(tabSpec3)

        var tabSpec4 = tabHost.newTabSpec("TAB4").setIndicator("말")
        tabSpec4.setContent(R.id.iv4)
        tabHost.addTab(tabSpec4)

        tabHost.currentTab = 1

    }
}
