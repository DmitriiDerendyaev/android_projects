package com.example.kotlin_lesson_4

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import java.util.*

class MainActivity : Activity() {//если мы используем простой Activity, нужно в activty_,ain.xml изменять свойства
    //простой активити нужен, чтобы убрать строку имени проекта

    var imSemafor: ImageView? = null
    var counter:Int = 0
    var timer: Timer? = null
    var is_run = false
    var imageArray:IntArray = intArrayOf(R.drawable.semafor_red,R.drawable.semafor_yellow,R.drawable.semafor_green)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imSemafor = findViewById(R.id.imSemafor)
        //imSemafor?.setImageResource(imageArray[1])
    }

    fun onClickStartStop(view: View)
    {
        //imSemafor?.setImageResource(R.drawable.semafor_green)
        view as ImageButton
        if (!is_run)
        {
            view.setImageResource(R.drawable.button_stop)
            is_run = true
            StartStop()
        }
        else
        {
            imSemafor?.setImageResource(R.drawable.semafor_grey)
            view.setImageResource(R.drawable.button_start)
            timer?.cancel()
            is_run = false
            counter = 0
        }
    }

    fun StartStop()
    {
        timer = Timer()
        timer?.schedule(object :TimerTask(){
            override fun run() {
                runOnUiThread{
                    imSemafor?.setImageResource(imageArray[counter])
                    counter++
                    if(counter == 3) counter = 0
                }

            }

        },0,1000)
    }

}