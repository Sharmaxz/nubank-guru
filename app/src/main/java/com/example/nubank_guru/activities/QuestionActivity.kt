package com.example.nubank_guru.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nubank_guru.R
import com.example.nubank_guru.models.Question
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

    }

    override fun onResume() {
        text.text = (intent.extras!!["QUESTION"] as Question).text
        navtitle.text = (intent.extras!!["QUESTION"] as Question).title
        answer1.text = (intent.extras!!["QUESTION"] as Question).answers[0].text
        answer2.text = (intent.extras!!["QUESTION"] as Question).answers[1].text
        answer3.text = (intent.extras!!["QUESTION"] as Question).answers[2].text
        super.onResume()
    }
}
