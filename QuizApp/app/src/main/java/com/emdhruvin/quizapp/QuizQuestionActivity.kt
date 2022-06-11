package com.emdhruvin.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {
    private var tvQuestion: TextView? = null

    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null

    private var tvOptionOne: TextView? = null
    private var tvOptionTwo: TextView? = null
    private var tvOptionThree: TextView? = null
    private var tvOptionFour: TextView? = null

    private var btnSubmit: Button? = null

    private var mCorrectAnswer: Int = 0

    private var mCurrentPosition: Int = 1  //for current position of question (global variable)
    private var mQuestionList: ArrayList<Question>? = null //question list of Question type
    private var mSelectedOptionPositoin: Int =
        0   //default selected option as 0 then going to override and compare with correct answer

    private var mUserName: String? = null  //for username of user which is passed through activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        //for question section
        tvQuestion = findViewById(R.id.tvQuestion)

        //for progressbar section
        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tvProgress)

        //for options section
        tvOptionOne = findViewById(R.id.tvOptionOne)
        tvOptionTwo = findViewById(R.id.tvOptionTwo)
        tvOptionThree = findViewById(R.id.tvOptionThree)
        tvOptionFour = findViewById(R.id.tvOptionFour)

        //for button
        btnSubmit = findViewById(R.id.btnSubmit)

        //for getting user name from previous activity username
        mUserName = intent.getStringExtra(Constant.userName)

        btnSubmit?.setOnClickListener(this)

        tvOptionOne?.setOnClickListener(this)   //direct pass view from QuizQuestionActivity so we don't need to write code in hee
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)

        mQuestionList = Constant.getQuestions()

        setQuestion()
    }

    private fun setQuestion() {
//      Log.i("QuestionList size is : ", "${questionsList.size}") //for checking the size of questionList
        defaultOptionView()
        val question: Question =
            mQuestionList!![mCurrentPosition - 1]  //'!!' give ensurity that question list at this is not null

        //for setting question
        tvQuestion?.text = question.question

        //for setting progressbar
        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition/${progressBar?.max}"

        //for setting options
        tvOptionOne?.text = question.option1
        tvOptionTwo?.text = question.option2
        tvOptionThree?.text = question.option3
        tvOptionFour?.text = question.option4

        //if user reach last question then to convert btnSubmit to FINISH
        if (mCurrentPosition == mQuestionList!!.size) {
            btnSubmit?.text = "FINISH"
        } else {
            btnSubmit?.text = "SUBMIT"

        }
    }

    //set default text view after selecting the option (when go to next question)
    private fun defaultOptionView() {
        btnSubmit?.isEnabled = false
        btnSubmit?.isClickable = false
        tvOptionOne?.isClickable = true
        tvOptionTwo?.isClickable = true
        tvOptionThree?.isClickable = true
        tvOptionFour?.isClickable = true
        val options = ArrayList<TextView>()

        //add option 1 to option list
        tvOptionOne?.let {
            options.add(0, it)
        }

        //add option 2 to option list
        tvOptionTwo?.let {
            options.add(1, it)
        }

        //add option 3 to option list
        tvOptionThree?.let {
            options.add(2, it)
        }

        //add option 4 to option list
        tvOptionFour?.let {
            options.add(3, it)
        }

        //reset every option to default view
        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this, R.drawable.option_button
            )
        }

    }

    //turn border to purple when selecting the option
    private fun selectedOptionView(tv: TextView, selectedOptionNumber: Int) {
        //this will turn the option to default after selecting other option
        //if user select other option then it turn selected option to default
        defaultOptionView()
        mSelectedOptionPositoin = selectedOptionNumber
        tv.setTextColor(Color.parseColor("#363a43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this, R.drawable.option_button_selected
        )

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tvOptionOne -> {
                tvOptionOne?.let {
                    selectedOptionView(it, 1)
                }
                btnSubmit?.isEnabled = true
                btnSubmit?.isClickable = true

            }
            R.id.tvOptionTwo -> {
                tvOptionTwo?.let {
                    selectedOptionView(it, 2)
                }
                btnSubmit?.isEnabled = true
                btnSubmit?.isClickable = true
            }
            R.id.tvOptionThree -> {
                tvOptionThree?.let {
                    selectedOptionView(it, 3)
                }
                btnSubmit?.isEnabled = true
                btnSubmit?.isClickable = true
            }
            R.id.tvOptionFour -> {
                tvOptionFour?.let {
                    selectedOptionView(it, 4)
                }
                btnSubmit?.isEnabled = true
                btnSubmit?.isClickable = true
            }
            R.id.btnSubmit -> {
                // TODO: implement btn submit
                if (mSelectedOptionPositoin == 0) {
                    mCurrentPosition++
                    when {
                        mCurrentPosition <= mQuestionList!!.size -> setQuestion()

                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constant.userName, mUserName)
                            intent.putExtra(Constant.correctAnswers, mCorrectAnswer)
                            intent.putExtra(Constant.totalQuestions, mQuestionList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {

                    val question = mQuestionList?.get(mCurrentPosition - 1)
                    if (question!!.correctAnswer != mSelectedOptionPositoin) {  //if user select wrong answer then it turn into red
                        answerView(mSelectedOptionPositoin, R.drawable.wrog_option)
                    } else
                        mCorrectAnswer++
                    answerView(
                        question.correctAnswer,
                        R.drawable.correct_option
                    )    //this will turn correct answer to green if you select right or wrong answer
                    tvOptionOne?.isClickable = false
                    tvOptionTwo?.isClickable = false
                    tvOptionThree?.isClickable = false
                    tvOptionFour?.isClickable = false


                    if (mCurrentPosition == mQuestionList!!.size) {
                        btnSubmit?.text = "FINISH"
                    } else {
                        btnSubmit?.text = "NEXT"
                    }
                    mSelectedOptionPositoin = 0

                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                tvOptionOne?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2 -> {
                tvOptionTwo?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3 -> {
                tvOptionThree?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4 -> {
                tvOptionFour?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }
}