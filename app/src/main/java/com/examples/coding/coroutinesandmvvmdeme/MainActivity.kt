package com.examples.coding.coroutinesandmvvmdeme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.examples.coding.rxjavademo.datasource.remote.retrofit.JokesService
import com.examples.coding.rxjavademo.view.adapters.JokesAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher

class MainActivity : AppCompatActivity() {
    val adapter by lazy{ JokesAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvJokeList.layoutManager = LinearLayoutManager(this)
        rvJokeList.adapter = adapter
    }

    fun onClick(view: View) {
        when(view.id) {
            R.id.btnGenerateNewJoke -> getJokesFromAPI()
        }
    }

    fun getJokesFromAPI() {
        val service = JokesService.getChuckNorrisJokeCallService()
        CoroutineScope(Dispatchers.Main).launch {
            val jokeRequest = service.getRandomJokes("random")
            withContext(Dispatchers.Main){
                val response = jokeRequest.await()
                adapter.addJoke(response)
            }
        }
    }
}
