package com.bwei.shopdemo.base;

import android.view.View;

import com.socks.library.KLog;

/**
 * Created by muhanxi on 17/6/17.
 */

public  abstract  class BasePresenter<T> {

    public T view ;

    public void attach(T view){
        this.view = view;
        KLog.i("BasePresenter attach",view);

    }

    public void detach(){
        KLog.i("BasePresenter detach",view);
        this.view = null;

    }


}
