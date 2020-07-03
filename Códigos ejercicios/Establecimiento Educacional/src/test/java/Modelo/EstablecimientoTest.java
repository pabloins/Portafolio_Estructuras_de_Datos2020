package Modelo;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;
import java.util.*;

public class EstablecimientoTest {

    Establecimiento colegio;
    Date fechaIncorporacion;

    @Before
    public void setUp() throws Exception {
        colegio = new Establecimiento();
        fechaIncorporacion = new Date(2020,Calendar.JANUARY,27);
        colegio.agregarEstudiante("Rodrigo", "Francisco Bilbao 600", "230000000",fechaIncorporacion, 5.8);
        colegio.agregarEstudiante("Pepe", "camino a relun 9km", "190000000",fechaIncorporacion, 6.1);
        colegio.agregarEstudiante("Isabel", "Calle Brasil 12", "18000000",fechaIncorporacion, 5.8);
        colegio.agregarEstudiante("Catalina", "Calle Uruguay 902", "20300000",fechaIncorporacion, 6.8);
        colegio.agregarEstudiante("Sergio", "Calle Paraguay 4", "18000300",fechaIncorporacion, 4.8);
        colegio.agregarEstudiante("Raul", "Calle Bolivia 92", "19030000",fechaIncorporacion, 5.2);
        colegio.agregarEstudiante("Fernanda", "Calle Corea del Norte 1", "21111111",fechaIncorporacion, 4.5);
        colegio.agregarEstudiante("Javier", "Calle Peru 8", "19890899",fechaIncorporacion, 5.3);
        colegio.agregarProfesor("Pedro",Especialidad.BIOLOGIA,10);
        colegio.agregarProfesor("Carla",Especialidad.MATEMATICA,5);
        colegio.agregarProfesor("Luis",Especialidad.HISTORIA,8);
        colegio.agregarPersonalAdministrativo("Marko", "Rector");
        colegio.agregarPersonalAdministrativo("Seba", "Vicerector");
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void agregarEstudiante() {
        colegio.agregarEstudiante("Leticia", "camino a relun 9km", "190000000",fechaIncorporacion, 6.2);
        assertEquals(colegio.getEstudiantes(),colegio.getEstudiantes());
    }

    @Test
    public void agregarEstudianteListaEspera() {
    }

    @Test
    public void imprimirEstudiantes() {
    }

    @Test
    public void agregarProfesor() {
    }

    @Test
    public void agregarProfesorListaEspera() {
    }

    @Test
    public void imprimirProfesores() {
    }

    @Test
    public void agregarPersonalAdministrativo() {
    }

    @Test
    public void imprimirPersonal() {
    }
}