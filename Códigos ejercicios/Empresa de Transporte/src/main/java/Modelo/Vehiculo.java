package Modelo;

import java.util.Date;

public class Vehiculo {

    protected String patente;
    protected String chasis;
    protected int eje;
    protected String marca;
    protected Date fechaCompra;
    protected double kilometrajeAct;
    protected double kilometrajeManutencion;
    protected int diaFechaUltimaMantencion;
    protected int mesFechaUltimaMantencion;
    protected int anioFechaUltimaMantencion;
    protected String estado;

    public Vehiculo(String patente, String chasis, int eje, String marca, Date fechaCompra, double kilometrajeAct, double kilometrajeManutencion, int diaFechaUltimaMantencion, int mesFechaUltimaMantencion, int anioFechaUltimaMantencion, String estado) {
        this.patente = patente;
        this.chasis = chasis;
        this.eje = eje;
        this.marca = marca;
        this.fechaCompra = fechaCompra;
        this.kilometrajeAct = kilometrajeAct;
        this.kilometrajeManutencion = kilometrajeManutencion;
        this.diaFechaUltimaMantencion = diaFechaUltimaMantencion;
        this.mesFechaUltimaMantencion = mesFechaUltimaMantencion;
        this.anioFechaUltimaMantencion = anioFechaUltimaMantencion;
        this.estado = estado;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getChasis() {
        return chasis;
    }

    public void setChasis(String chasis) {
        this.chasis = chasis;
    }

    public int getEje() {
        return eje;
    }

    public void setEje(int eje) {
        this.eje = eje;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public double getKilometrajeAct() {
        return kilometrajeAct;
    }

    public void setKilometrajeAct(double kilometrajeAct) {
        this.kilometrajeAct = kilometrajeAct;
    }

    public double getKilometrajeManutencion() {
        return kilometrajeManutencion;
    }

    public void setKilometrajeManutencion(double kilometrajeManutencion) {
        this.kilometrajeManutencion = kilometrajeManutencion;
    }

    public int getDiaFechaUltimaMantencion() {
        return diaFechaUltimaMantencion;
    }

    public void setDiaFechaUltimaMantencion(int diaFechaUltimaMantencion) {
        this.diaFechaUltimaMantencion = diaFechaUltimaMantencion;
    }

    public int getMesFechaUltimaMantencion() {
        return mesFechaUltimaMantencion;
    }

    public void setMesFechaUltimaMantencion(int mesFechaUltimaMantencion) {
        this.mesFechaUltimaMantencion = mesFechaUltimaMantencion;
    }

    public int getAnioFechaUltimaMantencion() {
        return anioFechaUltimaMantencion;
    }

    public void setAnioFechaUltimaMantencion(int anioFechaUltimaMantencion) {
        this.anioFechaUltimaMantencion = anioFechaUltimaMantencion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
