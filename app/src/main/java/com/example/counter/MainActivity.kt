package com.example.counter

import android.annotation.SuppressLint
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.sql.Time
import java.util.Timer
import java.util.TimerTask
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)//设置显示内容

        val button = findViewById<Button>(R.id.button)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)

        val result = findViewById<TextView>(R.id.textView)

        var index = 0
        var timer = Timer()
        var timer2 = Timer()

        button.setOnClickListener {
            timer.schedule(object:TimerTask(){
                override fun run() {
                    index++

                    val hour = index / 3600
                    val minute = (index - hour*3600) / 60
                    val second = index - hour*3600 - minute*60
                    val time = String.format("%02d:%02d:%02d",hour,minute,second)
                    runOnUiThread{
                        result.text = time
                    }
                }
                                           },0,1000)

            button.visibility = View.INVISIBLE
            button3.visibility = View.VISIBLE
        }
        button2.setOnClickListener {
            index = 0
            timer.cancel()
            timer.purge()
            timer = Timer()
            timer2.cancel()
            timer2.purge()
            timer2 = Timer()
            button.text = "Start"
            result.text = "00:00:00"
            button.visibility = View.VISIBLE
            button3.visibility = View.INVISIBLE
            button4.visibility = View.INVISIBLE
        }

        button3.setOnClickListener {
            timer.cancel()
            timer.purge()
            timer = Timer()
            timer2.cancel()
            timer2.purge()
            timer2 = Timer()
            button3.visibility = View.INVISIBLE
            button4.visibility = View.VISIBLE
        }

        button4.setOnClickListener {
            timer2.schedule(object:TimerTask(){
                override fun run() {
                    index++

                    val hour = index / 3600
                    val minute = (index - hour*3600) / 60
                    val second = index - hour*3600 - minute*60
                    val time = String.format("%02d:%02d:%02d",hour,minute,second)
                    runOnUiThread{
                        result.text = time
                    }
                }
            },0,1000)
            button3.visibility = View.VISIBLE
            button4.visibility = View.INVISIBLE
        }
    }
}