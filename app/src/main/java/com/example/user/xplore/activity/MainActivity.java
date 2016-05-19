package com.example.user.xplore.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.user.xplore.R;
import com.example.user.xplore.fragment.CameraFragment;
import com.example.user.xplore.fragment.MyFragment;
import com.example.user.xplore.fragment.XploreFragment;


public class MainActivity extends Activity implements View.OnClickListener {
    /*
    三个tab布局
     */
    private RelativeLayout xpLayout, cameraLayout, myLayout;
    /*
    三个fragment
     */
    private Fragment xpFragment, cameraFragment, myFragment;
    /*
    底部标签的文字和图片
     */
    private TextView xpTv, cameraTv, myTv;
    private ImageView xpImg, cameraImg, myImg;

    /*
    用于管理的fragmentManager
     */
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        fragmentManager = getFragmentManager();
        setTabSelection(1);
    }
    /*
       找三个tab布局,并注册点击事件
        */
    private void initUI() {

        xpLayout = (RelativeLayout) findViewById(R.id.xp);
        cameraLayout = (RelativeLayout) findViewById(R.id.camera);
        myLayout = (RelativeLayout) findViewById(R.id.my);
        xpLayout.setOnClickListener(this);
        cameraLayout.setOnClickListener(this);
        myLayout.setOnClickListener(this);

        xpTv = (TextView) findViewById(R.id.xplore1_text);
        cameraTv = (TextView) findViewById(R.id.camera_text);
        myTv = (TextView) findViewById(R.id.my_text);

        xpImg = (ImageView) findViewById(R.id.xplore1_image);
        cameraImg = (ImageView) findViewById(R.id.camera_image);
        myImg = (ImageView) findViewById(R.id.my_image);
    }
    
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.xp:
                setTabSelection(0);
                break;
            case R.id.camera:
                setTabSelection(1);
                break;
            case R.id.my:
                setTabSelection(2);
        }
    }

    /*
    根据选择的tab下标来设置选中的标签
     */
    private void setTabSelection(int i) {
        //清除上一次的选中状态
        clearSelection();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //隐藏所有fragment,以防显示多个fragment在界面上
        hiddenFragments(transaction);
        switch (i) {
            case 0:
                xpImg.setImageResource(R.drawable.diamond_1);
                xpTv.setTextColor(Color.parseColor("#ff7f27"));
                if (xpFragment == null) {
                    xpFragment = new XploreFragment();
                    transaction.add(R.id.content, xpFragment);

                } else {
                    transaction.show(xpFragment);
                }
                break;
            case 1:
                cameraImg.setImageResource(R.drawable.camera_1);
                cameraTv.setTextColor(Color.parseColor("#ff7f27"));
                if (cameraFragment == null) {
                    cameraFragment = new CameraFragment();
                    transaction.add(R.id.content, cameraFragment);
                } else {
                    transaction.show(cameraFragment);
                }
                break;
            case 2:
                myImg.setImageResource(R.drawable.person_1);
                myTv.setTextColor(Color.parseColor("#ff7f27"));
                if (myFragment == null) {
                    myFragment = new MyFragment();
                    transaction.add(R.id.content, myFragment);
                } else {
                    transaction.show(myFragment);
                }
                break;
        }
        transaction.commit();
    }



    private void clearSelection() {
        xpImg.setImageResource(R.drawable.diamond);
        cameraImg.setImageResource(R.drawable.camera);
        myImg.setImageResource(R.drawable.person);

        xpTv.setTextColor(Color.BLACK);
        cameraTv.setTextColor(Color.BLACK);
        myTv.setTextColor(Color.BLACK);
    }

    private void hiddenFragments(FragmentTransaction transaction) {
        if (xpFragment != null)
            transaction.hide(xpFragment);
        if (cameraFragment != null)
            transaction.hide(cameraFragment);
        if (myFragment != null)
            transaction.hide(myFragment);

    }


   


}



