package com.example.conductorkotlin.controllers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import com.example.conductorkotlin.R
import kotlinx.android.synthetic.main.activity_main.view.*

//manages parts of ui
class MainController : Controller(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.activity_main, container, false)
        return view
    }

}