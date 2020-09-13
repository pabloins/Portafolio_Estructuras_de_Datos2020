package Modelo;

import java.util.Date;

public abstract class InstrumentoMusical {

    protected int id;
    protected String fabricante;
    protected String nombreInstrumento;
    protected String modelo;
    protected double precio;
    protected Date fechaIngreso;

    public InstrumentoMusical(int id, String fabricante, String nombreInstrumento, String modelo, double precio, Date fechaIngreso) {
        this.id = id;
        this.fabricante = fabricante;
        this.nombreInstrumento = nombreInstrumento;
        this.modelo = modelo;
        this.precio = precio;
        this.fechaIngreso = fechaIngreso;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getFabricante() { return fabricante; }

    public void setFabricante(String fabricante) { this.fabricante = fabricante; }

    public String getNombreInstrumento() { return nombreInstrumento; }

    public void setNombreInstrumento(String nombreInstrumento) { this.nombreInstrumento = nombreInstrumento; }

    public String getModelo() { return modelo; }

    public void setModelo(String modelo) { this.modelo = modelo; }

    public double getPrecio() { return precio; }

    public void setPrecio(double precio) { this.precio = precio; }

    public Date getFechaIngreso() { return fechaIngreso; }

    public void setFechaIngreso(Date fechaIngreso) { this.fechaIngreso = fechaIngreso; }

    @Override
    public String toString() {
        return "InstrumentoMusical{" +
                "id= " + id +
                ", fabricante= " + fabricante +
                ", nombreInstrumento= " + nombreInstrumento +
                ", modelo= " + modelo +
                ", precio= " + precio +
                ", fechaIngreso= " + fechaIngreso +
                '}';
    }
}