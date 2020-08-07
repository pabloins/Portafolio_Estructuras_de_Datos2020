package Modelo;

public enum TipoBus {

    TRANSPORTEDEPASAJEROS1(1,"Transporte de Pasajeros"),
    TRANSPORTEDEPASAJEROS2(2, "Transporte de Pasajeros"),
    TRANSPORTEDEENCOMIENDAS1(1, "Transporte de Encomiendas"),
    TRANSPORTEDEENCOMIENDAS2(2,"Transporte de Encomiendas");

    private int pisos;
    private String carga;

    TipoBus(int pisos, String carga) {
        this.pisos = pisos;
        this.carga = carga;
    }

    public int getPisos() {
        return pisos;
    }

    public String getCarga() {
        return carga;
    }
}
