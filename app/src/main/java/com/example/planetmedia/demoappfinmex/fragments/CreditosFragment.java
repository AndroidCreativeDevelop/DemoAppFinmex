package com.example.planetmedia.demoappfinmex.fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;

import com.example.planetmedia.demoappfinmex.Activity_ConsultaCreditos;
import com.example.planetmedia.demoappfinmex.R;
import com.hookedonplay.decoviewlib.DecoView;
import com.hookedonplay.decoviewlib.charts.SeriesItem;
import com.hookedonplay.decoviewlib.charts.SeriesLabel;

public class CreditosFragment extends Fragment {

    View view;
    DecoView Activo,Pasivo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       view= inflater.inflate(R.layout.fragment_creditos, container, false);

        Activo = (DecoView)view.findViewById(R.id.SaldoActivoGra);
        Pasivo = (DecoView)view.findViewById(R.id.SaldoPasivoGra);


        Pasivo.addSeries(new SeriesItem.Builder(Color.argb(255, 86, 182, 225))
                .setRange(0, 100, 100)
                .setInitialVisibility(false)
                .setLineWidth(32f)
                .setSpinClockwise(true)
                .setSpinDuration(6000)
                .setDrawAsPoint(false)
                .setSpinClockwise(true)
                .setSpinDuration(6000)
                .setChartStyle(SeriesItem.ChartStyle.STYLE_DONUT)
                .setSeriesLabel(new SeriesLabel.Builder("Percent %.0f%%").build())
                .build());

        Pasivo.configureAngles(360, 0);

        Activo.addSeries(new SeriesItem.Builder(Color.argb(255, 128, 224, 167))
                .setRange(0, 100, 100)
                .setInitialVisibility(false)
                .setLineWidth(32f)
                .setSpinClockwise(true)
                .setSpinDuration(6000)
                .setDrawAsPoint(false)
                .setSpinClockwise(true)
                .setSpinDuration(6000)
                .setChartStyle(SeriesItem.ChartStyle.STYLE_PIE)
                .setSeriesLabel(new SeriesLabel.Builder("Percent %.0f%%").build())
                .build());

        Activo.configureAngles(360, 60);

        SeriesItem seriesItem1 = new SeriesItem.Builder(Color.argb(127, 86, 182, 225))
                .setRange(0, 190, 80)
                .setInitialVisibility(true)
                .setLineWidth(20)
                .setCapRounded(true)

                .setDrawAsPoint(false)
                .setSpinClockwise(true)
                .setSpinDuration(6000)
                .setShowPointWhenEmpty(true)
                .build();

        SeriesItem seriesItem2 = new SeriesItem.Builder(Color.argb(127, 128, 224, 167))
                .setRange(0, 190 , 80)
                .setInitialVisibility(true)
                .setLineWidth(20)
                .setCapRounded(true)

                .setShowPointWhenEmpty(true)
                .build();


        Pasivo.addSeries(seriesItem1);
        Activo.addSeries(seriesItem2);

        ///// ************************************ Listeners

        Activo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Activity_ConsultaCreditos.class));
            }
        });



        Pasivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Activity_ConsultaCreditos.class));
            }
        });




        return view;
    }

}
