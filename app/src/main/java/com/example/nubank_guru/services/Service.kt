@file:Suppress("UNCHECKED_CAST")

package com.example.nubank_guru.services

import com.example.nubank_guru.common.Message
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import khttp.*

object Service {

    private val API_URL : String = "https://nubank-guru.herokuapp.com/api/"

    fun get(url : String) : List<Any> {
        val request = prepare(url)
        return call(request)
    }


    private fun prepare(url : String, method : String? = "GET") : MutableMap<String, Any> {
        val url = API_URL + url
        val header = mapOf("Content-Type" to "application/json")

        return mutableMapOf(
                "URL" to url,
                "METHOD" to method!!,
                "HEADERS" to header
        )
    }

    private fun call(request : MutableMap<String, Any>) : List<Any> {
        val url = request["URL"].toString()
        val headers = request["HEADERS"] as Map<String, String>

        val response = request("GET", url, headers=headers)
        if(response.statusCode >= 400) {
            Message.show("Verifique sua conexão!")
        }


        val gson = Gson()
        val r = gson.fromJson(response.text, Any::class.java)

        if (r::class.java.simpleName == "ArrayList") {
            return r as List<Any>
        }

        return listOf(r)

    }

}
