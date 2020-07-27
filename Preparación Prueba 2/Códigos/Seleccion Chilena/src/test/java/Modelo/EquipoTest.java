package Modelo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class EquipoTest {

    Equipo seleccion;
    Equipo seleccionVacio;
    String plantel;
    String plantel1;
    String cuerpoTecnico;
    String cuerpoTecnico1;
    Jugador jorgeValdivia;
    Jugador marceloSalas;

    @Before
    public void preparacion() throws Exception {
        seleccion = new Equipo();
        seleccionVacio = new Equipo();
        jorgeValdivia = new Jugador("Jorge","Valdivia",10,Posicion.VOLANTEOFENSIVO);
        marceloSalas = new Jugador("Marcelo","Salas",11,Posicion.DEFENSACENTRAL) ;
        seleccion.agregarJugador(new Jugador("Claudio","Bravo",1,Posicion.ARQUERO));
        seleccion.agregarJugador(new Jugador("Mauricio","Isla",4,Posicion.LATERAL));
        seleccion.agregarJugador(new Jugador("Gary","Medel",17,Posicion.DEFENSACENTRAL));
        seleccion.agregarJugador(new Jugador("Guillermo","Maripán",3,Posicion.DEFENSACENTRAL));
        seleccion.agregarJugador(new Jugador("Jean","Beausejour",15,Posicion.LATERAL));
        seleccion.agregarJugador(new Jugador("Marcelo","Díaz",21,Posicion.VOLANTEDEFENSIVO));
        seleccion.agregarJugador(new Jugador("Charles","Aranguiz",20,Posicion.VOLANTEMIXTO));
        seleccion.agregarJugador(new Jugador("Arturo","Vidal",8,Posicion.VOLANTEMIXTO));
        seleccion.agregarJugador(jorgeValdivia);
        seleccion.agregarJugador(new Jugador("Alexis", "Sánchez",7,Posicion.DELANTEROEXTREMO));
        seleccion.agregarJugador(new Jugador("Eduardo","Vargas",11,Posicion.DELANTERODEAREA));
        seleccion.agregarCuerpoTecnico(new DireccionTecnica("Reinaldo","Rueda",Ocupacion.ENTRENADOR));
        seleccion.agregarCuerpoTecnico(new DireccionTecnica("Carlos","Velasco",Ocupacion.PREPARADORFISICO));
        seleccion.agregarCuerpoTecnico(new DireccionTecnica("Fernando","Yáñez",Ocupacion.MEDICO));
        seleccion.agregarCuerpoTecnico(new DireccionTecnica("Pedro","Oñate",Ocupacion.KINESIOLOGO));
        seleccion.agregarCuerpoTecnico(new DireccionTecnica("Nestor","Lo Tártaro",Ocupacion.PERPARADORDEARQUERO));
        seleccion.agregarCuerpoTecnico(new DireccionTecnica("Wilson","Vásquez",Ocupacion.UTILERO));
        plantel = "Selección Chilena: \r\n" +
                "Jugador{nombre= Arturo, apellido= Vidal, numeroCamiseta= 8, posicion= VOLANTEMIXTO}\r\n" +
                "Jugador{nombre= Jorge, apellido= Valdivia, numeroCamiseta= 10, posicion= VOLANTEOFENSIVO}\r\n" +
                "Jugador{nombre= Gary, apellido= Medel, numeroCamiseta= 17, posicion= DEFENSACENTRAL}\r\n" +
                "Jugador{nombre= Jean, apellido= Beausejour, numeroCamiseta= 15, posicion= LATERAL}\r\n" +
                "Jugador{nombre= Marcelo, apellido= Díaz, numeroCamiseta= 21, posicion= VOLANTEDEFENSIVO}\r\n" +
                "Jugador{nombre= Mauricio, apellido= Isla, numeroCamiseta= 4, posicion= LATERAL}\r\n" +
                "Jugador{nombre= Alexis, apellido= Sánchez, numeroCamiseta= 7, posicion= DELANTEROEXTREMO}\r\n" +
                "Jugador{nombre= Claudio, apellido= Bravo, numeroCamiseta= 1, posicion= ARQUERO}\r\n" +
                "Jugador{nombre= Guillermo, apellido= Maripán, numeroCamiseta= 3, posicion= DEFENSACENTRAL}\r\n" +
                "Jugador{nombre= Charles, apellido= Aranguiz, numeroCamiseta= 20, posicion= VOLANTEMIXTO}\r\n" +
                "Jugador{nombre= Eduardo, apellido= Vargas, numeroCamiseta= 11, posicion= DELANTERODEAREA}\r\n";
        plantel1 = "Selección Chilena: \r\n" +
                "Jugador{nombre= Arturo, apellido= Vidal, numeroCamiseta= 8, posicion= VOLANTEMIXTO}\r\n" +
                "Jugador{nombre= Jorge, apellido= Valdivia, numeroCamiseta= 10, posicion= VOLANTEOFENSIVO}\r\n" +
                "Jugador{nombre= Erick, apellido= Pulgar, numeroCamiseta= 13, posicion= VOLANTEDEFENSIVO}\r\n" +
                "Jugador{nombre= Gary, apellido= Medel, numeroCamiseta= 17, posicion= DEFENSACENTRAL}\r\n" +
                "Jugador{nombre= Jean, apellido= Beausejour, numeroCamiseta= 15, posicion= LATERAL}\r\n" +
                "Jugador{nombre= Marcelo, apellido= Díaz, numeroCamiseta= 21, posicion= VOLANTEDEFENSIVO}\r\n" +
                "Jugador{nombre= Mauricio, apellido= Isla, numeroCamiseta= 4, posicion= LATERAL}\r\n" +
                "Jugador{nombre= Alexis, apellido= Sánchez, numeroCamiseta= 7, posicion= DELANTEROEXTREMO}\r\n" +
                "Jugador{nombre= Claudio, apellido= Bravo, numeroCamiseta= 1, posicion= ARQUERO}\r\n" +
                "Jugador{nombre= Guillermo, apellido= Maripán, numeroCamiseta= 3, posicion= DEFENSACENTRAL}\r\n" +
                "Jugador{nombre= Charles, apellido= Aranguiz, numeroCamiseta= 20, posicion= VOLANTEMIXTO}\r\n" +
                "Jugador{nombre= Eduardo, apellido= Vargas, numeroCamiseta= 11, posicion= DELANTERODEAREA}\r\n";
        cuerpoTecnico = "Cuerpo Técnico \r\n" +
                "DireccionTecnica{nombre= Fernando, apellido= Yáñez, ocupacion= MEDICO}\r\n" +
                "DireccionTecnica{nombre= Pedro, apellido= Oñate, ocupacion= KINESIOLOGO}\r\n" +
                "DireccionTecnica{nombre= Reinaldo, apellido= Rueda, ocupacion= ENTRENADOR}\r\n" +
                "DireccionTecnica{nombre= Nestor, apellido= Lo Tártaro, ocupacion= PERPARADORDEARQUERO}\r\n" +
                "DireccionTecnica{nombre= Carlos, apellido= Velasco, ocupacion= PREPARADORFISICO}\r\n" +
                "DireccionTecnica{nombre= Wilson, apellido= Vásquez, ocupacion= UTILERO}\r\n";
        cuerpoTecnico1 = "Cuerpo Técnico \r\n" +
                "DireccionTecnica{nombre= Mario, apellido= Salas, ocupacion= ENTRENADOR}\r\n" +
                "DireccionTecnica{nombre= Fernando, apellido= Yáñez, ocupacion= MEDICO}\r\n" +
                "DireccionTecnica{nombre= Pedro, apellido= Oñate, ocupacion= KINESIOLOGO}\r\n" +
                "DireccionTecnica{nombre= Reinaldo, apellido= Rueda, ocupacion= ENTRENADOR}\r\n" +
                "DireccionTecnica{nombre= Nestor, apellido= Lo Tártaro, ocupacion= PERPARADORDEARQUERO}\r\n" +
                "DireccionTecnica{nombre= Carlos, apellido= Velasco, ocupacion= PREPARADORFISICO}\r\n" +
                "DireccionTecnica{nombre= Wilson, apellido= Vásquez, ocupacion= UTILERO}\r\n";
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void agregarJugador() {
        seleccion.agregarJugador(new Jugador("Erick","Pulgar",13,Posicion.VOLANTEDEFENSIVO));
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        seleccion.imprimirPlantel(seleccion.getJugadores());
        assertEquals(plantel1,out.toString());
    }

    @Test
    public void agregarCuerpoTecnico() {
        seleccion.eliminarCuerpoTecnico(new DireccionTecnica("Reinaldo","Rueda",Ocupacion.ENTRENADOR));
        seleccion.agregarCuerpoTecnico(new DireccionTecnica("Mario","Salas",Ocupacion.ENTRENADOR));
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        seleccion.imprimirCuerpoTecnico(seleccion.getCuerpoTecnico());
        assertEquals(cuerpoTecnico1,out.toString());
    }

    @Test
    public void buscarJugador() {
        Assert.assertTrue(seleccion.buscarJugador(jorgeValdivia));
        Assert.assertFalse(seleccion.buscarJugador(marceloSalas));
    }

    @Test
    public void eliminarJugador(){
        seleccion.eliminarJugador(jorgeValdivia);
        Assert.assertFalse(seleccion.buscarJugador(jorgeValdivia));
    }

    @Test
    public void buscarJugadorVacio(){
        exceptionRule.expect(NullPointerException.class);
        exceptionRule.expectMessage("No hay jugadores");
        seleccionVacio.buscarJugador(new Jugador("Claudio","Bravo",1,Posicion.ARQUERO));
    }

    @Test
    public void imprimirPlantel() {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        seleccion.imprimirPlantel(seleccion.getJugadores());
        assertEquals(plantel,out.toString());
    }

    @Test
    public void imprimirPlantelVacio(){
        exceptionRule.expect(NullPointerException.class);
        exceptionRule.expectMessage("No hay jugadores");
        seleccionVacio.imprimirPlantel(seleccionVacio.getJugadores());
    }

    @Test
    public void imprimirCuerpoTecnico() {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        seleccion.imprimirCuerpoTecnico(seleccion.getCuerpoTecnico());
        assertEquals(cuerpoTecnico,out.toString());
    }

    @Test
    public void imprimirCuerpoTecnicoVacio(){
        exceptionRule.expect(NullPointerException.class);
        exceptionRule.expectMessage("No hay cuerpo tecnico");
        seleccionVacio.imprimirCuerpoTecnico(seleccionVacio.getCuerpoTecnico());
    }
}