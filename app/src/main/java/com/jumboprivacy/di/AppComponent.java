package com.jumboprivacy.di;

import android.content.Context;
import com.google.gson.Gson;
import com.jumboprivacy.AppConfig;
import com.jumboprivacy.api.ApiService;
import com.jumboprivacy.api.ApiServiceModule;
import com.jumboprivacy.controller.ApiController;
import com.jumboprivacy.ui.MainActivity;
import dagger.Component;
import org.greenrobot.eventbus.EventBus;

@Component(modules = {ApiServiceModule.class, AppModule.class})
public interface AppComponent {

    ApiService apiService();
    AppConfig appConfig();
    Gson gson();
    EventBus eventBus();
    Context context();
    ApiController apiController();

    /* This should be in an ActivityComponent but we just use one AppComponent to simplify
     */
    void inject(MainActivity activity);
}
