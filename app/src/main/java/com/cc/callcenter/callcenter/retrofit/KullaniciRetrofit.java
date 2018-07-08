package com.cc.callcenter.callcenter.retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by vektorel on 01.07.2018.
 */

public interface KullaniciRetrofit {

    @GET("/kullanici/login")
    Call<KullaniciDto> login(@Query("username") String username, @Query("pwd") String pwd);

    @POST("/kullanici/register")
    Call<KullaniciDto> register(@Body KullaniciDto kullaniciDto);

}
