package com.example.genres

import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toolbar
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_view.*
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    val textView by lazy {
        findViewById<TextView>(R.id.vTextView)
    }



    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    //private val allListRes = mutableListOf<Genre>()
    private val hipHop = mutableListOf(HipHop("Hot R&B"),
                                HipHop("Hot Rap Songs"),
                                HipHop("Rap AirPlay"))
    private val rock = mutableListOf(Rock("Alternative"),
        Rock("Hard Rock"),
        Rock("Death Metal"))
    private val techno = mutableListOf(Techno("Hot R&B"),
        Techno("Hot Rap Songs"),
        Techno("Rap AirPlay")
    )
    private var allList = mutableListOf<Genre>()

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
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        toolbar.title = title


        //here is the adapter for recycler view passing in main activity with alllist in it
        recyclerViewAdapter = RecyclerViewAdapter(allList)
        viewManager = LinearLayoutManager(this)

        recyclerView = findViewById<RecyclerView>(R.id.vRecycle).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = recyclerViewAdapter
        }

        allList.add(listType)
    }
    private inline fun <reified T: Genre> setTitleType(genreList: List<T>){
        when{
            HipHop("") is T -> title = "hiphop"
            Rock("") is T -> title = "rock"
            Techno("") is T -> title = "techno"
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.genre_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.mHiphop -> {
                vTextView.text = hipHop.toMutableList().toString()
            }
            R.id.mRock -> rock
            R.id.mTechno -> techno
        }


        return super.onOptionsItemSelected(item)
    }
}

