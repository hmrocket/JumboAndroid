package com.jumboprivacy.ui

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.jumboprivacy.JumboApp
import com.jumboprivacy.R
import com.jumboprivacy.controller.ApiController
import com.jumboprivacy.event.PayloadEvent
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject lateinit var apiController: ApiController
    @Inject lateinit var eventBus: EventBus

    lateinit var version : TextView
    lateinit var status : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as JumboApp).appComponent.inject(this)

        version = findViewById(R.id.version)
        status = findViewById(R.id.status)
        status.text = getString(R.string.status_checking)

        if(!eventBus.isRegistered(this))
            eventBus.register(this)

        apiController.fetchLatestPaylaod()
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onPayloadEvent(event: PayloadEvent) {
        if(event.isSuccessful) {
            version.text = event.version
            status.text = getString(R.string.status_updated)
            Log.d("payload", event.payload)
        } else {
            version.text = getString(R.string.unknown)
            status.text = getString(R.string.status_error)
        }

    }

}
