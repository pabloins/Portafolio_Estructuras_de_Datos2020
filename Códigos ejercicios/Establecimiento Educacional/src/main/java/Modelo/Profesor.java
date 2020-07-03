package Modelo;

public class Profesor extends Persona{

    private Especialidad especialidad;
    private int experiencia;

    public Profesor(String nombre, Especialidad especialidad, int experiencia) {
        super(nombre);
        this.especialidad = especialidad;
        this.experiencia = experiencia;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "nombre= " + nombre +
                ", especialidad= " + especialidad +
                ", experiencia= '" + experiencia + '\'' +
                '}';
    }
}
