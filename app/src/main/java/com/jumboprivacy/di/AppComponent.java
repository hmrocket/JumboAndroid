package com.jumboprivacy.di;

import com.jumboprivacy.AppConfig;
import com.jumboprivacy.api.ApiService;
import com.jumboprivacy.api.ApiServiceModule;
import com.jumboprivacy.ui.MainActivity;
import dagger.Component;

@Component(modules = {ApiServiceModule.class, AppModule.class})
public interface AppComponent {

    ApiService apiService();
    AppConfig appConfig();

    /* This should be in an ActivityComponent but we just use one AppComponent to simplify
     */
    void inject(MainActivity activity);
}
