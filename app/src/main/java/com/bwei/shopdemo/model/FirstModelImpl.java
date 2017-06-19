package com.bwei.shopdemo.model;

import com.bwei.shopdemo.bean.LoginBean;
import com.bwei.shopdemo.network.BaseObserver;
import com.bwei.shopdemo.network.RetrofitFactory;

import java.io.FileInputStream;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static android.R.attr.data;

/**
 * Created by muhanxi on 17/6/17.
 */

public class FirstModelImpl implements FirstModel {


    public void getData(){

        RetrofitFactory.get("", new BaseObserver<LoginBean>(LoginBean.class) {


            @Override
            public void onSuccess(String data, LoginBean loginBean) {

            }

            @Override
            public void onFailed() {

            }
        });


        RetrofitFactory.get("", new BaseObserver() {
            @Override
            public void onSuccess(String data, Object o) {

            }

            @Override
            public void onFailed() {

            }
        });

    }

}
