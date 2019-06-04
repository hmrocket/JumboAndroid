package com.jumboprivacy.api;

import com.jumboprivacy.api.response.PayloadFileResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("{repo}/latest")
    Call<PayloadFileResponse> getPayload(
            @Path("repo") String repo
    );
}
