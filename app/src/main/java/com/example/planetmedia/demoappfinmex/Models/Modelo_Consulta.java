package com.example.planetmedia.demoappfinmex.Models;

/**
 * Created by mario.aguilar on 12/05/2016.
 */
public class Modelo_Consulta {

   private String Credito;
   private String NombreProducto;
   private String Alias;
   private int Saldo_Insoluto;
   private int Saldo_Disponible;
   private int Monto_Liquidar;

    public Modelo_Consulta(String credito, String nombreProducto, String alias, int saldo_Insoluto, int saldo_Disponible, int monto_Liquidar) {
        Credito = credito;
        NombreProducto = nombreProducto;
        Alias = alias;
        Saldo_Insoluto = saldo_Insoluto;
        Saldo_Disponible = saldo_Disponible;
        Monto_Liquidar = monto_Liquidar;
    }

    public String getCredito() {
        return Credito;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public String getAlias() {
        return Alias;
    }

    public int getSaldo_Insoluto() {
        return Saldo_Insoluto;
    }

    public int getSaldo_Disponible() {
        return Saldo_Disponible;
    }

    public int getMonto_Liquidar() {
        return Monto_Liquidar;
    }
}
