package com.cc.callcenter.callcenter.service;

import com.cc.callcenter.callcenter.retrofit.KullaniciDto;
import com.cc.callcenter.callcenter.retrofit.KullaniciRetrofit;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by vektorel on 01.07.2018.
 */

public class KullaniciService {
    Retrofit retrofit = null;
    KullaniciRetrofit kullaniciRetrofit;


    public KullaniciService() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.11.12:8080")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        kullaniciRetrofit = retrofit.create(KullaniciRetrofit.class);
    }


    public KullaniciDto login(String username,String pwd) throws Exception {
        return kullaniciRetrofit.login(username,pwd).execute().body();
    }

    public KullaniciDto register(KullaniciDto kullaniciDto) throws Exception {
        return kullaniciRetrofit.register(kullaniciDto).execute().body();
    }

    public List<KullaniciDto> liste() throws Exception {
        return kullaniciRetrofit.liste().execute().body();
    }
}
