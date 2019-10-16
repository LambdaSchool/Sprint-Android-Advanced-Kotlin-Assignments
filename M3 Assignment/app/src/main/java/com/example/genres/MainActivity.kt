package com.example.genres

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_view.*
import kotlin.properties.Delegates

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
    private var listType: Genre by Delegates.observable(HipHop("")) { _, _: Genre, newList: Genre ->
        allList = when (newList) {
            is HipHop -> hipHop.toMutableList()
            is Rock -> rock.toMutableList()
            is Techno -> techno.toMutableList()
        }
        vTextView.text = allList.joinToString(", ") {
            it.name
        }
        setTitleType(allList)
    }
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
    private inline fun <reified T: Genre> setTitleType(genreList: List<T>){
        when{
            HipHop("") is T -> title = "hiphop"
            Rock("") is T -> title = "rock"
            Techno("") is T -> title = "techno"
        }
    }
}

