package com.example.planetmedia.demoappfinmex;

/**
 * Created by PlanetMedia on 12/05/2016.
 */
public class ModeloMovimientos {
    private String Folio;
    private String Fecha;
    private String Concepto;
    private String Monto;

    public ModeloMovimientos (String folio, String fecha, String concepto, String monto){
        this.Concepto = concepto;
        this.Fecha = fecha;
        this.Monto = monto;
        this.Folio = folio;

    }

    public String getConcepto() {
        return Concepto;
    }

    public void setConcepto(String concepto) {
        Concepto = concepto;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getFolio() {
        return Folio;
    }

    public void setFolio(String folio) {
        Folio = folio;
    }

    public String getMonto() {
        return Monto;
    }

    public void setMonto(String monto) {
        Monto = monto;
    }
}
