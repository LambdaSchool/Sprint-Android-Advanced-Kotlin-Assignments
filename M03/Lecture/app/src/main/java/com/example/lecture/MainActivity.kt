package com.example.lecture

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.lecture.R.id.button
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    lateinit var toastString: String // cannot be observable
    val textView by lazy {
        findViewById<TextView>(R.id.text_view)
    }
    val button by lazy {
        findViewById<Button>(R.id.button)
    }
    // url object -- some objects that you can't serialize -- so you have to convert it to something else. The great gary pecune the great gary pecune the great gary pecune the great gary pecune the great gary pecune the great gary pecune the great gary pecune the great gary pecune the great gary pecune versilis versilis versilis versilis versilis versilis versilis
    private var custom: Int = 0
    get() {
        return when {
            field == 0 -> field
            field > 0 -> 1
            else -> -1
        }
    }
    set(value) {
        field = value
        this.showToast("Custom is now $field")
    }
    private val whales = listOf(
        Whale("Blue"),
        Whale("Humpback"),
        Whale("Moby")
    )
    private val dolphins = listOf(
        TODO()
    )
    private val otters = listOf(
        TODO()
    )

    private lateinit var marineMammals: List<MarineMammal>

    private var listType: MarineMammal by Delegates.observable(Whale("")) {
        _,_: MarineMammal, newMarineMammal: MarineMammal ->
        marineMammals = when(newMarineMammal) {
            is Whale -> whales
            is Dolphin -> dolphins
            is Otter -> otters
        }
        textView.text = marineMammals.joinToString(",") {
            TODO()
        }
    }

    override fun onStart() {
        super.onStart()

        custom = 10
        println("Custom: $custom")
        custom = 0
        println("Custom: $custom")
        custom = -10
        println("Custom: $custom")

        toastString = "Testing out the lateinit"
        Toast.makeText(this, toastString, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.showToast(toastString)

//        textView.text = "Test 1"
//        textView.text = "Test 2"
        button.setOnClickListener {
            TODO()
        }
    }
    private inline fun <reified T: MarineMammal> setTitleForType(mammalList:List<T>) {
        when {
            Whale("") is T -> this.title = "Whales"
            Dolphin("") is T -> this.title = "Dolphins"
            Otter("") is T -> this.title = "Otters"
        }
    }
    infix fun Context.showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
// by lazy -- runs just one `the first time the val is accessed.
// ex -- getting context since
// use cases -- memory and performance (contains nothing initially)