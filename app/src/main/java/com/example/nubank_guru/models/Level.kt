package com.example.nubank_guru.models

import java.io.Serializable

class Level(val id : Int = 0,
            val title : String = "",
            val level : String = "",
            val position : Int = 0,
            val content : String = "",
            val questions : List<Int> = listOf()) : Serializable
