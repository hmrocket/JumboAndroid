package com.jumboprivacy.di;

import android.app.Application;
import android.content.Context;
import com.google.gson.Gson;
import com.jumboprivacy.AppConfig;
import com.jumboprivacy.api.ApiService;
import com.jumboprivacy.controller.ApiController;
import dagger.Module;
import dagger.Provides;
import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

@Module
public class AppModule {


    private final Context appContext;

    public AppModule(Application app) {
        this.appContext = app.getApplicationContext();
    }

    @Provides
    AppConfig provideAppConfig() {
        return new AppConfig(appContext);
    }

    @Provides
    EventBus provideEventBus() {
        return EventBus.getDefault();
    }

    @Provides
    Context provideContext() {
        return appContext;
    }

    @Provides
    @Inject
    ApiController provideApiController(ApiService apiService, AppConfig appConfig, Gson gson, EventBus eventBus) {
        return new ApiController(apiService, appConfig, gson, eventBus, appContext);
    }
}
