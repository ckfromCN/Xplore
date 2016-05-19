package com.example.user.xplore.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.xplore.R;

public class HotFragment extends Fragment{
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View hotLayout=inflater.inflate(R.layout.xp_tab1_fragment,container,false);
        return hotLayout;
    }
}
