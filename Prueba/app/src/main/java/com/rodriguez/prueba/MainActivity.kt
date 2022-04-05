package com.rodriguez.prueba

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var prevBtn : Button
    private lateinit var nextBtn : Button
    private lateinit var counterTxt : TextView
    private lateinit var stick1 : ImageView
    private lateinit var stick2 : ImageView
    private lateinit var stick3 : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        addListeners()
    }

    private fun bind(){
        prevBtn = findViewById(R.id.prev_btn)
        nextBtn = findViewById(R.id.next_btn)
        counterTxt = findViewById(R.id.counter_txt)
        stick1 = findViewById(R.id.stick_1)
        stick2 = findViewById(R.id.stick_2)
        stick3 = findViewById(R.id.stick_3)
    }

    private fun addListeners(){
        nextBtn.setOnClickListener(){
            actionNext()

            when(counter){
                1 -> stick1.visibility = View.INVISIBLE
                2 -> stick2.visibility = View.INVISIBLE
                3 -> stick3.visibility = View.INVISIBLE
            }


        }

        prevBtn.setOnClickListener(){
            if (counter > 0){
                actionPrevious()
            } else{
                counter = 0
            }
        }
    }

    private fun actionNext(){
        counter++
        counterTxt.text = counter.toString()
    }

    private fun actionPrevious(){
        counter--
        counterTxt.text = counter.toString()
    }

    companion object{
        private var counter = 0
    }

}