package com.example.retrofitpractice

import retrofit2.Call
import retrofit2.http.GET

interface FactService {

    @GET("/random.json?language=en")
    fun getRandomFact(): Call<Fact>

    @GET("/random.json?language=de")
    fun getRandomFactInGerman(): Call<Fact>
}