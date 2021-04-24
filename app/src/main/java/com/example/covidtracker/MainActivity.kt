package com.example.covidtracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://covidtracking.com/api/v1/"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gson = GsonBuilder().Create()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        val covidService = retrofit.create(CovidService::class.java)
        //fetch national data
        covidService.getNationalData().enqueue(object: Callback<List<CovdiData>>{

        })
        //fetch state data
    }
}