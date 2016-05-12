package com.example.planetmedia.demoappfinmex.fragments;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.planetmedia.demoappfinmex.ModeloMovimientos;
import com.example.planetmedia.demoappfinmex.R;
import com.example.planetmedia.demoappfinmex.adapters.recycler_movimientos_adapter;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class MisCuentasFragment extends Fragment {
    View v;
    private Spinner spinner;
    TextView txtFechaInicio;
    TextView numFechaInicio;
    TextView txtFechaFin;
    TextView numFechaFin;
    ImageView ic_cal1;
    ImageView ic_cal2;
    RecyclerView recycler_movimientos;
    ModeloMovimientos[] modelo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_mis_cuentas, container, false);

        txtFechaInicio = (TextView)v.findViewById(R.id.txtFechaInicio);
        txtFechaInicio.setVisibility(View.GONE);
        txtFechaFin = (TextView)v.findViewById(R.id.txtFechaFin);
        txtFechaFin.setVisibility(View.GONE);
        numFechaInicio = (TextView)v.findViewById(R.id.numFechaInicio);
        numFechaInicio.setVisibility(View.GONE);
        numFechaFin = (TextView)v.findViewById(R.id.numFechaFin);
        numFechaFin.setVisibility(View.GONE);
        ic_cal1 = (ImageView)v.findViewById(R.id.ic_cal1);
        ic_cal1.setVisibility(View.GONE);
        ic_cal2 = (ImageView)v.findViewById(R.id.ic_cal2);
        ic_cal2.setVisibility(View.GONE);

        String[]paths = {"Últimos 10 Movimientos", "Rango de Fechas"};

        spinner = (Spinner) v.findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this.getActivity(), android.R.layout.simple_spinner_item, paths);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 1) {

                    txtFechaInicio = (TextView) v.findViewById(R.id.txtFechaInicio);
                    txtFechaInicio.setVisibility(View.VISIBLE);
                    txtFechaFin = (TextView) v.findViewById(R.id.txtFechaFin);
                    txtFechaFin.setVisibility(View.VISIBLE);
                    numFechaInicio = (TextView) v.findViewById(R.id.numFechaInicio);
                    numFechaInicio.setVisibility(View.VISIBLE);
                    numFechaFin = (TextView) v.findViewById(R.id.numFechaFin);
                    numFechaFin.setVisibility(View.VISIBLE);
                    ic_cal1 = (ImageView) v.findViewById(R.id.ic_cal1);
                    ic_cal1.setVisibility(View.VISIBLE);
                    ic_cal2 = (ImageView) v.findViewById(R.id.ic_cal2);
                    ic_cal2.setVisibility(View.VISIBLE);
                } else {
                    txtFechaInicio = (TextView) v.findViewById(R.id.txtFechaInicio);
                    txtFechaInicio.setVisibility(View.GONE);
                    txtFechaFin = (TextView) v.findViewById(R.id.txtFechaFin);
                    txtFechaFin.setVisibility(View.GONE);
                    numFechaInicio = (TextView) v.findViewById(R.id.numFechaInicio);
                    numFechaInicio.setVisibility(View.GONE);
                    numFechaFin = (TextView) v.findViewById(R.id.numFechaFin);
                    numFechaFin.setVisibility(View.GONE);
                    ic_cal1 = (ImageView) v.findViewById(R.id.ic_cal1);
                    ic_cal1.setVisibility(View.GONE);
                    ic_cal2 = (ImageView) v.findViewById(R.id.ic_cal2);
                    ic_cal2.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ic_cal2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog calendario = new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                                StringBuilder fecha = new StringBuilder();
                                fecha.append(dayOfMonth).append("/").append(monthOfYear).append("/").append(year);
                                numFechaFin.setText(fecha.toString());
                            }
                        }, year, month, day);
                calendario.show();

            }
        });

        modelo = new ModeloMovimientos[25];
        int y = 0;
        for (int i = 0; i < 25; i ++){
            modelo[i] = new ModeloMovimientos("Finmex", "ARW-00001234", "AMORTIZACION EN VENTANILLA", "$14,920.00" + y++);
        }

        recycler_movimientos = (RecyclerView)v.findViewById(R.id.recycler_movimientos);
        recycler_movimientos.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recycler_movimientos.setAdapter(new recycler_movimientos_adapter(modelo, getActivity()));


        return v;
    }


}
