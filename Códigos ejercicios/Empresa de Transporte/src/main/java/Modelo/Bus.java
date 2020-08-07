package Modelo;

import java.util.Date;

public class Bus extends Vehiculo{

    private TipoBus tipoBus;

    public Bus(String patente, String chasis, int eje, String marca, Date fechaCompra, double kilometrajeAct, double kilometrajeManutencion, int diaFechaUltimaMantencion, int mesFechaUltimaMantencion, int anioFechaUltimaMantencion, String estado, TipoBus tipoBus) {
        super(patente, chasis, eje, marca, fechaCompra, kilometrajeAct, kilometrajeManutencion, diaFechaUltimaMantencion, mesFechaUltimaMantencion, anioFechaUltimaMantencion, estado);
        this.tipoBus = tipoBus;
    }

    public TipoBus getTipoBus() {
        return tipoBus;
    }

    public void setTipoBus(TipoBus tipoBus) {
        this.tipoBus = tipoBus;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "patente= " + patente +
                ", chasis= " + chasis +
                ", eje=" + eje +
                ", marca= " + marca +
                ", fechaCompra= " + fechaCompra +
                ", kilometrajeAct= " + kilometrajeAct +
                ", kilometrajeManutencion= " + kilometrajeManutencion +
                ", diaFechaUltimaMantencion= " + diaFechaUltimaMantencion +
                ", mesFechaUltimaMantencion= " + mesFechaUltimaMantencion +
                ", anioFechaUltimaMantencion= " + anioFechaUltimaMantencion +
                ", estado= " + estado +
                ", tipoBus= " + tipoBus +
                '}';
    }
}
