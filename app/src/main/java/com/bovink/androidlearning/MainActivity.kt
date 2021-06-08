package com.bovink.androidlearning

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.Header
import retrofit2.http.POST
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        val retrofit = Retrofit.Builder()
                .baseUrl("http://english.dolphinmedia.cn:8090/dolphin/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val service = retrofit.create(EnglishService::class.java)
        val res = Res("22427", "1")
        service.getWordLessonList(res, "MTAwMDA=").also {

            it.enqueue(object : Callback<Any> {
                override fun onFailure(call: Call<Any>, t: Throwable) {
                }

                override fun onResponse(call: Call<Any>, response: Response<Any>) {
                    println("=================")
                    println(response.body())
                    println("=================")

                }


            })
        }
    }

}

data class Res(val childId: String, val resourceId: String)

interface EnglishService {
    @POST("lesson/queryLessonList")
    fun getWordLessonList(@Body res: Res,
                          @Header("token") token: String): Call<Any>
}