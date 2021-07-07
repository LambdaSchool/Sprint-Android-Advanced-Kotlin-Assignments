package com.example.conductorkotlin.controllers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.ControllerChangeType
import com.example.conductorkotlin.R

class SecondController<T>() : BaseController()
where T: Controller, T: SecondController.ChildContainer {

    constructor(targetController: T):this(){
        setTargetController(targetController)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
       return inflater.inflate(R.layout.pass_data, container, false)

    }
    interface ChildContainer {
        fun receiveMessage(string: String)
    }

    override fun onChangeEnded(
        changeHandler: ControllerChangeHandler,
        changeType: ControllerChangeType
    ) {
        super.onChangeEnded(changeHandler, changeType)
        //todo 8 trying to pass data between activities
            val next = view?.findViewById<TextView>(R.id.buttonBack)
            next?.setText("pass it!")

            next?.setOnClickListener {
                (targetController as ChildContainer).receiveMessage("")
            }
    }

}