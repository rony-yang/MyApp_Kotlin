package com.example.ex11_2_galleryview

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Gallery
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "갤러리 영화 포스터"

        var gallery = findViewById<Gallery>(R.id.gallery1)
        var galAdapter = MyGalleryAdapter(this)
        gallery.adapter = galAdapter
    }

    inner class MyGalleryAdapter(internal var context: Context) : BaseAdapter() {
        var posterID = arrayOf(
            R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04,
            R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08,
            R.drawable.mov09, R.drawable.mov10
        )

        var posterTitle = arrayOf(
            "써니","완득이","괴물","라디오스타","비열한거리","왕의남자","아일랜드",
            "웰컴투동막골","헬보이","빽투더퓨처"
        )

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?) : View {
            var imageView = ImageView(context)
            imageView.layoutParams = Gallery.LayoutParams(200,300)
            imageView.scaleType = ImageView.ScaleType.FIT_CENTER
            imageView.setPadding(5,5,5,5)
            imageView.setImageResource(posterID[p0])

            imageView.setOnTouchListener { v, event ->

                var toast = Toast(applicationContext)
                var toastView = View.inflate(applicationContext, R.layout.toast, null)
                var toastViewTextView = toastView.findViewById<TextView>(R.id.tv1)

                toastViewTextView.text = posterTitle[p0]

                toast.view = toastView
                toast.show()


                var ivPoster = findViewById<ImageView>(R.id.ivPoster)
                ivPoster.scaleType = ImageView.ScaleType.FIT_CENTER
                ivPoster.setImageResource(posterID[p0])
                false
            }
            return imageView
        }

        override fun getCount(): Int {
            return posterID.size
        }

        override fun getItem(p0: Int) : Any {
            return 0
        }

        override fun getItemId(p0: Int) : Long {
            return 0
        }

    }

}