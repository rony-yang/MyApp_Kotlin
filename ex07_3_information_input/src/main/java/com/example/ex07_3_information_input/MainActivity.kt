package com.example.ex07_3_information_input

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.widget.*
import com.example.ex07_3_information_input.R.*

class MainActivity : AppCompatActivity() {

    lateinit var btnClick : Button
    lateinit var EditTextName : EditText
    lateinit var EditTextEmail : EditText
    lateinit var dialogName : EditText
    lateinit var dialoEmail : EditText
    lateinit var toastText : TextView
    lateinit var dialogView : View
    lateinit var toastView: View


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
        title = "사용자 정보 입력"

        btnClick = findViewById(R.id.btnClick)
        EditTextName = findViewById(R.id.EditTextName)
        EditTextEmail = findViewById(R.id.EditTextEmail)


        btnClick.setOnClickListener {
            dialogView = View.inflate(this@MainActivity, R.layout.dialog1, null)

            dialogName = dialogView.findViewById<EditText>(R.id.dialogName)
            dialoEmail = dialogView.findViewById<EditText>(R.id.dialoEmail)

            dialogName.setText(EditTextName.text.toString())
            dialoEmail.setText(EditTextEmail.text.toString())

            var dlg = AlertDialog.Builder(this@MainActivity)
            dlg.setTitle("사용자 정보 입력")
            dlg.setIcon(drawable.ic_menu_allfriends)
            dlg.setView(dialogView)

            dlg.setPositiveButton("확인") { dialog, which ->
                EditTextName.setText(dialogName.text.toString())
                EditTextEmail.setText(dialoEmail.text.toString())
            }

            dlg.setNegativeButton("취소") { dialog, which ->
                var toast = Toast(this@MainActivity)

                val display = (getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay
                val xOffset = (Math.random() * display.width).toInt()
                val yOffset = (Math.random() * display.height).toInt()

                toast.setGravity(Gravity.TOP or Gravity.LEFT, xOffset, yOffset)

                toastView = View.inflate(this@MainActivity, R.layout.toast1, null) as View
                toastText = toastView.findViewById<View>(R.id.toastText1) as TextView
                toastText.text = "취소했습니다"
                toast.view = toastView
                toast.show()
            }

            dlg.show()
        }
    }
}