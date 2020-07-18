package Modelo;

import java.util.*;

public class Establecimiento {

    private Stack<Estudiante> estudiantes;
    private Queue<Estudiante> listaEsperaEstudiantes;
    private Stack<Profesor> profesores;
    private Queue<Profesor> listaEsperaProfesores;
    private List<PersonalAdministrativo> personal;


    public Establecimiento() {
        this.estudiantes = new Stack();
        this.listaEsperaEstudiantes = new LinkedList();
        this.profesores = new Stack();
        this.listaEsperaProfesores = new LinkedList();
        this.personal = new LinkedList();
    }

    public Stack<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public Queue<Estudiante> getListaEsperaEstudiantes() {
        return listaEsperaEstudiantes;
    }

    public Stack<Profesor> getProfesores() {
        return profesores;
    }

    public Queue<Profesor> getListaEsperaProfesores() {
        return listaEsperaProfesores;
    }

    public List<PersonalAdministrativo> getPersonal() {
        return personal;
    }

    public void agregarEstudiante(String nombre, String direccion, String rut, Date fechaIncorporacion, double promedio){
        this.estudiantes.push(new Estudiante(nombre, direccion, rut, fechaIncorporacion, promedio));
        Comparator<Estudiante> comparator
                = Comparator
                .comparing(Estudiante::getPromedio)
                .thenComparingDouble(Estudiante::getPromedio);
        Collections.sort(estudiantes, comparator);
    }

    public void agregarEstudianteListaEspera(String nombre, String direccion, String rut, Date fechaIncorporacion, double promedio){
        this.listaEsperaEstudiantes.add(new Estudiante(nombre, direccion, rut, fechaIncorporacion, promedio));
    }

    public static void imprimirEstudiantes(Stack<Estudiante> estudiantes, Queue<Estudiante> listaEsperaEstudiantes){
        if(estudiantes == null){
            throw new NullPointerException();
        }
        if(estudiantes.size() != 0){
            System.out.println("Estudiantes: ");
            Iterator<Estudiante> estudianteIterator = estudiantes.iterator();
            while (estudianteIterator.hasNext()){
                System.out.println(estudianteIterator.next().toString());
            }
            if(listaEsperaEstudiantes.size() != 0){
                System.out.println("Estudiantes en Lista de espera:");
                Iterator<Estudiante> iterator = listaEsperaEstudiantes.iterator();
                while (iterator.hasNext()){
                    System.out.println(iterator.next().toString());
                }
            } else {
                System.out.println("No hay estudiantes en lista de espera");
            }
        } else {
            System.out.println("No hay estudiantes inscritos");
        }
    }

    public void agregarProfesor(String nombre, Especialidad especialidad, int experiencia){
        this.profesores.push(new Profesor(nombre, especialidad, experiencia));
    }

    public void agregarProfesorListaEspera(String nombre, Especialidad especialidad, int experiencia){
        this.listaEsperaProfesores.add(new Profesor(nombre, especialidad, experiencia));
    }

    public static void imprimirProfesores(Stack<Profesor> profesores, Queue<Profesor> listaEsperaProfesores){
        if(profesores == null){
            throw new NullPointerException();
        }
        if (profesores.size() != 0){
            System.out.println("Profesores:");
            Iterator<Profesor> profesorIterator = profesores.iterator();
            while (profesorIterator.hasNext()) {
                System.out.println(profesorIterator.next().toString());
            }
            if (listaEsperaProfesores.size() != 0) {
                System.out.println("Profesores en Lista de espera:");
                Iterator<Profesor> profesoresEspera = listaEsperaProfesores.iterator();
                while (profesoresEspera.hasNext()) {
                    System.out.println(profesoresEspera.next().toString());
                }
            } else {
                System.out.println("No hay profesores en espera");
            }
        } else {
            System.out.println("No hay profesores inscritos");
        }
    }

    public void agregarPersonalAdministrativo(String nombre, String profesion){
        this.personal.add(new PersonalAdministrativo(nombre, profesion));
    }

    public static void imprimirPersonal(List<PersonalAdministrativo> personal){
        if(personal.isEmpty()){
            throw new NullPointerException("No hay Personal Administrativo");
        } else {
            System.out.println("Personal Administrativo:");
            Iterator<PersonalAdministrativo> iterator = personal.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next().toString());
            }
        }
    }
}
