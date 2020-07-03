package Modelo;

import java.util.Date;

public class Estudiante extends Persona{

    private double promedio;

    public Estudiante(String nombre, String direccion, String rut, Date fechaIncorporacion, double promedio) {
        super(nombre, direccion, rut, fechaIncorporacion);
        this.promedio = promedio;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre= " + nombre +
                ", direccion= '" + direccion + '\'' +
                ", rut= '" + rut + '\'' +
                ", fechaIncorporacion= '" + fechaIncorporacion + '\'' +
                ", promedio= " + promedio +
                '}';
    }
}
