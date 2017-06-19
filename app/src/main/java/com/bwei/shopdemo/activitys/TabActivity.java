package com.bwei.shopdemo.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.bwei.shopdemo.R;
import com.bwei.shopdemo.base.IActivity;
import com.bwei.shopdemo.fragments.FirstFragment;
import com.bwei.shopdemo.fragments.FourthFragment;
import com.bwei.shopdemo.fragments.SecondFragment;
import com.bwei.shopdemo.fragments.ThirdFragment;
import com.bwei.shopdemo.widget.ButtomLayout;

import java.util.ArrayList;
import java.util.List;

public class TabActivity extends IActivity implements ButtomLayout.OnSelectButtomListener {


    private FragmentManager fragmentManager ;
    int index = 0 ;
    private static final  String INDEX_KEY ="index_key";
    public static List<Fragment> listFragment = new ArrayList<Fragment>();
    private ButtomLayout buttomLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);


        fragmentManager = getSupportFragmentManager() ;
        initFragment(savedInstanceState);


        buttomLayout = (ButtomLayout) findViewById(R.id.buttom_layout);
        buttomLayout.setOnSelectButtomListener(this);

        onSelect(0);







    }

    private void initFragment(Bundle savedInstanceState) {
        FirstFragment firstFragment = null ;
        SecondFragment secondFragment = null ;
        ThirdFragment thirdFragment = null ;
        FourthFragment fourthFragment = null ;

        firstFragment = (FirstFragment) fragmentManager.findFragmentByTag("FirstFragment");
        secondFragment = (SecondFragment) fragmentManager.findFragmentByTag("SecondFragment");
        thirdFragment = (ThirdFragment) fragmentManager.findFragmentByTag("ThirdFragment");
        fourthFragment = (FourthFragment) fragmentManager.findFragmentByTag("FourthFragment");

        if(firstFragment == null){
            firstFragment = new FirstFragment();
        }

        if(secondFragment == null){
            secondFragment = new SecondFragment();
        }

        if(thirdFragment == null){
            thirdFragment = new ThirdFragment();
        }

        if(fourthFragment == null){
            fourthFragment = new FourthFragment();
        }

        listFragment.add(firstFragment);
        listFragment.add(secondFragment);
        listFragment.add(thirdFragment);
        listFragment.add(fourthFragment);


    }

    // 切换tab
    public void switchTab(int position) {

        FragmentTransaction transaction =  fragmentManager.beginTransaction() ;

        if(!listFragment.get(position).isAdded()){
            transaction.add(R.id.main_container,listFragment.get(position),listFragment.get(position).getClass().toString());
        }
        for(int i= 0 ;i<listFragment.size();i++){
            if(i == position){
                transaction.show(listFragment.get(i));
            }else {
                transaction.hide(listFragment.get(i));
            }
        }
        transaction.commit();

    }


    @Override
    public void onSelect(int index) {
        switchTab(index);
    }
}
