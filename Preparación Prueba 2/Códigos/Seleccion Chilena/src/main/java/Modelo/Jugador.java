package Modelo;

public class Jugador extends Persona{

    private int numeroCamiseta;
    private Posicion posicion;

    public Jugador(String nombre, String apellido, int numeroCamiseta, Posicion posicion) {
        super(nombre, apellido);
        this.numeroCamiseta = numeroCamiseta;
        this.posicion = posicion;
    }

    public int getNumeroCamiseta() {
        return numeroCamiseta;
    }

    public void setNumeroCamiseta(int numeroCamiseta) {
        this.numeroCamiseta = numeroCamiseta;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return "Jugador{nombre= " + getNombre() +
                ", apellido= " + getApellido() +
                ", numeroCamiseta= " + numeroCamiseta +
                ", posicion= " + posicion +
                '}';
    }
}
