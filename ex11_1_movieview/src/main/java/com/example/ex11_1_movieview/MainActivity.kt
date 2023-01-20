package com.example.ex11_1_movieview

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog

@Suppress("UNREACHABLE_CODE")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "그리드뷰 영화 포스터"

        var gv = findViewById<View>(R.id.gridView1) as GridView
        var gAdapter = MyGridAdapter(this)
        gv.adapter = gAdapter

    }

        inner class MyGridAdapter(var context: Context) : BaseAdapter() {

            // 영화 포스터를 각 그리드뷰의 칸마다 이미지뷰로 생성
            override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
                var imageView = ImageView(context)
                imageView.layoutParams = ViewGroup.LayoutParams(200,300)
                imageView.setPadding(5,5,5,5)
                imageView.setImageResource(posterID[p0])

                imageView.setOnClickListener{
                    var dialogView = View.inflate(this@MainActivity, R.layout.dialog, null)
                    var dlg = AlertDialog.Builder(this@MainActivity)
                    var ivPoster = dialogView.findViewById<ImageView>(R.id.ivPoster)
                    ivPoster.setImageResource(posterID[p0])
                    dlg.setTitle("큰 포스터")
                    dlg.setIcon(R.drawable.ic_launcher)
                    dlg.setView(dialogView)
                    dlg.setNegativeButton("닫기", null)
                    dlg.show()
                }
                return imageView
            }

            override fun getItem(p0: Int): Any {
                return 0
            }

            override fun getItemId(p0: Int): Long {
                return 0
            }

            // 그리드뷰에 보일 이미지의 개수 반환
            override fun getCount(): Int {
                return posterID.size
            }

            var posterID = arrayOf(
                R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04,
                R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08,
                R.drawable.mov09, R.drawable.mov10
            )
        }
}