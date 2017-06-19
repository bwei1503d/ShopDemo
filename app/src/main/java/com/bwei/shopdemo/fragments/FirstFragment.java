package com.bwei.shopdemo.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bwei.shopdemo.R;
import com.bwei.shopdemo.adapter.SimpleFragmentPagerAdapter;
import com.bwei.shopdemo.base.BasePresenter;
import com.bwei.shopdemo.base.MvpFragment;
import com.bwei.shopdemo.presenters.FirstFragmentPresenter;
import com.bwei.shopdemo.views.FirstFragmentView;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends MvpFragment<FirstFragmentView,FirstFragmentPresenter> implements FirstFragmentView {


    private TabLayout tabLayout;
    private ViewPager viewPager;

    private SimpleFragmentPagerAdapter adapter ;

    @Override
    public FirstFragmentPresenter initPresenter() {
        return new FirstFragmentPresenter();
    }

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view =  inflater.inflate(R.layout.fragment_first, container, false);

        initView(view);

        return view;
    }

    private void initView(View view) {
        tabLayout = (TabLayout) view.findViewById(R.id.first_fragment_tablayout);
        viewPager = (ViewPager) view.findViewById(R.id.first_fragment_viewpager);

        adapter = new SimpleFragmentPagerAdapter(getActivity().getSupportFragmentManager(),getActivity());

        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        presenter.getData();

    }

    @Override
    public void showData() {




    }
}
