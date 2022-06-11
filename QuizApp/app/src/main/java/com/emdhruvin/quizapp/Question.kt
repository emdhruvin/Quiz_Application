package com.emdhruvin.quizapp

//this class is for creating question
data class Question(
    val id: Int,  //id of  question
    val question: String,    // main question
    val option1: String, //option 1 of question
    val option2: String, //option 2 of question
    val option3: String, //option 3 of question
    val option4: String, //option 4 of question
    val correctAnswer: Int   //answer of question
    //go to object class from that application will get question
)
