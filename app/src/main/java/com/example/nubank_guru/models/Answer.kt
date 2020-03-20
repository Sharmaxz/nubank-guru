package com.example.nubank_guru.models

import java.io.Serializable

class Answer(val id : Int = 0,
               val text : String = "",
               val order : Int = 0,
               val is_correct : Boolean = false ) : Serializable
