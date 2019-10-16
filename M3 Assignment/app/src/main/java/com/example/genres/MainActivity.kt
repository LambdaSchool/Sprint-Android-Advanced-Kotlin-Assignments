package com.example.genres

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    private val hipHop = listOf(HipHop("Hot R&B"),
                                HipHop("Hot Rap Songs"),
                                HipHop("Rap AirPlay"))
    private val rock = listOf(Rock("Alternative"),
        Rock("Hard Rock"),
        Rock("Death Metal"))
    private val techno = listOf(Techno("Hot R&B"),
        Techno("Hot Rap Songs"),
        Techno("Rap AirPlay")
    )
    private lateinit var allList: MutableList<Genre>

    //making a list type 

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //here is the adapter for recycler view passing in main activity with alllist in it
        recyclerViewAdapter = RecyclerViewAdapter(allList)
        viewManager = LinearLayoutManager(this)

        recyclerView = findViewById<RecyclerView>(R.id.vRecycle).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = recyclerViewAdapter
        }

    }
}
