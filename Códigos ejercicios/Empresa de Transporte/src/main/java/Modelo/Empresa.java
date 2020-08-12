package Modelo;

import java.util.*;

public class Empresa implements Operaciones{

    private LinkedList<Bus> buses;
    private LinkedList<Camion> camiones;

    public Empresa() {
        this.buses = new LinkedList<>();
        this.camiones = new LinkedList<>();
    }

    public LinkedList<Bus> getBuses() { return buses; }

    public void setBuses(LinkedList<Bus> buses) { this.buses = buses; }

    public LinkedList<Camion> getCamiones() { return camiones; }

    public void setCamiones(LinkedList<Camion> camiones) { this.camiones = camiones; }

    public void ordenarBusFecha(LinkedList<Bus> buses){
        if(buses.isEmpty()){
            throw new NullPointerException("No hay buses en la lista");
        }
        Comparator<Bus> comparator
                = Comparator
                .comparing(Bus::getAnioFechaUltimaMantencion)
                .thenComparingInt(Bus::getAnioFechaUltimaMantencion)
                .thenComparingInt(Bus::getMesFechaUltimaMantencion)
                .thenComparingInt(Bus::getDiaFechaUltimaMantencion)
                .thenComparing(Bus::getTipoBus);
        buses.sort(comparator);
    }

    public void busAlDia(Bus bus, LinkedList<Bus> list){
        if(buses.isEmpty()){
            throw new NullPointerException("No hay buses en la lista");
        }
        if(buses.contains(bus)){
            if(revision(bus.getKilometrajeAct()
                    ,bus.getDiaFechaUltimaMantencion()
                    ,bus.getMesFechaUltimaMantencion(),bus.getAnioFechaUltimaMantencion()).equals("Esta al día")){
                list.add(bus);
                ordenarBusFecha(list);
            }
        }
    }

    public void mantencionBusTipo(Bus bus, LinkedList<Bus> list){
        if(buses.isEmpty()){
            throw new NullPointerException("No hay buses en la lista");
        }
        if (buses.contains(bus)){
            if(revision(bus.getKilometrajeAct()
                    ,bus.getDiaFechaUltimaMantencion()
                    ,bus.getMesFechaUltimaMantencion(),bus.getAnioFechaUltimaMantencion()).equals("Necesita mantención")){
                list.add(bus);
                ordenarBusFecha(list);
            }
        }
    }

    public void busMantencionKilometros(Bus bus, LinkedList<Bus> list){
        if(buses.isEmpty()){
            throw new NullPointerException("No hay buses en la lista");
        }
        if (buses.contains(bus)){
            if(revision(bus.getKilometrajeAct()
                    ,bus.getDiaFechaUltimaMantencion()
                    ,bus.getMesFechaUltimaMantencion()
                    ,bus.getAnioFechaUltimaMantencion()).equals("Necesita mantención")){
                    if(bus.getKilometrajeAct() < 60000){
                        list.add(bus);
                        ordenarBusFecha(list);
                }
            }
        }
    }

    public void ordenarCamionFecha(LinkedList<Camion> camiones){
        if(camiones.isEmpty()){
            throw new NullPointerException("No hay camiones en la lista");
        }
        Comparator<Camion> comparator
                = Comparator
                .comparing(Camion::getAnioFechaUltimaMantencion)
                .thenComparingInt(Camion::getAnioFechaUltimaMantencion)
                .thenComparingInt(Camion::getMesFechaUltimaMantencion)
                .thenComparingInt(Camion::getDiaFechaUltimaMantencion);
        camiones.sort(comparator);
    }

    public void camionAlDia(Camion camion, LinkedList<Camion> list){
        if(camiones.isEmpty()){
            throw new NullPointerException("No hay camiones en la lista");
        }
        if(camiones.contains(camion)){
            if(revision(camion.getKilometrajeAct()
                    ,camion.getDiaFechaUltimaMantencion()
                    ,camion.getMesFechaUltimaMantencion()
                    ,camion.getAnioFechaUltimaMantencion()).equals("Esta al día")){
                list.add(camion);
                ordenarCamionFecha(list);
            }
        }
    }

    public void mantencionCamionTipo(Camion camion, LinkedList<Camion> list){
        if(camiones.isEmpty()){
            throw new NullPointerException("No hay camiones en la lista");
        }
        if (camiones.contains(camion)){
            if(revision(camion.getKilometrajeAct()
                    ,camion.getDiaFechaUltimaMantencion()
                    ,camion.getMesFechaUltimaMantencion()
                    ,camion.getAnioFechaUltimaMantencion()).equals("Necesita mantención")){
                list.add(camion);
                ordenarCamionFecha(list);
            }
        }
    }

    public void camionMantencionKilometros(Camion camion, LinkedList<Camion> list){
        if(camiones.isEmpty()){
            throw new NullPointerException("No hay camiones en la lista");
        }
        if (camiones.contains(camion)){
            if(revision(camion.getKilometrajeAct()
                    ,camion.getDiaFechaUltimaMantencion()
                    ,camion.getMesFechaUltimaMantencion()
                    ,camion.getAnioFechaUltimaMantencion()).equals("Necesita mantención")
                    || camion.getKilometrajeAct() < 60000){
                list.add(camion);
                ordenarCamionFecha(list);
            }
        }
    }

    @Override
    public boolean revisionKilometros(double kilometraje) { return kilometraje > 15000; }

    @Override
    public boolean revisionMeses(int dia, int mes, int anio) {
        Calendar inicio = Calendar.getInstance();
        inicio.set(anio, mes-1, dia);
        Calendar actual = Calendar.getInstance();
        int anios_diferencia = calcularAnios(dia, mes, anio);
        int meses = (anios_diferencia * 12) + (actual.get(Calendar.MONTH) - inicio.get(Calendar.MONTH));
        if(actual.get(Calendar.DATE)<dia){
            meses--;
        }
        return meses > 6;
    }

    @Override
    public int calcularAnios(int dia, int mes, int anio) {
        Calendar inicio = Calendar.getInstance();
        inicio.set(anio,mes-1,dia);
        Calendar actual = Calendar.getInstance();
        int diferencia = actual.get(Calendar.YEAR) - inicio.get(Calendar.YEAR);
        if(inicio.get(Calendar.DAY_OF_YEAR) > actual.get(Calendar.DAY_OF_YEAR)){
            diferencia--;
        }
        return diferencia;
    }

    @Override
    public String revision(double kilometros, int dias, int meses, int anios){
        if(kilometros < 0 || dias < 0 || meses < 0 || anios < 0){
            throw new IndexOutOfBoundsException("No se aceptan valores negativos");
        }
        if(revisionKilometros(kilometros) || revisionMeses(dias,meses,anios)) {
            return "Necesita mantención";
        } else {
            return "Esta al día";
        }
    }

    @Override
    public void mostrarListaBuses(LinkedList<Bus> list) {
        for (Bus bus : list) {
            System.out.println(bus.toString());
        }
    }

    @Override
    public void mostrarListaCamiones(LinkedList<Camion> list) {
        for (Camion camion : list) {
            System.out.println(camion.toString());
        }
    }
}
