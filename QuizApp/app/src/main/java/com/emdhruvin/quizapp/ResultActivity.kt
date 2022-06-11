package com.emdhruvin.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_activiry)
        val tvName: TextView = findViewById(R.id.tvName)
        val tvScore: TextView = findViewById(R.id.tvScore)
        val btnFinish: Button = findViewById(R.id.btnFinish)

        //set user name to user name text view
        tvName.text = intent.getStringExtra(Constant.userName)

        val totalQuestion = intent.getIntExtra(Constant.totalQuestions, 0)
        val correctAnswer = intent.getIntExtra(Constant.correctAnswers, 0)

        tvScore.text = "Your Score is $correctAnswer out of $totalQuestion"


        btnFinish.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}