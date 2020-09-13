package Modelo;

import java.util.Date;

public class Guitarra extends InstrumentoMusical{

    private int cantidadCuerdas;
    private String tipoMadera;
    private String tipoCuerda;

    public Guitarra(int id, String fabricante, String nombreInstrumento, String modelo, double precio, Date fechaIngreso, int cantidadCuerdas, String tipoMadera, String tipoCuerda) {
        super(id, fabricante, nombreInstrumento, modelo, precio, fechaIngreso);
        this.cantidadCuerdas = cantidadCuerdas;
        this.tipoMadera = tipoMadera;
        this.tipoCuerda = tipoCuerda;
    }

    public int getCantidadCuerdas() { return cantidadCuerdas; }

    public void setCantidadCuerdas(int cantidadCuerdas) { this.cantidadCuerdas = cantidadCuerdas; }

    public String getTipoMadera() { return tipoMadera; }

    public void setTipoMadera(String tipoMadera) { this.tipoMadera = tipoMadera; }

    public String getTipoCuerda() { return tipoCuerda; }

    public void setTipoCuerda(String tipoCuerda) { this.tipoCuerda = tipoCuerda; }

    @Override
    public String toString() {
        return "Guitarra{" +
                "cantidadCuerdas= " + cantidadCuerdas +
                ", tipoMadera= " + tipoMadera +
                ", tipoCuerda= " + tipoCuerda +
                ", id= " + id +
                ", fabricante= " + fabricante +
                ", nombreInstrumento= " + nombreInstrumento +
                ", modelo= " + modelo +
                ", precio= " + precio +
                ", fechaIngreso= " + fechaIngreso +
                '}';
    }
}
