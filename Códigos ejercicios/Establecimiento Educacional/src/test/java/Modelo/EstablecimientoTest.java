package Modelo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

public class EstablecimientoTest {

    Establecimiento colegio;
    Date fechaIncorporacion;
    String mensajeEstudiante;
    String mensajeProfesor;
    String mensajePersonal;

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
        mensajeEstudiante = "Estudiantes: \r\n" +
                "Estudiante{nombre= Fernanda, direccion= 'Calle Corea del Norte 1', rut= '21111111', fechaIncorporacion= 'Tue Jan 27 00:00:00 CLST 3920', promedio= 4.5}\r\n" +
                "Estudiante{nombre= Sergio, direccion= 'Calle Paraguay 4', rut= '18000300', fechaIncorporacion= 'Tue Jan 27 00:00:00 CLST 3920', promedio= 4.8}\r\n" +
                "Estudiante{nombre= Raul, direccion= 'Calle Bolivia 92', rut= '19030000', fechaIncorporacion= 'Tue Jan 27 00:00:00 CLST 3920', promedio= 5.2}\r\n" +
                "Estudiante{nombre= Javier, direccion= 'Calle Peru 8', rut= '19890899', fechaIncorporacion= 'Tue Jan 27 00:00:00 CLST 3920', promedio= 5.3}\r\n" +
                "Estudiante{nombre= Rodrigo, direccion= 'Francisco Bilbao 600', rut= '230000000', fechaIncorporacion= 'Tue Jan 27 00:00:00 CLST 3920', promedio= 5.8}\r\n" +
                "Estudiante{nombre= Isabel, direccion= 'Calle Brasil 12', rut= '18000000', fechaIncorporacion= 'Tue Jan 27 00:00:00 CLST 3920', promedio= 5.8}\r\n" +
                "Estudiante{nombre= Pepe, direccion= 'camino a relun 9km', rut= '190000000', fechaIncorporacion= 'Tue Jan 27 00:00:00 CLST 3920', promedio= 6.1}\r\n" +
                "Estudiante{nombre= Catalina, direccion= 'Calle Uruguay 902', rut= '20300000', fechaIncorporacion= 'Tue Jan 27 00:00:00 CLST 3920', promedio= 6.8}\r\n" +
                "No hay estudiantes en lista de espera\r\n";
        mensajeProfesor = "Profesores:\r\n" +
                "Profesor{nombre= Pedro, especialidad= BIOLOGIA, experiencia= '10'}\r\n" +
                "Profesor{nombre= Carla, especialidad= MATEMATICA, experiencia= '5'}\r\n" +
                "Profesor{nombre= Luis, especialidad= HISTORIA, experiencia= '8'}\r\n" +
                "No hay profesores en espera\r\n";
        mensajePersonal = "Personal Administrativo:\r\n" +
                "PersonalAdministrativo{nombre= 'Marko', profesion= 'Rector'}\r\n" +
                "PersonalAdministrativo{nombre= 'Seba', profesion= 'Vicerector'}\r\n";
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void agregarEstudiante() {
        colegio.agregarEstudiante("Leticia", "camino a relun 9km", "190000000",fechaIncorporacion, 6.2);

    }

    @Test
    public void agregarEstudianteListaEspera() {
    }

    @Test
    public void imprimirEstudiantes() {
        PrintStream save_out = System.out;
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        colegio.imprimirEstudiantes(colegio.getEstudiantes(),colegio.getListaEsperaEstudiantes());
        assertEquals(mensajeEstudiante,out.toString());

        exceptionRule.expect(NullPointerException.class);//null
        colegio.imprimirEstudiantes(null,null);
    }

    @Test
    public void agregarProfesor() {
    }

    @Test
    public void agregarProfesorListaEspera() {
    }

    @Test
    public void imprimirProfesores() {
        PrintStream save_out = System.out;
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        colegio.imprimirProfesores(colegio.getProfesores(),colegio.getListaEsperaProfesores());
        assertEquals(mensajeProfesor,out.toString());

        exceptionRule.expect(NullPointerException.class);//null
        colegio.imprimirProfesores(null,null);
    }

    @Test
    public void agregarPersonalAdministrativo() {
    }

    @Test
    public void imprimirPersonal() {
        PrintStream save_out = System.out;
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        colegio.imprimirPersonal(colegio.getPersonal());
        assertEquals(mensajePersonal,out.toString());

        exceptionRule.expect(NullPointerException.class);//null
        colegio.imprimirPersonal(null);
    }
}