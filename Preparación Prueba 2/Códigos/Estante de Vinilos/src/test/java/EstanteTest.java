import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;

import static org.junit.Assert.*;

public class EstanteTest {

    private Estante estante;
    private Date fechaPublicacion;
    private String imprimirVinilos;

    @Before
    public void preparacion() throws Exception{
        estante = new Estante();
        fechaPublicacion = new Date(2019, Calendar.AUGUST,30);
        estante.agregarViniloStack("Tool",fechaPublicacion,"Fear Inoculum",38900);
        estante.agregarViniloList("Tool",fechaPublicacion,"Fear Inoculum",38900);
        estante.agregarViniloHashSet("Tool",fechaPublicacion,"Fear Inoculum",38900);
        estante.agregarViniloMap("Tool",fechaPublicacion,"Fear Inoculum",38900);
        fechaPublicacion = new Date(2016,Calendar.AUGUST,12);
        estante.agregarViniloStack("Kuervos del Sur",fechaPublicacion,"El vuelo del Pillán",26500);
        estante.agregarViniloList("Kuervos del Sur",fechaPublicacion,"El vuelo del Pillán",26500);
        estante.agregarViniloHashSet("Kuervos del Sur",fechaPublicacion,"El vuelo del Pillán",26500);
        estante.agregarViniloMap("Kuervos del Sur",fechaPublicacion,"El vuelo del Pillán",26500);
        imprimirVinilos = "Vinilos: \r\n" +
                "Vinilo{nombreArtista='Tool', fechaPublicacion=Sat Aug 30 00:00:00 CLT 3919, nombreVinilo='Fear Inoculum', valorVinilo=38900.0}\r\n" +
                "Vinilo{nombreArtista='Kuervos del Sur', fechaPublicacion=Sat Aug 12 00:00:00 CLT 3916, nombreVinilo='El vuelo del Pillán', valorVinilo=26500.0}\r\n" +
                "Vinilo{nombreArtista='Polyphia', fechaPublicacion=Sat Mar 11 00:00:00 CLST 3916, nombreVinilo='Renaissance', valorVinilo=19662.0}\r\n";
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void agregarViniloStack() {
        fechaPublicacion = new Date(2016,Calendar.MARCH,11);
        estante.agregarViniloStack("Polyphia",fechaPublicacion,"Renaissance",19662);
        PrintStream save_out = System.out;
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        estante.imprimirVinilosStack(estante.getVinilosStack());
        assertEquals(imprimirVinilos,out.toString());
    }

    @Test
    public void agregarViniloList() {
        fechaPublicacion = new Date(2016,Calendar.MARCH,11);
        estante.agregarViniloList("Polyphia",fechaPublicacion,"Renaissance",19662);
        PrintStream save_out = System.out;
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        estante.imprimirVinilosList(estante.getVinilosList());
        assertEquals(imprimirVinilos,out.toString());
    }

    @Test
    public void agregarViniloHashSet() {
        fechaPublicacion = new Date(2016,Calendar.MARCH,11);
        estante.agregarViniloHashSet("Polyphia",fechaPublicacion,"Renaissance",19662);
        PrintStream save_out = System.out;
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        estante.imprimirVinilosHashSet((HashSet<Vinilo>) estante.getVinilosHashSet());
        assertEquals(imprimirVinilos,out.toString());
    }

    @Test
    public void agregarViniloMap() {
        fechaPublicacion = new Date(2016,Calendar.MARCH,11);
        estante.agregarViniloMap("Polyphia",fechaPublicacion,"Renaissance",19662);
        PrintStream save_out = System.out;
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        estante.imprimirVinilosMap(estante.getVinilosMap());
        assertEquals(imprimirVinilos,out.toString());
    }

    @Test
    public void imprimirVinilosStack() {
    }

    @Test
    public void imprimirVinilosList() {
    }

    @Test
    public void imprimirVinilosHashSet() {
    }

    @Test
    public void imprimirVinilosMap() {
    }
}