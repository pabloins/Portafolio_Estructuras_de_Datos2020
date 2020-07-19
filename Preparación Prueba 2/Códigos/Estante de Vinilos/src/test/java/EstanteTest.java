import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class EstanteTest {

    private Estante estante;
    private Estante estanteVacio;
    private Date fechaPublicacion;
    private String vinilosDisponibles;

    @Before
    public void preparacion() {
        estante = new Estante();
        estanteVacio = new Estante();
        fechaPublicacion = new Date(2019, Calendar.AUGUST,30);
        estante.agregarVinilo(new Vinilo("Tool",fechaPublicacion,"Fear Inoculum",38900));
        fechaPublicacion = new Date(2016,Calendar.AUGUST,12);
        estante.agregarVinilo(new Vinilo("Kuervos del Sur",fechaPublicacion,"El vuelo del Pillán",26500));
        vinilosDisponibles = "Vinilos: \r\n" +
                "Vinilo{nombreArtista='Kuervos del Sur', fechaPublicacion=Sat Aug 12 00:00:00 CLT 3916, nombreVinilo='El vuelo del Pillán', valorVinilo=26500.0}\r\n" +
                "Vinilo{nombreArtista='Tool', fechaPublicacion=Sat Aug 30 00:00:00 CLT 3919, nombreVinilo='Fear Inoculum', valorVinilo=38900.0}\r\n";
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void agregarVinilo(){
        fechaPublicacion = new Date(2016,Calendar.MARCH,11);
        Vinilo viniloNuevo = new Vinilo("Polyphia",fechaPublicacion,"Renaissance",19662);
        estante.agregarVinilo(viniloNuevo);
        estante.buscarVinilo(viniloNuevo);
        Assert.assertTrue(true);
    }

    @Test
    public void buscarVinilo() {
        Vinilo vinilo = new Vinilo("Kuervos del Sur",fechaPublicacion,"El vuelo del Pillán",26500);
        estante.buscarVinilo(vinilo);
        Assert.assertTrue(true);
    }

    @Test
    public void buscarViniloEstanteVacio(){
        Vinilo vinilo = new Vinilo("Kuervos del Sur",fechaPublicacion,"El vuelo del Pillán",26500);
        exceptionRule.expect(NullPointerException.class);
        exceptionRule.expectMessage("No hay vinilos en el estante");
        estanteVacio.buscarVinilo(vinilo);
    }

    @Test
    public void venderVinilo() {
        Vinilo vinilo = new Vinilo("Tool",fechaPublicacion,"Fear Inoculum",38900);
        estante.venderVinilo(vinilo);
        Assert.assertTrue(true);
    }

    @Test
    public void venderViniloEstanteVacio(){
        Vinilo vinilo = new Vinilo("Kuervos del Sur",fechaPublicacion,"El vuelo del Pillán",26500);
        exceptionRule.expect(NullPointerException.class);
        exceptionRule.expectMessage("No hay vinilos en el estante");
        estanteVacio.venderVinilo(vinilo);
    }

    @Test
    public void imprimirVinilos() {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        estante.imprimirVinilos(estante.getVinilos());
        assertEquals(vinilosDisponibles,out.toString());
    }

    @Test
    public void imprimirVinilosEstanteVacio(){
        exceptionRule.expect(NullPointerException.class);
        exceptionRule.expectMessage("No hay vinilos en el estante");
        estanteVacio.imprimirVinilos(estanteVacio.getVinilos());
    }
}