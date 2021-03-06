package Modelo;

import java.util.LinkedList;

public interface Operaciones {
    boolean revisionKilometros(double kilometraje);

    boolean revisionMeses(int dia, int mes, int anio);

    int calcularAnios(int dia, int mes, int anio);

    String revision(double kilometros, int dias, int meses, int anios);

    void mostrarListaBuses(LinkedList<Bus> list);

    void mostrarListaCamiones(LinkedList<Camion> list);
}
