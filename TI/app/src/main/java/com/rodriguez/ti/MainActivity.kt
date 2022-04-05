package com.rodriguez.ti

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.textfield.TextInputLayout
import java.lang.Integer.parseInt

class MainActivity : AppCompatActivity() {

    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var btn4: Button
    private lateinit var btn5: Button
    private lateinit var btn6: Button
    private lateinit var btn7: Button
    private lateinit var btn8: Button
    private lateinit var btn9: Button
    private lateinit var btn0: Button
    private lateinit var btnSum: Button
    private lateinit var btnMinus: Button
    private lateinit var btnMul: Button
    private lateinit var btnDiv: Button
    private lateinit var btnEqual: Button
    private lateinit var btnDel: Button
    private lateinit var displayText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        addListeners()
    }

    private fun bind() {
        val display: TextInputLayout = findViewById(R.id.display)
        displayText = display.editText!!
        btn0 = findViewById(R.id.btn_0)
        btn1 = findViewById(R.id.btn_1)
        btn2 = findViewById(R.id.btn_2)
        btn3 = findViewById(R.id.btn_3)
        btn4 = findViewById(R.id.btn_4)
        btn5 = findViewById(R.id.btn_5)
        btn6 = findViewById(R.id.btn_6)
        btn7 = findViewById(R.id.btn_7)
        btn8 = findViewById(R.id.btn_8)
        btn9 = findViewById(R.id.btn_9)
        btnSum = findViewById(R.id.btn_sum)
        btnMinus = findViewById(R.id.btn_minus)
        btnMul = findViewById(R.id.btn_mul)
        btnDiv = findViewById(R.id.btn_div)
        btnEqual = findViewById(R.id.btn_equal)
        btnDel = findViewById(R.id.btn_del)
    }

    private fun addListeners() {
        btn0.setOnClickListener() {
            action(0, null)
        }

        btn1.setOnClickListener() {
            action(1, null)
        }

        btn2.setOnClickListener() {
            action(2, null)
        }

        btn3.setOnClickListener() {
            action(3, null)
        }

        btn4.setOnClickListener() {
            action(4, null)
        }

        btn5.setOnClickListener() {
            action(5, null)
        }

        btn6.setOnClickListener() {
            action(6, null)
        }

        btn7.setOnClickListener() {
            action(7, null)
        }

        btn8.setOnClickListener() {
            action(8, null)
        }

        btn9.setOnClickListener() {
            action(9, null)
        }

        btnSum.setOnClickListener() {
            action(null, "+")
        }

        btnMinus.setOnClickListener() {
            action(null, "-")
        }

        btnMul.setOnClickListener() {
            action(null, "*")
        }

        btnDiv.setOnClickListener() {
            action(null, "/")
        }

        btnEqual.setOnClickListener() {
            action(null, "=")
        }

        btnDel.setOnClickListener() {
            displayText.setText("")
            findViewById<TextInputLayout>(R.id.display).setHint(R.string.calculator_text)
            total = 0
            num1 = null
            num2 = null
            signD = null
        }
    }

    private fun action(n: Int?, sign: String?) {
        val display: TextInputLayout = findViewById(R.id.display)

        if (n != null) {
            displayText.append(n.toString())
            checkSign()



        } else {
            if (displayText.text.isNotEmpty()) {

                checkSign()

                when (sign) {
                    "+" -> {
                        signD = "+"
                        displayText.setText("")
                        display.setHint("$num1 $signD")
                    }

                    "-" -> {
                        signD = "-"
                        displayText.setText("")
                        display.setHint("$num1 $signD")
                    }

                    "*" -> {
                        signD = "*"
                        displayText.setText("")
                        display.setHint("$num1 $signD")
                    }

                    "/" -> {
                        signD = "/"
                        displayText.setText("")
                        display.setHint("$num1 $signD")
                    }

                    "=" -> {
                        if (signD == "+") {
                            total = num1!! + num2!!
                        } else if (signD == "-") {
                            total = num1!! - num2!!
                        } else if (signD == "*") {
                            total = num1!! * num2!!
                        } else {
                            total = num1!! / num2!!
                        }
                        displayText.setText(total.toString())
                        display.setHint("$num1 $signD $num2")
                        total = 0
                        num1 = null
                        num2 = null
                        signD = null
                    }
                }

            }
        }
    }

    private fun checkSign(){
        if (signD == null) {
            num1 = parseInt(displayText.text.toString())
        } else{
            num2 = parseInt(displayText.text.toString())
        }
    }

    companion object {
        private var num1: Int? = null
        private var num2: Int? = null
        private var signD: String? = null
        private var total: Int = 0
    }
}