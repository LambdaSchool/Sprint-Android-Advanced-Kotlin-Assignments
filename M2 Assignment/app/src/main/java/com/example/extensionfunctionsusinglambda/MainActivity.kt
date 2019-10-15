package com.example.extensionfunctionsusinglambda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object{
        const val NOTIFICATION_ID = 1
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        get_notification.setOnClickListener {
            BasicNotificationBuilder.BasicNotification(this)

            imageView.onSuccess("https://cdn.bulbagarden.net/upload/b/b8/025Pikachu_LG.png", this)
        
            imageView.onFailure("https://upload.wikimedia.org/wikipedia/commons/thumb/a/ac/No_image_available.svg/600px-No_image_available.svg.png", this)


        }



    }
}
