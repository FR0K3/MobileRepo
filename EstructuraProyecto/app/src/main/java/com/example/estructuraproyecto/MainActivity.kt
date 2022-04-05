package com.example.estructuraproyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var resultTextView: TextView
    private lateinit var greetingButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()

        greetingButton.setOnClickListener { view ->
            onGreeting(view)
        }
    }

    private fun bind(){
        nameEditText = findViewById(R.id.name_edit_text)
        resultTextView = findViewById(R.id.greeting_text_view)
        greetingButton = findViewById(R.id.action_greeting)
    }

    fun onGreeting(view: View){
        val name = nameEditText.text.toString()
        resultTextView.text = makeGreeting(name)
    }

    private fun makeGreeting(name: String) =
        if (name.isEmpty()){
             getString(R.string.helper_text_write_name)
        } else{
            getString(R.string.greeting_text, name)
        }
}


