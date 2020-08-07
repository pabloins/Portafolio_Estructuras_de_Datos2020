package Modelo;

public enum TipoCamion {

    TRANSPORTEDEALIMENTOS("Transporte de Alimentos"),
    TRANSPORTEDEMATERIALDECONSTRUCCION("Transporte de material de Construcción");

    private String funcion;

    TipoCamion(String funcion) {
        this.funcion = funcion;
    }

    public String getFuncion() {
        return funcion;
    }
}
