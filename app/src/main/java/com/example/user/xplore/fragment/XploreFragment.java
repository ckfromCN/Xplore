package com.example.user.xplore.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.xplore.R;
import com.example.user.xplore.activity.PostAcitivity;
import com.example.user.xplore.activity.SearchActivity;

public class XploreFragment extends Fragment implements View.OnClickListener {
    /*
    享部落模块顶部五个标签,两个图片按钮,三个文字按钮
     */
    private TextView hotTv, channelTv, newsetTv;
    private ImageView searchImg, postImg;
    /*
    三个文字按钮对应的fragment
     */
    private Fragment hotFragment, channelFragment, newestFragment;
    /*
    用于管理的fragmentManager
     */
    private FragmentManager fragmentManager;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
       

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View xpLayout = inflater.inflate(R.layout.main_tab1_fragment, container, false);
        hotTv = (TextView) xpLayout.findViewById(R.id.hot);
        channelTv = (TextView) xpLayout.findViewById(R.id.channel);
        newsetTv = (TextView) xpLayout.findViewById(R.id.newest);
        searchImg = (ImageView) xpLayout.findViewById(R.id.search_button);
        postImg = (ImageView) xpLayout.findViewById(R.id.post_button);


        fragmentManager = getFragmentManager();
        hotTv.setOnClickListener(this);
        channelTv.setOnClickListener(this);
        newsetTv.setOnClickListener(this);
        searchImg.setOnClickListener(this);
        postImg.setOnClickListener(this);
      

        return xpLayout;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
      

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.search_button:
                Intent intent1=new Intent(getActivity(), SearchActivity.class);
                startActivity(intent1);
                break;
            case R.id.hot:
                setTabSelection(0);
                break;  
            case R.id.channel:
                setTabSelection(1);
                break;  
            case R.id.newest:
                setTabSelection(2);
                break;
            case R.id.post_button:
                Intent intent2=new Intent(getActivity(), PostAcitivity.class);
                startActivity(intent2);
                break;
        }
    }

    private void setTabSelection(int i) {
        clearSelection();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hiddenFragment(transaction);
        switch (i) {
            case 0:
                hotTv.setTextColor(Color.parseColor("#ff7f27"));
                if (hotFragment == null) {
                    hotFragment = new HotFragment();
                    transaction.add(R.id.xp_content, hotFragment);
                } else {
                    transaction.show(hotFragment);
                }
                break;
            case 1:
                channelTv.setTextColor(Color.parseColor("#ff7f27"));
                if (channelFragment == null) {
                    channelFragment = new ChannelFragment();
                    transaction.add(R.id.xp_content, channelFragment);
                } else {
                    transaction.show(channelFragment);
                }
                break;
            case 2:
                newsetTv.setTextColor(Color.parseColor("#ff7f27"));
                if (newestFragment == null) {
                    newestFragment = new NewestFragment();
                    transaction.add(R.id.xp_content, newestFragment);
                } else {
                    transaction.show(newestFragment);
                }
                break;
        }
        transaction.commit();

    }

    private void clearSelection() {
        hotTv.setTextColor(Color.BLACK);
        channelTv.setTextColor(Color.BLACK);
        newsetTv.setTextColor(Color.BLACK);
    }

    private void hiddenFragment(FragmentTransaction transaction) {
        if (hotFragment!=null)
            transaction.hide(hotFragment);
        if (channelFragment!=null)
            transaction.hide(channelFragment);
        if (newestFragment!=null)
            transaction.hide(newestFragment);
    }
}
