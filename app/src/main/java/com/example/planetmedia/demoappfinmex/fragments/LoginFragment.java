package com.example.planetmedia.demoappfinmex.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.planetmedia.demoappfinmex.DetalleCredito;
import com.example.planetmedia.demoappfinmex.R;

/**
 * Created by mario.aguilar on 03/05/2016.
 */
public class LoginFragment extends Fragment {
    View view;
    Button btn_inicio;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.login_fragment,container,false);

        btn_inicio  = (Button)view.findViewById(R.id.btn_inicio);
        btn_inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DetalleCredito.class);
                startActivity(intent);
            }
        });

        return view ;
    }
}
