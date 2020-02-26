package com.examples.coding.rxjavademo.datasource.remote.retrofit

import retrofit2.http.GET
import retrofit2.http.Path

interface JokesService {
    //Static Objects in Kotlin
    companion object{
        fun getChuckNorrisJokeCallService() =
            RetrofitHelper.retrofitInstance.create(JokesService::class.java)
    }

    @GET("jokes/{type}")
    fun getRandomJokes(@Path("type") type: String)
           // : Observable<JokeResponse>

}