package com.jumboprivacy.controller

import android.content.Context
import android.util.Base64
import android.util.Log
import com.google.gson.Gson
import com.jumboprivacy.AppConfig
import com.jumboprivacy.R
import com.jumboprivacy.api.ApiService
import com.jumboprivacy.api.ApiUtil
import com.jumboprivacy.api.response.PayloadFileResponse
import com.jumboprivacy.api.response.PayloadResponse
import com.jumboprivacy.event.PayloadEvent
import org.greenrobot.eventbus.EventBus
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ApiController(private val apiService: ApiService,
                    private val appConfig: AppConfig,
                    private val gson: Gson,
                    private val eventBus: EventBus,
                    private val context: Context) {

    /**
     * Async task, For result Listen to the event PayloadEvent
     * @see PayloadEvent
     */
    fun fetchLatestPaylaod() {
        val publicKey = context.getString(R.string.public_Key)
        val repo = ApiUtil.generateRepoUrl(publicKey)
        Log.e("repo", repo)
        apiService.getPayload(repo).enqueue(object : Callback<PayloadFileResponse> {
            override fun onResponse(call: Call<PayloadFileResponse>, response: Response<PayloadFileResponse>) {
                if (response.isSuccessful) {
                    val body = response.body() as PayloadFileResponse
                    val payload = gson.fromJson(body.payload, PayloadResponse::class.java)
                    val versionOffline : String? =  appConfig.version
                    if (versionOffline != null && payload?.version?.contentEquals(appConfig.version) == true) {
                        // no need for updates, content is up to date
                        eventBus.post(PayloadEvent(true, versionOffline, appConfig.content))
                    } else if(ApiUtil.verifySign(publicKey, body.payload, body.signature)) {

                        val decoded = String(Base64.decode(payload.content, Base64.DEFAULT))
                        eventBus.post(PayloadEvent(true, payload.version, decoded))

                        appConfig.version = payload.version
                        // For the sake simplicity we'll use the App preference to save string content,
                        // ideally A DATABASE should be used for two reason
                        // 1- content string might be too long, App preference is suitable for light objects and value
                        // 2- Database is a better choice for scalability, in case we have multiple payload
                        // Conclusion: saving is simplified, after all offline mode is optional in this case
                        appConfig.content = payload.content
                    } else {
                        // signature is not valid, we have a choice either we send a failed event with no payload or the persistent payload that we saved
                        eventBus.post(PayloadEvent())
                    }
                } else
                    eventBus.post(PayloadEvent())
            }

            override fun onFailure(call: Call<PayloadFileResponse>, t: Throwable) {
                eventBus.post(PayloadEvent())
                Log.e("ApiService", "internal error while fetching Payload")
            }
        })
    }
}
