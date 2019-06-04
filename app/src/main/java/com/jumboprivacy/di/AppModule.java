package com.jumboprivacy.di;

import android.app.Application;
import android.content.Context;
import com.jumboprivacy.AppConfig;
import dagger.Module;
import dagger.Provides;

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
}
