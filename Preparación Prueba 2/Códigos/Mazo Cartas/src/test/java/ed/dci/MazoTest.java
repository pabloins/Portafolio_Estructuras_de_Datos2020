package ed.dci;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MazoTest {

    private Mazo mazoVacio;
    private Mazo mazo;

    @Before
    public void preparacion(){
        mazo = new Mazo();
        mazoVacio = new Mazo();
        mazo.agregarCarta(new Carta(TipoCarta.CORAZON,RangoCarta.ACE));
        mazo.agregarCarta(new Carta(TipoCarta.DIAMANTE,RangoCarta.ACE));
        mazo.agregarCarta(new Carta(TipoCarta.PICA,RangoCarta.ACE));
        mazo.agregarCarta(new Carta(TipoCarta.TREBOL,RangoCarta.ACE));
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void getCarta() {
        Carta carta = new Carta(TipoCarta.PICA,RangoCarta.ACE);
        Assert.assertEquals(carta.toString(), mazo.getCarta(2).toString());
    }

    @Test
    public void getCartaVacia(){
        exceptionRule.expect(IndexOutOfBoundsException.class);
        exceptionRule.expectMessage("No alcanzan las cartas");
        mazoVacio.getCarta(2);
    }

    @Test
    public void deleteCarta() {
        Carta carta = new Carta(TipoCarta.PICA,RangoCarta.ACE);
        Assert.assertEquals(carta.toString(),mazo.getCarta(2).toString());
    }

    @Test
    public void deleteCartaVacia(){
        exceptionRule.expect(IndexOutOfBoundsException.class);
        exceptionRule.expectMessage("No puedes eliminar esa carta porque no hay suficientes cartas");
        mazoVacio.deleteCarta(2);
    }
}