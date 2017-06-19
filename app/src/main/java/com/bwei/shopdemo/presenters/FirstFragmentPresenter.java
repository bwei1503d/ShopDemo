package com.bwei.shopdemo.presenters;

import com.bwei.shopdemo.base.BasePresenter;
import com.bwei.shopdemo.views.FirstFragmentView;

/**
 * Created by muhanxi on 17/6/17.
 */

public class FirstFragmentPresenter  extends BasePresenter<FirstFragmentView> {

    public FirstFragmentPresenter(){

    }


    public void getData(){



        view.showData();

    }


}
