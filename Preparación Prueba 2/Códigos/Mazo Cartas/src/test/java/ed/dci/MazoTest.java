package ed.dci;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

public class MazoTest {

    private Mazo mazoVacio;
    private Mazo mazo;

    @Before
    public void preparacion(){
        List<Carta> cartas = new ArrayList<>();
        cartas.add(new Carta(TipoCarta.CORAZON,RangoCarta.ACE));
        cartas.add(new Carta(TipoCarta.DIAMANTE,RangoCarta.ACE));
        cartas.add(new Carta(TipoCarta.PICA,RangoCarta.ACE));
        cartas.add(new Carta(TipoCarta.TREBOL,RangoCarta.ACE));
        mazoVacio = new Mazo();
        mazo = new Mazo(cartas);
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