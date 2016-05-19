package com.example.user.xplore.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.xplore.R;

public class CameraFragment extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View cameraLayout=inflater.inflate(R.layout.main_tab2_fragment,container,false);
    return cameraLayout;
    }
}
