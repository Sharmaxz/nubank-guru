package com.example.nubank_guru.models

import java.io.Serializable

class Question(
    val id: Int = 0,
    val title: String = "",
    val position: Int = 0,
    val text: String = "",
    val answers: List<Answer> = listOf()) : Serializable
