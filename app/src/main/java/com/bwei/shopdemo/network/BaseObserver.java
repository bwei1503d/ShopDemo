package com.bwei.shopdemo.network;

import com.google.gson.Gson;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by muhanxi on 17/6/17.
 */

public abstract class BaseObserver<T> implements Observer<String> {

    private T object ;

    private Class clazz ;

    public BaseObserver(Class t){
        try {
            this.clazz = t ;
            this.object = (T) t.newInstance() ;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public BaseObserver(){

    }


    @Override
    public void onSubscribe(@NonNull Disposable d) {



    }

    @Override
    public void onError(@NonNull Throwable e) {

    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onNext(@NonNull String s) {
        if(object == null){
            onSuccess(s,null);
        }else {
            Gson gson = new Gson();
            T t = (T) gson.fromJson(s,clazz);
            onSuccess(s,t);
        }



    }

    public abstract void onSuccess(String data,T t);
    public abstract void onFailed();

}
