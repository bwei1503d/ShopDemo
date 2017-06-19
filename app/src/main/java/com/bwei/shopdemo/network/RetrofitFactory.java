package com.bwei.shopdemo.network;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by muhanxi on 17/6/17.
 */

public class RetrofitFactory {




    private static final String BASE_URL = "http://qhb.2dyt.com" ;


    public static OkHttpClient  okHttpClient = new OkHttpClient.Builder()
            .writeTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20,TimeUnit.SECONDS)
            .connectTimeout(20,TimeUnit.SECONDS)
            .addNetworkInterceptor(new LoggingInterceptor())
            .build() ;
    public static  ApiService apiService  = new Retrofit.Builder()
            .addConverterFactory(ScalarsConverterFactory.create())
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build().create(ApiService.class);


    /**
     * 无参 get 请求
     * @param url
     * @param observer
     */
    public static void get(String url,BaseObserver observer){

        apiService.get(url).
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }


    public static void get(String url, Map<String,String> map,BaseObserver observer){
        apiService.get(url,map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }


    /**
     * post
     * @param url
     * @param map
     * @param observer
     */
    public static void post(String url,Map<String,String> map,BaseObserver observer){

        apiService.post(url,map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }









}
