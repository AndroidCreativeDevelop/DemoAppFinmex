package com.example.planetmedia.demoappfinmex.fragments;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.planetmedia.demoappfinmex.R;

import app.minimize.com.seek_bar_compat.SeekBarCompat;

/**
 * Created by mario.aguilar on 03/05/2016.
 */
public class SolicitudFragment extends Fragment {

    SeekBarCompat barView,barPlazo;
    TextView Solicitud,Plazo;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.solicitud_fragment,container,false);
        ColorStateList csl = new ColorStateList(new int[][]{new int[0]}, new int[]{0xffffcc00});

        Solicitud = (TextView)view.findViewById(R.id.Dinero_Necesito);
        Plazo=(TextView)view.findViewById(R.id.Plazo_Prestamo);


        barView= (SeekBarCompat)view.findViewById(R.id.BarviewNecesito);
        barView.setThumbColor(getResources().getColor(R.color.Decendet));
        barView.setProgressColor(getResources().getColor(R.color.Decendet));
        barView.setProgressBackgroundColor(getResources().getColor(R.color.Componentes));
        barView.setMax(2000);

        barPlazo = (SeekBarCompat)view.findViewById(R.id.BarviewPlazo);
        barPlazo.setThumbColor(getResources().getColor(R.color.Decendet));
        barPlazo.setProgressColor(getResources().getColor(R.color.Decendet));
        barPlazo.setProgressBackgroundColor(getResources().getColor(R.color.Componentes));

        barPlazo.setMax(2000);

        // --------------------------------------------------------------------------------------------------------------

        barPlazo.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                System.out.println("Numero de plazo" + barPlazo.getProgress());
                Plazo.setText("$ " + Double.parseDouble(barPlazo.getProgress() + ""));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        barView.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                System.out.println("Numero de plazo" + barPlazo.getProgress());
                Solicitud.setText("$ " + Double.parseDouble(barView.getProgress() + ""));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        return view;
    }
}
