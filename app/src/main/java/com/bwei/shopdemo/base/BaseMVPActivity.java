package com.bwei.shopdemo.base;

import android.app.Activity;
import android.os.Bundle;

public abstract class BaseMVPActivity<V,T extends BasePresenter<V>> extends IActivity {


    public abstract T initPresenter();

    public T presenter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = initPresenter();


    }

    @Override
    protected void onResume() {
        super.onResume();

        presenter.attach((V) this);

        

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }


}
