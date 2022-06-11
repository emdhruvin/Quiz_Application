package com.emdhruvin.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        add screenOrientation = portrait to lock the orientation to portrait mode
        val btnStart: Button = findViewById(R.id.btnStart)
        val etName: EditText = findViewById(R.id.etName)
        btnStart.setOnClickListener {
            if (etName.text.isEmpty()) {
                Toast.makeText(this, "Please Enter Name", Toast.LENGTH_LONG).show()
            } else {
//                to redirect to other page
                val intent = Intent(
                    this,
                    QuizQuestionActivity::class.java
                ) //create intent of QuizQuestionActivity
                //by put extra you can pass additional data to another activity
                //and in question activity the info is retrieve by get extra method
                intent.putExtra(Constant.userName, etName.text.toString())
                startActivity(intent)   //start intent created above
                finish()    //to finish activity that start this activity
            }
        }
    }
}