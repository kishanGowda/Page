package com.example.page.MasterPackage;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient
    {
        //singleton class = there canonly be one instance of this class.

        public static Retrofit retrofit=null;
        public static final String BASE_URL="http://0c2d-180-151-117-169.ngrok.io";

        public static Retrofit getRetrofit()
        {

            if (retrofit == null) {

                HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
                httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);



                OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();



                retrofit = new Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl(BASE_URL)
                        .client(okHttpClient)
                        .build();
            }



        return retrofit;
    }
        public static LoginService getLoginService(){

            LoginService loginService = getRetrofit().create(LoginService.class);
            return loginService;
    }
    }


