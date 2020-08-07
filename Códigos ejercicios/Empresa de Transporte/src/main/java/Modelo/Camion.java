package Modelo;

import java.util.Date;

public class Camion extends Vehiculo{

    private TipoCamion tipoCamion;

    public Camion(String patente, String chasis, int eje, String marca, Date fechaCompra, double kilometrajeAct, double kilometrajeManutencion, int diaFechaUltimaMantencion, int mesFechaUltimaMantencion, int anioFechaUltimaMantencion, String estado, TipoCamion tipoCamion) {
        super(patente, chasis, eje, marca, fechaCompra, kilometrajeAct, kilometrajeManutencion, diaFechaUltimaMantencion, mesFechaUltimaMantencion, anioFechaUltimaMantencion, estado);
        this.tipoCamion = tipoCamion;
    }

    public TipoCamion getTipoCamion() {
        return tipoCamion;
    }

    public void setTipoCamion(TipoCamion tipoCamion) {
        this.tipoCamion = tipoCamion;
    }

    @Override
    public String toString() {
        return "Camion{" +
                "patente= " + patente +
                ", chasis= " + chasis +
                ", eje= " + eje +
                ", marca= " + marca +
                ", fechaCompra= " + fechaCompra +
                ", kilometrajeAct= " + kilometrajeAct +
                ", kilometrajeManutencion= " + kilometrajeManutencion +
                ", diaFechaUltimaMantencion= " + diaFechaUltimaMantencion +
                ", mesFechaUltimaMantencion= " + mesFechaUltimaMantencion +
                ", anioFechaUltimaMantencion =" + anioFechaUltimaMantencion +
                ", estado= " + estado +
                ", tipoCamion= " + tipoCamion +
                '}';
    }
}
