package com.jumboprivacy.api;

import com.google.gson.Gson;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.inject.Inject;

@Module
public class ApiServiceModule {

    @Provides
    Gson provideGson() {
        return new Gson();
    }

    @Provides
    @Inject
    ApiService provideApiService(Gson gson) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(ApiService.class);
    }
}
