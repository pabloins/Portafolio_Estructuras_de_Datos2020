package Modelo;

public enum Especialidad {

    BIOLOGIA("Biología"),
    MATEMATICA("Matemática"),
    HISTORIA("Historia");

    private String especialidad;

    Especialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }
}
