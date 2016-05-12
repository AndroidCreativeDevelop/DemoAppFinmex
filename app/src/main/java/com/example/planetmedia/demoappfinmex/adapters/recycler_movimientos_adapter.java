package com.example.planetmedia.demoappfinmex.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.planetmedia.demoappfinmex.ModeloMovimientos;
import com.example.planetmedia.demoappfinmex.R;

/**
 * Created by PlanetMedia on 12/05/2016.
 */
public class recycler_movimientos_adapter extends RecyclerView.Adapter<recycler_movimientos_adapter.ViewHolderMovimientos> {
    private Context context;
    private ModeloMovimientos[] modelo;

    public recycler_movimientos_adapter(ModeloMovimientos[] modelo, Context context){

        this.context = context;
        this.modelo = modelo;
    }

    @Override
    public recycler_movimientos_adapter.ViewHolderMovimientos onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_movimientos,parent, false);

        ViewHolderMovimientos holder = new ViewHolderMovimientos(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(recycler_movimientos_adapter.ViewHolderMovimientos holder, int position) {
        holder.numFecha.setText(modelo[position].getFecha());
        holder.numFolio.setText(modelo[position].getFolio());
        holder.numMonto.setText(modelo[position].getMonto());
        holder.txtConcepto.setText(modelo[position].getConcepto());

    }

    @Override
    public int getItemCount() {
        return modelo.length;
    }

    public static class ViewHolderMovimientos extends RecyclerView.ViewHolder{

        private TextView numFecha;
        private TextView numFolio;
        private TextView txtConcepto;
        private TextView numMonto;

        public ViewHolderMovimientos(View itemView){
            super (itemView);

            numFecha = (TextView)itemView.findViewById(R.id.numFecha);
            numFolio = (TextView)itemView.findViewById(R.id.numFolio);
            txtConcepto = (TextView)itemView.findViewById(R.id.txtConcepto);
            numMonto = (TextView)itemView.findViewById(R.id.numMonto);


        }

    }
}
