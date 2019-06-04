package com.jumboprivacy;

import android.app.Application;
import androidx.annotation.VisibleForTesting;
import com.jumboprivacy.di.AppComponent;
import com.jumboprivacy.di.AppModule;
import com.jumboprivacy.di.DaggerAppComponent;

public class JumboApp extends Application {

    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    @VisibleForTesting
    public void setAppComponent(AppComponent appComponent) {
        this.appComponent = appComponent;
    }
}
