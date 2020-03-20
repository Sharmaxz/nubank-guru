package com.example.nubank_guru.activities

import android.content.Intent
import android.os.Bundle
import com.example.nubank_guru.R
import androidx.appcompat.app.AppCompatActivity
import com.example.nubank_guru.adapters.LevelAdapter
import com.example.nubank_guru.common.Message
import com.example.nubank_guru.fragments.ApprenticeFragment
import com.example.nubank_guru.fragments.ConsciousFragment
import com.example.nubank_guru.models.Answer
import com.example.nubank_guru.models.Level
import com.example.nubank_guru.models.Question
import com.example.nubank_guru.services.LevelService
import com.example.nubank_guru.services.QuestionService
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_level.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


open class LevelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level)

//        //Toolbar
//        val toolbar = Toolbar(this, findViewById(R.id.toolbar), R.menu.menu)
//        toolbar.titleEnabled(false)

        //TabLayout
        tablayout.addTab(tablayout.newTab().setText(R.string.app_name))
        tablayout.tabGravity = TabLayout.GRAVITY_CENTER

        val adapter = LevelAdapter(supportFragmentManager)
        adapter.addFragment(ApprenticeFragment(),"Apprentice")
        adapter.addFragment(ConsciousFragment(),"Conscious")
        pager.adapter = adapter
        tablayout.setupWithViewPager(pager)

    }

    open fun setLevel(position : String) {
        //TODO: ARRUMAR ISSO AAAAH!

        GlobalScope.launch {
            val levelJson = LevelService.list()
            for(l in levelJson) {
                if((l as MutableMap<String, Any>)["position"].toString() == position) {
                    val map = (l as MutableMap<String, Any>)
                    val level = Level(
                        id=(map["id"] as Double).toInt(),
                        position=(map["position"] as Double).toInt(),
                        title = map["title"].toString(),
                        content = map["text"].toString(),
                        questions = map["questions"] as List<Int>
                    )

                    val questionJson = (QuestionService.retrieve(level.id)[0] as MutableMap<String, Any>)
                    val answers = mutableListOf<Answer>()
                    for (answer in questionJson["questions"] as ArrayList<MutableMap<String, Any>>) {
                        answers.add(Answer(
                            id=(answer["id"] as Double).toInt(),
                            text=answer["text"].toString(),
                            is_correct= answer["is_correct"] as Boolean,
                            order= (answer["order"] as Double).toInt()
                        ))

                    }


                    val question = Question(
                        id =(questionJson["id"] as Double).toInt(),
                        position =(questionJson["position"] as Double).toInt(),
                        title = questionJson["title"].toString(),
                        text = questionJson["text"].toString(),
                        answers = answers as List<Answer>
                    )

                    openLevel(level, question)
                }
            }
        }
    }

    open fun openLevel(level: Level, question : Question) {
        intent = Intent(this, QuestionActivity::class.java)
        intent.putExtra("LEVEL", level)
        intent.putExtra("QUESTION", question)
        startActivity(intent)
    }
}
