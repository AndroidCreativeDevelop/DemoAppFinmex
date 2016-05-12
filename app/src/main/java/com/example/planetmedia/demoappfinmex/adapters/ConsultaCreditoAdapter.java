package com.example.planetmedia.demoappfinmex.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.planetmedia.demoappfinmex.Models.Modelo_Consulta;
import com.example.planetmedia.demoappfinmex.R;

/**
 * Created by mario.aguilar on 12/05/2016.
 */
public class ConsultaCreditoAdapter  extends RecyclerView.Adapter<ConsultaCreditoAdapter.CreditoHolder> {

    Modelo_Consulta [] Model =new Modelo_Consulta[20];

    public ConsultaCreditoAdapter(Modelo_Consulta[] model) {
        Model = model;
    }

    @Override
    public CreditoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_credito,parent,false);

        CreditoHolder holder = new CreditoHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(CreditoHolder holder, int position) {
        holder.numCredito.setText(Model[position].getCredito());
        holder.ProductoCredito.setText(Model[position].getNombreProducto());
        holder.Alias.setText(Model[position].getAlias());
        holder.SaldoInsoluto.setText(Integer.toString(Model[position].getSaldo_Insoluto()));
        holder.SaldoDisponible.setText(Integer.toString( Model[position].getSaldo_Disponible()));
        holder.MontoLiquidar.setText(Integer.toString( Model[position].getMonto_Liquidar()));
    }

    @Override
    public int getItemCount() {
        return Model.length;
    }

    public class CreditoHolder extends RecyclerView.ViewHolder{

        TextView numCredito;
        TextView ProductoCredito;
        TextView Alias;
        TextView SaldoInsoluto;
        TextView SaldoDisponible;
        TextView MontoLiquidar;

        public CreditoHolder(View itemView) {
            super(itemView);

             numCredito =(TextView)itemView.findViewById(R.id.NumCredito);
                     ProductoCredito=(TextView)itemView.findViewById(R.id.ProductoCredito);
             Alias =(TextView)itemView.findViewById(R.id.AliasCredito);
             SaldoInsoluto=(TextView)itemView.findViewById(R.id.SaldoInsoluto);
             SaldoDisponible=(TextView)itemView.findViewById(R.id.SaldoDisponible);
             MontoLiquidar =(TextView)itemView.findViewById(R.id.MontoLiquidar);
        }
    }
}
