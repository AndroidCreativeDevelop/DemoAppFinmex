package com.example.planetmedia.demoappfinmex;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;

import com.example.planetmedia.demoappfinmex.Models.Modelo_Consulta;
import com.example.planetmedia.demoappfinmex.adapters.ConsultaCreditoAdapter;

/**
 * Created by mario.aguilar on 11/05/2016.
 */
public class Activity_ConsultaCreditos extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creditos);
        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tb);

        Modelo_Consulta[] Modelo=new Modelo_Consulta[20];

        RecyclerView recyclerView =(RecyclerView)findViewById(R.id.recycler_creditos);

        int Incremento =50;
        for (int i =0; i<Modelo.length;i++){
            Modelo[i]= new Modelo_Consulta("***46","Habilitacion y Avio 1","ocho",12500+Incremento*2,35500+Incremento,5000+Incremento*3);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ConsultaCreditoAdapter(Modelo));
    }
}
