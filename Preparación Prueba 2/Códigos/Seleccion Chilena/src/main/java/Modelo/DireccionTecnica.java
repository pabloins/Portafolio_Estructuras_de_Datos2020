package Modelo;

public class DireccionTecnica extends Persona{

    private Ocupacion ocupacion;

    public DireccionTecnica(String nombre, String apellido, Ocupacion ocupacion) {
        super(nombre, apellido);
        this.ocupacion = ocupacion;
    }

    public Ocupacion getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(Ocupacion ocupacion) {
        this.ocupacion = ocupacion;
    }

    @Override
    public String toString() {
        return "DireccionTecnica{nombre= " + getNombre() +
                ", apellido= " + getApellido() +
                ", ocupacion= " + ocupacion +
                '}';
    }
}
