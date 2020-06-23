package com.versilis.conductordemo.controllers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.ControllerChangeType
import com.versilis.conductordemo.R

class HomeController() : Controller() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
       val view = inflater.inflate(R.layout.home_controller_layout, container, false)
        view.findViewById<TextView>(R.id.home_textview).text = "Hello Conductor!"
        return view
    }

    override fun onChangeEnded(
        changeHandler: ControllerChangeHandler,
        changeType: ControllerChangeType
    ) {
        super.onChangeEnded(changeHandler, changeType)

        if (view != null) {
            view?.findViewById<Button>(R.id.next_button)?.setOnClickListener {

            }
        }
    }
}