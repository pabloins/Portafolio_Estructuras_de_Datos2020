import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ArbolBinarioTest {

    ArbolBinario arbolBinario;
    ArbolBinario arbolBinario1;
    ArbolBinario arbolBinario2;
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
    }

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
}