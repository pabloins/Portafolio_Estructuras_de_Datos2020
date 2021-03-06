package Modelo;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class EmpresaTest {

    Empresa empresa;
    Empresa empresaVacio;
    Bus bus1;
    Bus bus2;
    Bus bus3;
    Bus bus4;
    Camion camion1;
    Camion camion2;
    Camion camion3;
    Camion camion4;
    Date fechaCompra;
    String listaBuses;
    String listaBusesFiltroKm;
    String listaCamiones;
    String listaCamionesAlDia;
    String listaCamionesTipo;
    LinkedList<Bus> buses;
    LinkedList<Camion> camiones;

    @Before
    public void preparar() {
        empresa = new Empresa();
        empresaVacio = new Empresa();
        buses = new LinkedList<>();
        camiones = new LinkedList<>();
        fechaCompra = new Date(117, Calendar.APRIL,21);
        bus1 = new Bus("FN-YH-29","NMK898735",2,"MERCEDES BENZ",fechaCompra,110000,4000,21,7,2020, TipoBus.TRANSPORTEDEPASAJEROS1);
        empresa.getBuses().add(bus1);
        fechaCompra = new Date(116, Calendar.DECEMBER,21);
        bus2 = new Bus("MH-ZP-18","PTG852853",4,"MERCEDES BENZ",fechaCompra,85000,18000,9,12,2015, TipoBus.TRANSPORTEDEENCOMIENDAS2);
        empresa.getBuses().add(bus2);
        fechaCompra = new Date(119, Calendar.MAY,23);
        bus3 = new Bus("GD-LZ-21","KHJ667261",2,"MERCEDES BENZ",fechaCompra,50000,67000,19,12,2013, TipoBus.TRANSPORTEDEENCOMIENDAS2);
        empresa.getBuses().add(bus3);
        fechaCompra = new Date(119, Calendar.FEBRUARY,28);
        bus4 = new Bus("LM-AS-32","MVB777254",4,"SCANIA",fechaCompra,10000,15000,19,12,2015, TipoBus.TRANSPORTEDEPASAJEROS2);
        empresa.getBuses().add(bus4);
        fechaCompra = new Date(115, Calendar.MARCH,4);
        camion1 = new Camion("HI-OO-99","AAJF44411",2,"VOLVO",fechaCompra,11000,34000,19,12,2013, TipoCamion.TRANSPORTEDEALIMENTOS);
        empresa.getCamiones().add(camion1);
        fechaCompra = new Date(118, Calendar.APRIL,6);
        camion2 = new Camion("LM-WW-18","KDJ887441",2,"VOLVO",fechaCompra,11000,23000,6,4,2018, TipoCamion.TRANSPORTEDEALIMENTOS);
        empresa.getCamiones().add(camion2);
        fechaCompra = new Date(119, Calendar.SEPTEMBER,9);
        camion3 = new Camion("WW-AZ-56","JJJ637344",2,"SCANIA",fechaCompra,11000,5000,19,7,2020, TipoCamion.TRANSPORTEDEALIMENTOS);
        empresa.getCamiones().add(camion3);
        fechaCompra = new Date(113, Calendar.MARCH,1);
        camion4 = new Camion("TYD-EF-32","KDD662311",2,"SCANIA",fechaCompra,11000,200000,19,12,2013, TipoCamion.TRANSPORTEDEALIMENTOS);
        empresa.getCamiones().add(camion4);
        listaBuses = "Bus{patente= GD-LZ-21, chasis= KHJ667261, eje=2, marca= MERCEDES BENZ, fechaCompra= Thu May 23 00:00:00 CLT 2019, kilometrajeAct= 50000.0, kilometrajeManutencion= 67000.0, diaFechaUltimaMantencion= 19, mesFechaUltimaMantencion= 12, anioFechaUltimaMantencion= 2013, tipoBus= TRANSPORTEDEENCOMIENDAS2}\r\n" +
                     "Bus{patente= MH-ZP-18, chasis= PTG852853, eje=4, marca= MERCEDES BENZ, fechaCompra= Wed Dec 21 00:00:00 CLST 2016, kilometrajeAct= 85000.0, kilometrajeManutencion= 18000.0, diaFechaUltimaMantencion= 9, mesFechaUltimaMantencion= 12, anioFechaUltimaMantencion= 2015, tipoBus= TRANSPORTEDEENCOMIENDAS2}\r\n" +
                     "Bus{patente= LM-AS-32, chasis= MVB777254, eje=4, marca= SCANIA, fechaCompra= Thu Feb 28 00:00:00 CLST 2019, kilometrajeAct= 10000.0, kilometrajeManutencion= 15000.0, diaFechaUltimaMantencion= 19, mesFechaUltimaMantencion= 12, anioFechaUltimaMantencion= 2015, tipoBus= TRANSPORTEDEPASAJEROS2}\r\n" +
                     "Bus{patente= FN-YH-29, chasis= NMK898735, eje=2, marca= MERCEDES BENZ, fechaCompra= Fri Apr 21 00:00:00 CLST 2017, kilometrajeAct= 110000.0, kilometrajeManutencion= 4000.0, diaFechaUltimaMantencion= 21, mesFechaUltimaMantencion= 7, anioFechaUltimaMantencion= 2020, tipoBus= TRANSPORTEDEPASAJEROS1}\r\n";

        listaBusesFiltroKm = "Bus{patente= GD-LZ-21, chasis= KHJ667261, eje=2, marca= MERCEDES BENZ, fechaCompra= Thu May 23 00:00:00 CLT 2019, kilometrajeAct= 50000.0, kilometrajeManutencion= 67000.0, diaFechaUltimaMantencion= 19, mesFechaUltimaMantencion= 12, anioFechaUltimaMantencion= 2013, tipoBus= TRANSPORTEDEENCOMIENDAS2}\r\n" +
                             "Bus{patente= LM-AS-32, chasis= MVB777254, eje=4, marca= SCANIA, fechaCompra= Thu Feb 28 00:00:00 CLST 2019, kilometrajeAct= 10000.0, kilometrajeManutencion= 15000.0, diaFechaUltimaMantencion= 19, mesFechaUltimaMantencion= 12, anioFechaUltimaMantencion= 2015, tipoBus= TRANSPORTEDEPASAJEROS2}\r\n";

        listaCamiones = "Camion{patente= HI-OO-99, chasis= AAJF44411, eje= 2, marca= VOLVO, fechaCompra= Wed Mar 04 00:00:00 CLST 2015, kilometrajeAct= 11000.0, kilometrajeManutencion= 34000.0, diaFechaUltimaMantencion= 19, mesFechaUltimaMantencion= 12, anioFechaUltimaMantencion =2013, tipoCamion= TRANSPORTEDEALIMENTOS}\r\n" +
                        "Camion{patente= TYD-EF-32, chasis= KDD662311, eje= 2, marca= SCANIA, fechaCompra= Fri Mar 01 00:00:00 CLST 2013, kilometrajeAct= 11000.0, kilometrajeManutencion= 200000.0, diaFechaUltimaMantencion= 19, mesFechaUltimaMantencion= 12, anioFechaUltimaMantencion =2013, tipoCamion= TRANSPORTEDEALIMENTOS}\r\n" +
                        "Camion{patente= LM-WW-18, chasis= KDJ887441, eje= 2, marca= VOLVO, fechaCompra= Fri Apr 06 00:00:00 CLST 2018, kilometrajeAct= 11000.0, kilometrajeManutencion= 23000.0, diaFechaUltimaMantencion= 6, mesFechaUltimaMantencion= 4, anioFechaUltimaMantencion =2018, tipoCamion= TRANSPORTEDEALIMENTOS}\r\n" +
                        "Camion{patente= WW-AZ-56, chasis= JJJ637344, eje= 2, marca= SCANIA, fechaCompra= Mon Sep 09 00:00:00 CLST 2019, kilometrajeAct= 11000.0, kilometrajeManutencion= 5000.0, diaFechaUltimaMantencion= 19, mesFechaUltimaMantencion= 7, anioFechaUltimaMantencion =2020, tipoCamion= TRANSPORTEDEALIMENTOS}\r\n";

        listaCamionesAlDia = "Camion{patente= WW-AZ-56, chasis= JJJ637344, eje= 2, marca= SCANIA, fechaCompra= Mon Sep 09 00:00:00 CLST 2019, kilometrajeAct= 11000.0, kilometrajeManutencion= 5000.0, diaFechaUltimaMantencion= 19, mesFechaUltimaMantencion= 7, anioFechaUltimaMantencion =2020, tipoCamion= TRANSPORTEDEALIMENTOS}\r\n";

        listaCamionesTipo = "Camion{patente= HI-OO-99, chasis= AAJF44411, eje= 2, marca= VOLVO, fechaCompra= Wed Mar 04 00:00:00 CLST 2015, kilometrajeAct= 11000.0, kilometrajeManutencion= 34000.0, diaFechaUltimaMantencion= 19, mesFechaUltimaMantencion= 12, anioFechaUltimaMantencion =2013, tipoCamion= TRANSPORTEDEALIMENTOS}\r\n" +
                            "Camion{patente= TYD-EF-32, chasis= KDD662311, eje= 2, marca= SCANIA, fechaCompra= Fri Mar 01 00:00:00 CLST 2013, kilometrajeAct= 11000.0, kilometrajeManutencion= 200000.0, diaFechaUltimaMantencion= 19, mesFechaUltimaMantencion= 12, anioFechaUltimaMantencion =2013, tipoCamion= TRANSPORTEDEALIMENTOS}\r\n" +
                            "Camion{patente= LM-WW-18, chasis= KDJ887441, eje= 2, marca= VOLVO, fechaCompra= Fri Apr 06 00:00:00 CLST 2018, kilometrajeAct= 11000.0, kilometrajeManutencion= 23000.0, diaFechaUltimaMantencion= 6, mesFechaUltimaMantencion= 4, anioFechaUltimaMantencion =2018, tipoCamion= TRANSPORTEDEALIMENTOS}\r\n";
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void ordenarBusFecha() {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        empresa.ordenarBusFecha(empresa.getBuses());
        empresa.mostrarListaBuses(empresa.getBuses());
        assertEquals(listaBuses, out.toString());
    }

    @Test
    public void ordenarBusFechaVacio(){
        exceptionRule.expect(NullPointerException.class);
        exceptionRule.expectMessage("No hay buses en la lista");
        empresaVacio.ordenarBusFecha(empresaVacio.getBuses());
    }

    @Test
    public void busAlDiaTest(){
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        empresa.busAlDia(bus1, buses);
        empresa.busAlDia(bus2, buses);
        empresa.busAlDia(bus3, buses);
        empresa.busAlDia(bus4, buses);
        empresa.mostrarListaBuses(buses);
        assertEquals("", out.toString());
    }

    @Test
    public void busAlDiaVacioTest(){
        exceptionRule.expect(NullPointerException.class);
        exceptionRule.expectMessage("No hay buses en la lista");
        empresaVacio.busAlDia(bus1, buses);
        empresaVacio.busAlDia(bus2, buses);
        empresaVacio.busAlDia(bus3, buses);
        empresaVacio.busAlDia(bus4, buses);
    }

    @Test
    public void mantencionBusTipoTest(){
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        empresa.mantencionBusTipo(bus1, buses);
        empresa.mantencionBusTipo(bus2, buses);
        empresa.mantencionBusTipo(bus3, buses);
        empresa.mantencionBusTipo(bus4, buses);
        empresa.mostrarListaBuses(buses);
        assertEquals(listaBuses, out.toString());
    }

    @Test
    public void mantencionBusTipoVacioTest(){
        exceptionRule.expect(NullPointerException.class);
        exceptionRule.expectMessage("No hay buses en la lista");
        empresaVacio.mantencionBusTipo(bus1, buses);
        empresaVacio.mantencionBusTipo(bus2, buses);
        empresaVacio.mantencionBusTipo(bus3, buses);
        empresaVacio.mantencionBusTipo(bus4, buses);
    }

    @Test
    public void busMantencionKilometrosTest(){
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        empresa.busMantencionKilometros(bus1, buses);
        empresa.busMantencionKilometros(bus2, buses);
        empresa.busMantencionKilometros(bus3, buses);
        empresa.busMantencionKilometros(bus4, buses);
        empresa.mostrarListaBuses(buses);
        assertEquals(listaBusesFiltroKm, out.toString());
    }

    @Test
    public void busMantencionKilometrosVacioTest(){
        exceptionRule.expect(NullPointerException.class);
        exceptionRule.expectMessage("No hay buses en la lista");
        empresaVacio.busMantencionKilometros(bus1, buses);
        empresaVacio.busMantencionKilometros(bus2, buses);
        empresaVacio.busMantencionKilometros(bus3, buses);
        empresaVacio.busMantencionKilometros(bus4, buses);
    }

    @Test
    public void ordenarCamionFecha() {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        empresa.ordenarCamionFecha(empresa.getCamiones());
        empresa.mostrarListaCamiones(empresa.getCamiones());
        assertEquals(listaCamiones, out.toString());
    }

    @Test
    public void ordenarCamionFechaVacio(){
        exceptionRule.expect(NullPointerException.class);
        exceptionRule.expectMessage("No hay camiones en la lista");
        empresaVacio.ordenarCamionFecha(empresaVacio.getCamiones());
    }

    @Test
    public void camionAlDiaTest(){
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        empresa.camionAlDia(camion1, camiones);
        empresa.camionAlDia(camion2, camiones);
        empresa.camionAlDia(camion3, camiones);
        empresa.camionAlDia(camion4, camiones);
        empresa.mostrarListaCamiones(camiones);
        assertEquals(listaCamionesAlDia, out.toString());
    }

    @Test
    public void camionAlDiaVacioTest(){
        exceptionRule.expect(NullPointerException.class);
        exceptionRule.expectMessage("No hay camiones en la lista");
        empresaVacio.camionMantencionKilometros(camion1, camiones);
        empresaVacio.camionMantencionKilometros(camion2, camiones);
        empresaVacio.camionMantencionKilometros(camion3, camiones);
        empresaVacio.camionMantencionKilometros(camion4, camiones);
    }

    @Test
    public void mantencionCamionTipoTest(){
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        empresa.mantencionCamionTipo(camion1, camiones);
        empresa.mantencionCamionTipo(camion2, camiones);
        empresa.mantencionCamionTipo(camion3, camiones);
        empresa.mantencionCamionTipo(camion4, camiones);
        empresa.mostrarListaCamiones(camiones);
        assertEquals(listaCamionesTipo, out.toString());
    }

    @Test
    public void mantencionCamionTipoVacioTest(){
        exceptionRule.expect(NullPointerException.class);
        exceptionRule.expectMessage("No hay camiones en la lista");
        empresaVacio.mantencionCamionTipo(camion1, camiones);
        empresaVacio.mantencionCamionTipo(camion2, camiones);
        empresaVacio.mantencionCamionTipo(camion3, camiones);
        empresaVacio.mantencionCamionTipo(camion4, camiones);
    }

    @Test
    public void camionMantencionKilometrosTest(){
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        empresa.camionMantencionKilometros(camion1, camiones);
        empresa.camionMantencionKilometros(camion2, camiones);
        empresa.camionMantencionKilometros(camion3, camiones);
        empresa.camionMantencionKilometros(camion4, camiones);
        empresa.mostrarListaCamiones(camiones);
        assertEquals(listaCamiones, out.toString());
    }

    @Test
    public void camionMantencionKilometrosVacioTest(){
        exceptionRule.expect(NullPointerException.class);
        exceptionRule.expectMessage("No hay camiones en la lista");
        empresaVacio.camionMantencionKilometros(camion1, camiones);
        empresaVacio.camionMantencionKilometros(camion2, camiones);
        empresaVacio.camionMantencionKilometros(camion3, camiones);
        empresaVacio.camionMantencionKilometros(camion4, camiones);
    }
}