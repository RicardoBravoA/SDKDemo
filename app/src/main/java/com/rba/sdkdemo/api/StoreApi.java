package com.rba.sdkdemo.api;

import com.rba.sdkdemo.model.request.LoginRequest;
import com.rba.sdkdemo.model.request.RegisterRequest;
import com.rba.sdkdemo.model.response.LoginResponse;
import com.rba.sdkdemo.model.response.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by Ricardo Bravo on 30/01/17.
 */

public interface StoreApi {

    @Headers("Content-Type: application/json")
    @POST()
    Call<LoginResponse> login(@Url String url, @Body LoginRequest loginRequest);

    @Headers("Content-Type: application/json")
    Call<RegisterResponse> register(@Url String url, @Body RegisterRequest registerRequest);

}
