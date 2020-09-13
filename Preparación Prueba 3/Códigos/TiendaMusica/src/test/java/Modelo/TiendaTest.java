package Modelo;

import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class TiendaTest {

    Tienda tienda;
    Guitarra guitarra1;
    Guitarra guitarra2;
    Piano piano1;
    Piano piano2;
    Date fecha;
    String listaGuitarras;
    String listaPianos;

    @Before
    public void setUp(){
        tienda = new Tienda();
        fecha = new Date(2020, Calendar.FEBRUARY,2);
        guitarra1 = new Guitarra(1,"Jackson","Guitarra Electrica","Flying V",200000,fecha,6,"nogal","0.9");
        guitarra2 = new Guitarra(2,"Jackson","Guitarra Electrica","Standar",230000,fecha,6,"nogal","0.8");
        tienda.getGuitarras().add(guitarra1);
        tienda.getGuitarras().add(guitarra2);
        piano1 = new Piano(3,"Yamaha","Piano","de cola",3000000,fecha,"Roble","Pesadas",88);
        piano2 = new Piano(4,"M-Audio","Controlador Midi","Midi",200000,fecha,"Plástico","Livianas",61);
        tienda.getPianos().add(piano1);
        tienda.getPianos().add(piano2);

        listaGuitarras = "Guitarra{cantidadCuerdas= 6, tipoMadera= nogal, tipoCuerda= 0.9, id= 1, fabricante= Jackson, nombreInstrumento= Guitarra Electrica, modelo= Flying V, precio= 200000.0, fechaIngreso= Mon Feb 02 00:00:00 CLST 3920}\r\n" +
                         "Guitarra{cantidadCuerdas= 6, tipoMadera= nogal, tipoCuerda= 0.8, id= 2, fabricante= Jackson, nombreInstrumento= Guitarra Electrica, modelo= Standar, precio= 230000.0, fechaIngreso= Mon Feb 02 00:00:00 CLST 3920}\r\n";

        listaPianos = "Piano{tipoMadera= Plástico, tipoTecla= Livianas, cantidadTeclas= 61, id= 4, fabricante= M-Audio, nombreInstrumento= Controlador Midi, modelo= Midi, precio= 200000.0, fechaIngreso= Mon Feb 02 00:00:00 CLST 3920}\r\n" +
                      "Piano{tipoMadera= Roble, tipoTecla= Pesadas, cantidadTeclas= 88, id= 3, fabricante= Yamaha, nombreInstrumento= Piano, modelo= de cola, precio= 3000000.0, fechaIngreso= Mon Feb 02 00:00:00 CLST 3920}\r\n";
    }

    @org.junit.Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @org.junit.Test
    public void buscarGuitarra() {
        Guitarra guitarra = new Guitarra(5,"fender","Guitarra","Acústico",120000,fecha,6,"Roble","0.9");
        assertTrue(tienda.buscarGuitarra(guitarra1));
        assertTrue(tienda.buscarGuitarra(guitarra2));
        assertFalse(tienda.buscarGuitarra(guitarra));
    }

    @Test
    public void ordenarPrecioGuitarras() {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        tienda.ordenarPrecioGuitarras();
        tienda.mostrarListaGuitarras(tienda.getGuitarras());
        assertEquals(listaGuitarras, out.toString());
    }

    @Test
    public void buscarPiano() {
        Piano piano = new Piano(6,"Axis","Controlador midi","Midi",100000,fecha,"Plástico","Pesadas",25);
        assertTrue(tienda.buscarPiano(piano1));
        assertTrue(tienda.buscarPiano(piano2));
        assertFalse(tienda.buscarPiano(piano));
    }

    @Test
    public void ordenarPrecioPianos() {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        tienda.ordenarPrecioPianos();
        tienda.mostrarListaPianos(tienda.getPianos());
        assertEquals(listaPianos, out.toString());
    }
}