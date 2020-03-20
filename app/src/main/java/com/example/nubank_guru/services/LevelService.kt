package com.example.nubank_guru.services

object LevelService {
    fun list(offset : Int? = 0): List<Any> {
        return Service.get("level/?offset=$offset")
    }

    fun retrieve(id : Int) : List<Any>  {
        return Service.get("level/$id/")
    }

}
