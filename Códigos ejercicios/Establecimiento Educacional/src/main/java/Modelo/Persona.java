package Modelo;

import java.util.Date;

public abstract class Persona {

    protected String nombre;
    protected String direccion;
    protected String rut;
    protected Date fechaIncorporacion;

    public Persona(String nombre, String direccion, String rut, Date fechaIncorporacion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.rut = rut;
        this.fechaIncorporacion = fechaIncorporacion;
    }

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public Date getFechaIncorporacion() {
        return fechaIncorporacion;
    }

    public void setFechaIncorporacion(Date fechaIncorporacion) {
        this.fechaIncorporacion = fechaIncorporacion;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", rut='" + rut + '\'' +
                ", fechaIncorporacion=" + fechaIncorporacion +
                '}';
    }
}
