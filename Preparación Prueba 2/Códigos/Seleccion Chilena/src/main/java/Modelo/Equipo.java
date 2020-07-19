package Modelo;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class Equipo {

    private Map<Jugador, Integer> jugadores;
    private Set<DireccionTecnica> cuerpoTecnico;

    public Equipo() {
        jugadores = new HashMap<Jugador, Integer>();
        cuerpoTecnico = new HashSet<DireccionTecnica>();
    }

    public Map<Jugador, Integer> getJugadores() {
        return jugadores;
    }

    public void setJugadores(Map<Jugador, Integer> jugadores) {
        this.jugadores = jugadores;
    }

    public Set<DireccionTecnica> getCuerpoTecnico() {
        return cuerpoTecnico;
    }

    public void setCuerpoTecnico(Set<DireccionTecnica> cuerpoTecnico) {
        this.cuerpoTecnico = cuerpoTecnico;
    }

    public void agregarJugador(Jugador jugador){
        jugadores.put(jugador,jugador.getNumeroCamiseta());
    }

    public boolean agregarCuerpoTecnico(DireccionTecnica direccionTecnica){
        return cuerpoTecnico.add(direccionTecnica);
    }

    public boolean buscarJugador(Jugador jugador){
        if(jugadores.isEmpty()){
            throw new NullPointerException("No hay jugadores");
        } else {
            return jugadores.containsKey(jugador);
        }
    }

    public static void imprimirPlantel(Map<Jugador,Integer> jugadores){
        if(jugadores.isEmpty()){
            throw new NullPointerException("No hay jugadores");
        } else {
            System.out.println("Selección Chilena: ");
            for (Jugador jugador : jugadores.keySet()) {
                System.out.println(jugador.toString());
            }
        }
    }

    public static void imprimirCuerpoTecnico(Set<DireccionTecnica> direccionTecnica){
        if(direccionTecnica.isEmpty()){
            throw new NullPointerException("No hay cuerpo tecnico");
        } else {
            System.out.println("Cuerpo Técnico ");
            Iterator<DireccionTecnica> iterator = direccionTecnica.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next().toString());
            }
        }
    }
}
