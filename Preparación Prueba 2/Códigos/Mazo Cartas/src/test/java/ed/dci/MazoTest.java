package ed.dci;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MazoTest {

    Mazo mazoVacio;
    Mazo mazo;
    Carta carta;
    Carta carta1;

    @Before
    public void preparacion(){
        mazo = new Mazo();
        mazoVacio = new Mazo();
        carta = new Carta(TipoCarta.PICA,RangoCarta.ACE);
        carta1 = new Carta(TipoCarta.PICA, RangoCarta.JACK);
        mazo.agregarCarta(new Carta(TipoCarta.CORAZON,RangoCarta.ACE));
        mazo.agregarCarta(new Carta(TipoCarta.DIAMANTE,RangoCarta.ACE));
        mazo.agregarCarta(carta);
        mazo.agregarCarta(new Carta(TipoCarta.TREBOL,RangoCarta.ACE));
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void obtenerCarta() {
        Assert.assertTrue(mazo.obtenerCarta(carta));
        Assert.assertFalse(mazo.obtenerCarta(carta1));
    }

    @Test
    public void obtenerCartaVacio(){
        Carta carta = new Carta(TipoCarta.PICA,RangoCarta.ACE);
        exceptionRule.expect(NullPointerException.class);
        exceptionRule.expectMessage("No alcanzan las cartas");
        mazoVacio.obtenerCarta(carta);
    }

    @Test
    public void deleteCarta() {
        Carta carta = new Carta(TipoCarta.PICA,RangoCarta.ACE);
        mazo.deleteCarta(carta);
        Assert.assertFalse(mazo.getCartas().contains(carta));
    }

    @Test
    public void deleteCartaVacia(){
        Carta carta = new Carta(TipoCarta.PICA,RangoCarta.ACE);
        exceptionRule.expect(NullPointerException.class);
        exceptionRule.expectMessage("No puedes eliminar esa carta porque no hay suficientes cartas");
        mazoVacio.deleteCarta(carta);
    }
}