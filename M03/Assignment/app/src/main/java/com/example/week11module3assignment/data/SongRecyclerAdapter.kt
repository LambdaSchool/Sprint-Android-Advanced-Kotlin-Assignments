package com.example.week11module3assignment.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.week11module3assignment.R
import com.example.week11module3assignment.data.model.Song
import kotlinx.android.synthetic.main.song_list_layout.view.*


class SongRecyclerAdapter(private var songs: ArrayList<Song>, context: Context) : RecyclerView.Adapter<SongRecyclerAdapter.SongHolder>() {

   inner class SongHolder(view: View) : RecyclerView.ViewHolder(view) {

       var songNameTV = view.song_name_textview as TextView
       var artistNameTV = view.artist_name_textview as TextView
       var songArtwork = view.song_artwork_iv as ImageView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongRecyclerAdapter.SongHolder {
        val viewGroup: ViewGroup
    }

    override fun getItemCount(): Int {
        return songs.size
    }

    override fun onBindViewHolder(holder: SongRecyclerAdapter.SongHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}

/*
fun ViewGroup.inflate(
        layoutRes: Int,
        context: Context,
        root: ViewGroup = this,
        attach
)*/
