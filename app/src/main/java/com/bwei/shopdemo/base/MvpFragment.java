package com.bwei.shopdemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by muhanxi on 17/6/17.
 */

public abstract class MvpFragment<V,T extends BasePresenter<V>> extends IFragment {

    public abstract T initPresenter();

    public T presenter;


    public MvpFragment(){

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = initPresenter();
        presenter.attach((V) this);

    }

    @Override
    public void onResume() {
        super.onResume();


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }
}
