import org.junit.rules.ExpectedException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ArbolBinarioTest {

    ArbolBinario arbolBinario;
    ArbolBinario arbolBinario1;
    ArbolBinario arbolBinario2;
    ArbolBinario arbolBinario3;
    ArbolBinario arbolBinario4;
    ArbolBinario arbolBinarioVacio;
    String arbolEnPreOrden;

    @org.junit.Before
    public void preparar() {
        arbolBinario = new ArbolBinario();
        arbolBinario.insertar(50);
        arbolBinario.insertar(30);
        arbolBinario.insertar(20);
        arbolBinario.insertar(40);
        arbolBinario.insertar(70);
        arbolBinario.insertar(60);
        arbolBinario.insertar(80);

        arbolEnPreOrden = "50 30 20 40 70 60 80 ";

        arbolBinario1 = new ArbolBinario();
        arbolBinario1.insertar(100);
        arbolBinario1.insertar(120);

        arbolBinario2 = new ArbolBinario();
        arbolBinario2.insertar(100);
        arbolBinario2.insertar(110);
        arbolBinario2.insertar(90);

        arbolBinario3 = new ArbolBinario();
        arbolBinario3.insertar(100);

        arbolBinario4 = new ArbolBinario();
        arbolBinario4.insertar(4);
        arbolBinario4.insertar(9);
        arbolBinario4.insertar(11);
        arbolBinario4.insertar(3);
        arbolBinario4.insertar(5);
        arbolBinario4.insertar(7);

        arbolBinarioVacio = new ArbolBinario();
    }

    @org.junit.Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @org.junit.Test
    public void buscar() {
        assertTrue(arbolBinario.buscar(arbolBinario.root, 50));
        assertTrue(arbolBinario.buscar(arbolBinario.root, 30));
        assertTrue(arbolBinario.buscar(arbolBinario.root, 20));
        assertTrue(arbolBinario.buscar(arbolBinario.root, 40));
        assertTrue(arbolBinario.buscar(arbolBinario.root, 70));
        assertTrue(arbolBinario.buscar(arbolBinario.root, 60));
        assertTrue(arbolBinario.buscar(arbolBinario.root, 80));
    }

    @org.junit.Test
    public void imprimirEnPreOrden() {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        arbolBinario.imprimirEnPreOrden(arbolBinario.root);
        assertEquals(arbolEnPreOrden, out.toString());
    }

    @org.junit.Test
    public void comprobarArbolLleno(){
        assertTrue(arbolBinario.comprobarArbolLleno(arbolBinario.root));
        assertFalse(arbolBinario1.comprobarArbolLleno(arbolBinario1.root));
        assertTrue(arbolBinario2.comprobarArbolLleno(arbolBinario2.root));
    }

    @org.junit.Test
    public void obtenerNivel(){
        assertEquals(3, arbolBinario.obtenerNivel(arbolBinario.root));
        assertEquals(2, arbolBinario1.obtenerNivel(arbolBinario1.root));
        assertEquals(2, arbolBinario2.obtenerNivel(arbolBinario2.root));
        assertEquals(1, arbolBinario3.obtenerNivel(arbolBinario3.root));
    }

    @org.junit.Test
    public void obtenerValorMaxNivel(){
        exceptionRule.expect(NullPointerException.class);
        exceptionRule.expectMessage("El árbol no existe");
        arbolBinarioVacio.obtenerValorMaxNivel(arbolBinarioVacio.root);

    }
}