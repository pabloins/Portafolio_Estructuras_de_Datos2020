package Modelo;

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
    Establecimiento colegioVacio;
    Date fechaIncorporacion;
    String mensajeEstudiante;
    String mensajeEstudianteAgregandoAlumno;
    String mensajeEstudianteAlumnosListaEspera;
    String mensajeProfesor;
    String mensajeProfesorAgregandoProfesores;
    String mensajeProfesorListaEspera;
    String mensajePersonal;
    String mensajePersonalAgregando;

    @Before
    public void setUp() throws Exception {
        colegio = new Establecimiento();
        colegioVacio = new Establecimiento();
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
        mensajeEstudianteAgregandoAlumno = "Estudiantes: \r\n" +
                "Estudiante{nombre= Fernanda, direccion= 'Calle Corea del Norte 1', rut= '21111111', fechaIncorporacion= 'Tue Jan 27 00:00:00 CLST 3920', promedio= 4.5}\r\n" +
                "Estudiante{nombre= Sergio, direccion= 'Calle Paraguay 4', rut= '18000300', fechaIncorporacion= 'Tue Jan 27 00:00:00 CLST 3920', promedio= 4.8}\r\n" +
                "Estudiante{nombre= Raul, direccion= 'Calle Bolivia 92', rut= '19030000', fechaIncorporacion= 'Tue Jan 27 00:00:00 CLST 3920', promedio= 5.2}\r\n" +
                "Estudiante{nombre= Javier, direccion= 'Calle Peru 8', rut= '19890899', fechaIncorporacion= 'Tue Jan 27 00:00:00 CLST 3920', promedio= 5.3}\r\n" +
                "Estudiante{nombre= Rodrigo, direccion= 'Francisco Bilbao 600', rut= '230000000', fechaIncorporacion= 'Tue Jan 27 00:00:00 CLST 3920', promedio= 5.8}\r\n" +
                "Estudiante{nombre= Isabel, direccion= 'Calle Brasil 12', rut= '18000000', fechaIncorporacion= 'Tue Jan 27 00:00:00 CLST 3920', promedio= 5.8}\r\n" +
                "Estudiante{nombre= Pepe, direccion= 'camino a relun 9km', rut= '190000000', fechaIncorporacion= 'Tue Jan 27 00:00:00 CLST 3920', promedio= 6.1}\r\n" +
                "Estudiante{nombre= Leticia, direccion= 'camino a relun 9km', rut= '190000000', fechaIncorporacion= 'Tue Jan 27 00:00:00 CLST 3920', promedio= 6.2}\r\n" +
                "Estudiante{nombre= Catalina, direccion= 'Calle Uruguay 902', rut= '20300000', fechaIncorporacion= 'Tue Jan 27 00:00:00 CLST 3920', promedio= 6.8}\r\n" +
                "No hay estudiantes en lista de espera\r\n";
        mensajeEstudianteAlumnosListaEspera = "Estudiantes: \r\n" +
                "Estudiante{nombre= Fernanda, direccion= 'Calle Corea del Norte 1', rut= '21111111', fechaIncorporacion= 'Tue Jan 27 00:00:00 CLST 3920', promedio= 4.5}\r\n" +
                "Estudiante{nombre= Sergio, direccion= 'Calle Paraguay 4', rut= '18000300', fechaIncorporacion= 'Tue Jan 27 00:00:00 CLST 3920', promedio= 4.8}\r\n" +
                "Estudiante{nombre= Raul, direccion= 'Calle Bolivia 92', rut= '19030000', fechaIncorporacion= 'Tue Jan 27 00:00:00 CLST 3920', promedio= 5.2}\r\n" +
                "Estudiante{nombre= Javier, direccion= 'Calle Peru 8', rut= '19890899', fechaIncorporacion= 'Tue Jan 27 00:00:00 CLST 3920', promedio= 5.3}\r\n" +
                "Estudiante{nombre= Rodrigo, direccion= 'Francisco Bilbao 600', rut= '230000000', fechaIncorporacion= 'Tue Jan 27 00:00:00 CLST 3920', promedio= 5.8}\r\n" +
                "Estudiante{nombre= Isabel, direccion= 'Calle Brasil 12', rut= '18000000', fechaIncorporacion= 'Tue Jan 27 00:00:00 CLST 3920', promedio= 5.8}\r\n" +
                "Estudiante{nombre= Pepe, direccion= 'camino a relun 9km', rut= '190000000', fechaIncorporacion= 'Tue Jan 27 00:00:00 CLST 3920', promedio= 6.1}\r\n" +
                "Estudiante{nombre= Catalina, direccion= 'Calle Uruguay 902', rut= '20300000', fechaIncorporacion= 'Tue Jan 27 00:00:00 CLST 3920', promedio= 6.8}\r\n" +
                "Estudiantes en Lista de espera:\r\n" +
                "Estudiante{nombre= Pedro, direccion= 'camino a relun 9km', rut= '190000000', fechaIncorporacion= 'Tue Jan 27 00:00:00 CLST 3920', promedio= 5.2}\r\n" +
                "Estudiante{nombre= Carla, direccion= 'camino a relun 9km', rut= '190000000', fechaIncorporacion= 'Tue Jan 27 00:00:00 CLST 3920', promedio= 4.2}\r\n" +
                "Estudiante{nombre= Pablo, direccion= 'camino a relun 9km', rut= '190000000', fechaIncorporacion= 'Tue Jan 27 00:00:00 CLST 3920', promedio= 6.7}\r\n" +
                "Estudiante{nombre= Agustina, direccion= 'camino a relun 9km', rut= '190000000', fechaIncorporacion= 'Tue Jan 27 00:00:00 CLST 3920', promedio= 4.7}\r\n" +
                "Estudiante{nombre= Carlos, direccion= 'camino a relun 9km', rut= '190000000', fechaIncorporacion= 'Tue Jan 27 00:00:00 CLST 3920', promedio= 5.9}\r\n" +
                "Estudiante{nombre= Fernanda, direccion= 'camino a relun 9km', rut= '190000000', fechaIncorporacion= 'Tue Jan 27 00:00:00 CLST 3920', promedio= 6.2}\r\n";
        mensajeProfesor = "Profesores:\r\n" +
                "Profesor{nombre= Pedro, especialidad= BIOLOGIA, experiencia= '10'}\r\n" +
                "Profesor{nombre= Carla, especialidad= MATEMATICA, experiencia= '5'}\r\n" +
                "Profesor{nombre= Luis, especialidad= HISTORIA, experiencia= '8'}\r\n" +
                "No hay profesores en espera\r\n";
        mensajeProfesorAgregandoProfesores = "Profesores:\r\n" +
                "Profesor{nombre= Pedro, especialidad= BIOLOGIA, experiencia= '10'}\r\n" +
                "Profesor{nombre= Carla, especialidad= MATEMATICA, experiencia= '5'}\r\n" +
                "Profesor{nombre= Luis, especialidad= HISTORIA, experiencia= '8'}\r\n" +
                "Profesor{nombre= Berta, especialidad= HISTORIA, experiencia= '8'}\r\n" +
                "Profesor{nombre= Sandro, especialidad= MATEMATICA, experiencia= '8'}\r\n" +
                "No hay profesores en espera\r\n";
        mensajeProfesorListaEspera = "Profesores:\r\n" +
                "Profesor{nombre= Pedro, especialidad= BIOLOGIA, experiencia= '10'}\r\n" +
                "Profesor{nombre= Carla, especialidad= MATEMATICA, experiencia= '5'}\r\n" +
                "Profesor{nombre= Luis, especialidad= HISTORIA, experiencia= '8'}\r\n" +
                "Profesores en Lista de espera:\r\n" +
                "Profesor{nombre= Berta, especialidad= HISTORIA, experiencia= '8'}\r\n" +
                "Profesor{nombre= Sandro, especialidad= MATEMATICA, experiencia= '8'}\r\n";
        mensajePersonal = "Personal Administrativo:\r\n" +
                "PersonalAdministrativo{nombre= 'Marko', profesion= 'Rector'}\r\n" +
                "PersonalAdministrativo{nombre= 'Seba', profesion= 'Vicerector'}\r\n";
        mensajePersonalAgregando = "Personal Administrativo:\r\n" +
                "PersonalAdministrativo{nombre= 'Marko', profesion= 'Rector'}\r\n" +
                "PersonalAdministrativo{nombre= 'Seba', profesion= 'Vicerector'}\r\n" +
                "PersonalAdministrativo{nombre= 'Coraje', profesion= 'Secretario'}\r\n" +
                "PersonalAdministrativo{nombre= 'Muriel', profesion= 'Director'}\r\n" +
                "PersonalAdministrativo{nombre= 'Justo', profesion= 'Jefe UTP'}\r\n";
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void agregarEstudiante() {
        colegio.agregarEstudiante("Leticia", "camino a relun 9km", "190000000",fechaIncorporacion, 6.2);
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        colegio.imprimirEstudiantes(colegio.getEstudiantes(),colegio.getListaEsperaEstudiantes());
        assertEquals(mensajeEstudianteAgregandoAlumno,out.toString())
    }

    @Test
    public void agregarEstudianteListaEspera() {
        colegio.agregarEstudianteListaEspera("Pedro", "camino a relun 9km", "190000000",fechaIncorporacion, 5.2);
        colegio.agregarEstudianteListaEspera("Carla", "camino a relun 9km", "190000000",fechaIncorporacion, 4.2);
        colegio.agregarEstudianteListaEspera("Pablo", "camino a relun 9km", "190000000",fechaIncorporacion, 6.7);
        colegio.agregarEstudianteListaEspera("Agustina", "camino a relun 9km", "190000000",fechaIncorporacion, 4.7);
        colegio.agregarEstudianteListaEspera("Carlos", "camino a relun 9km", "190000000",fechaIncorporacion, 5.9);
        colegio.agregarEstudianteListaEspera("Fernanda", "camino a relun 9km", "190000000",fechaIncorporacion, 6.2);
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        colegio.imprimirEstudiantes(colegio.getEstudiantes(),colegio.getListaEsperaEstudiantes());
        assertEquals(mensajeEstudianteAlumnosListaEspera,out.toString());
    }

    @Test
    public void imprimirEstudiantes() {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        colegio.imprimirEstudiantes(colegio.getEstudiantes(),colegio.getListaEsperaEstudiantes());
        assertEquals(mensajeEstudiante,out.toString());

        exceptionRule.expect(NullPointerException.class);//null
        colegio.imprimirEstudiantes(null,null);
    }

    @Test
    public void agregarProfesor() {
        colegio.agregarProfesor("Berta",Especialidad.HISTORIA,8);
        colegio.agregarProfesor("Sandro",Especialidad.MATEMATICA,8);
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        colegio.imprimirProfesores(colegio.getProfesores(),colegio.getListaEsperaProfesores());
        assertEquals(mensajeProfesorAgregandoProfesores,out.toString());
    }

    @Test
    public void agregarProfesorListaEspera() {
        colegio.agregarProfesorListaEspera("Berta",Especialidad.HISTORIA,8);
        colegio.agregarProfesorListaEspera("Sandro",Especialidad.MATEMATICA,8);
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        colegio.imprimirProfesores(colegio.getProfesores(),colegio.getListaEsperaProfesores());
        assertEquals(mensajeProfesorListaEspera,out.toString());
    }

    @Test
    public void imprimirProfesores() {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        colegio.imprimirProfesores(colegio.getProfesores(),colegio.getListaEsperaProfesores());
        assertEquals(mensajeProfesor,out.toString());

        exceptionRule.expect(NullPointerException.class);//null
        colegio.imprimirProfesores(null,null);
    }

    @Test
    public void agregarPersonalAdministrativo() {
        colegio.agregarPersonalAdministrativo("Coraje", "Secretario");
        colegio.agregarPersonalAdministrativo("Muriel", "Director");
        colegio.agregarPersonalAdministrativo("Justo", "Jefe UTP");
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        colegio.imprimirPersonal(colegio.getPersonal());
        assertEquals(mensajePersonalAgregando,out.toString());
    }

    @Test
    public void imprimirPersonal() {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        colegio.imprimirPersonal(colegio.getPersonal());
        assertEquals(mensajePersonal,out.toString());
    }

    @Test
    public void imprimirPersonalVacio(){
        exceptionRule.expect(NullPointerException.class);
        exceptionRule.expectMessage("No hay Personal Administrativo");
        colegioVacio.imprimirPersonal(colegioVacio.getPersonal());
    }
}