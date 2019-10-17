package com.example.conductorkotlin.controllers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.ControllerChangeType
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler
import com.example.conductorkotlin.R
import kotlinx.android.synthetic.main.activity_main.view.*

//manages parts of ui

//todo 7 setting parameters to the controller
class MainController(bundle: Bundle) : Controller(bundle){

    constructor(parameter: String):this(Bundle().apply {
        putString(EXTRA_PARAMETER, parameter)
    })
    private val parameter by lazy {
        args.getString(EXTRA_PARAMETER)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.activity_main, container, false)

        view.textView.text = "My favorite city is: $parameter"

        return view
    }

    override fun onChangeEnded(
        changeHandler: ControllerChangeHandler,
        changeType: ControllerChangeType
    ) {
        super.onChangeEnded(changeHandler, changeType)
        view?.findViewById<Button>(R.id.buttonNext)?.setOnClickListener {
            // todo 3 navigating to an other controller
            router.pushController(
                RouterTransaction.with(SecondController())
                    //setting animation transitions here
                    .popChangeHandler(HorizontalChangeHandler())
                    .pushChangeHandler(HorizontalChangeHandler())
            )
        }

    }




    companion object{
        const val EXTRA_PARAMETER = "China"
    }

}