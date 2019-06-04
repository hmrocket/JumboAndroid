package com.jumboprivacy.api;

import com.jumboprivacy.api.response.PayloadFileResponse;
import dagger.Module;
import dagger.Provides;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiServiceModule {


    @Provides
    ApiService provideApiService() {
        /*
        it could be interesting to use custom adapter, to decode the string just after parsing.
         */
        // new GsonBuilder();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        apiService.getPayload("repoo").enqueue(new Callback<PayloadFileResponse>() {
            @Override
            public void onResponse(Call<PayloadFileResponse> call, Response<PayloadFileResponse> response) {

            }

            @Override
            public void onFailure(Call<PayloadFileResponse> call, Throwable t) {

            }
        });
        return apiService;
    }
}
