package com.example.retrofitpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        englishFact.setOnClickListener {
            loadFact()
        }

        germanFact.setOnClickListener {
            loadGermanFact()
        }
    }

    private fun loadFact() {
        val factService = ServiceBuilder.buildService(FactService::class.java)

        val requestCall = factService.getRandomFact()
        requestCall.enqueue(object: Callback, retrofit2.Callback<Fact> {
            override fun onResponse(call: Call<Fact>, response: Response<Fact>) {
                val fact = response.body()!!
                text1.text = fact.text

                Log.d("test", "Success")
            }

            override fun onFailure(call: Call<Fact>, t: Throwable) {
                Log.d("test", "Failure")
            }

        })
    }

    private fun loadGermanFact() {
        val factService = ServiceBuilder.buildService(FactService::class.java)

        val requestCall = factService.getRandomFactInGerman()
        requestCall.enqueue(object: Callback, retrofit2.Callback<Fact> {
            override fun onResponse(call: Call<Fact>, response: Response<Fact>) {
                val fact = response.body()!!
                text1.text = fact.text

                Log.d("test", "Success")
            }

            override fun onFailure(call: Call<Fact>, t: Throwable) {
                Log.d("test", "Failure")
            }

        })
    }
}