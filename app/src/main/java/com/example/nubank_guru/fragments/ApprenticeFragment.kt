package com.example.nubank_guru.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nubank_guru.R
import com.example.nubank_guru.activities.LevelActivity
import com.example.nubank_guru.common.Message
import kotlinx.android.synthetic.main.fragment_apprentice.*

class ApprenticeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_apprentice, container, false)
    }

    override fun onResume() {
        super.onResume()
        listeners()

    }

    fun listeners() {
        level_one.setOnClickListener {
            Message.init(activity as Context)
            Message.show("Carregando... Não aperta mais que 1 vez!")
            (activity as LevelActivity).setLevel("1.0")
        }
    }


}
