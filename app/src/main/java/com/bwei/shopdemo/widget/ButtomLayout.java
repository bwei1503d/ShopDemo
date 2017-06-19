package com.bwei.shopdemo.widget;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bwei.shopdemo.R;

/**
 * Created by muhanxi on 17/6/18.
 */

public class ButtomLayout extends LinearLayout {

    private RadioGroup radioGroup;
    private RadioButton radioButtonFirst;
    private RadioButton radioButtonSecond;
    private RadioButton radioButtonThird;
    private RadioButton radioButtonFourth;

    public ButtomLayout(Context context) {
        this(context,null);
    }

    public ButtomLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ButtomLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


       View view =  LayoutInflater.from(context).inflate(R.layout.tab_layout,this);

        radioGroup = (RadioGroup) findViewById(R.id.tab_radiogroup);

        radioButtonFirst = (RadioButton) findViewById(R.id.radiobutton_home);
        radioButtonSecond = (RadioButton) findViewById(R.id.radiobutton_discover);
        radioButtonThird = (RadioButton) findViewById(R.id.radiobutton_feed);
        radioButtonFourth = (RadioButton) findViewById(R.id.radiobutton_me);




        initClick();
        radioButtonFirst.setChecked(true);

    }

    private void initClick() {


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

                switch (checkedId){

                    case R.id.radiobutton_home:
                        setSelected(0);
                        break;

                    case R.id.radiobutton_discover:
                        setSelected(1);

                        break;

                    case R.id.radiobutton_feed:
                        setSelected(2);

                        break;

                    case R.id.radiobutton_me:
                        setSelected(3);

                        break;

                }

            }
        });

    }

    public void setSelected(int index){
        if(onSelectButtonListener != null){
            onSelectButtonListener.onSelect(index);
        }
    }


    public interface OnSelectButtomListener {

        public void onSelect(int index);

    }


    public OnSelectButtomListener onSelectButtonListener;


    public void setOnSelectButtomListener (OnSelectButtomListener listener){

        this.onSelectButtonListener = listener;

    }




}
