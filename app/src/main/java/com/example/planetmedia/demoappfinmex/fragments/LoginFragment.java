package com.example.planetmedia.demoappfinmex.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.planetmedia.demoappfinmex.R;

/**
 * Created by mario.aguilar on 03/05/2016.
 */
public class LoginFragment extends Fragment {
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.login_fragment,container,false);

        return view ;
    }
}
