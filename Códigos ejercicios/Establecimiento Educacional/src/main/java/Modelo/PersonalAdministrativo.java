package Modelo;

public class PersonalAdministrativo extends Persona {

    private String profesion;

    public PersonalAdministrativo(String nombre, String profesion) {
        super(nombre);
        this.profesion = profesion;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    @Override
    public String toString() {
        return "PersonalAdministrativo{" +
                "nombre= '" + nombre + '\'' +
                ", profesion= '" + profesion + '\'' +
                '}';
    }
}
