package com.bwei.shopdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.bwei.shopdemo.activitys.TabActivity;
import com.bwei.shopdemo.base.BaseMVPActivity;
import com.bwei.shopdemo.base.IActivity;
import com.bwei.shopdemo.presenters.MainActivityPresenter;
import com.bwei.shopdemo.views.MainActivityView;

public class MainActivity extends IActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        startActivity(new Intent(this, TabActivity.class));


    }
}
