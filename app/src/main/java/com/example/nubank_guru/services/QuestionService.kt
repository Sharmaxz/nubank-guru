package com.example.nubank_guru.services

object QuestionService {
    fun list(offset : Int? = 0): List<Any> {
        return Service.get("question/?offset=$offset")
    }

    fun retrieve(id : Int) : List<Any>  {
        return Service.get("question/$id/")
    }

}
