import java.util.*;

public class Estante {

    private Set<Vinilo> vinilos;

    public Estante() {
        vinilos = new HashSet<Vinilo>();
    }

    public Set<Vinilo> getVinilos() {
        return vinilos;
    }

    public void setVinilos(Set<Vinilo> vinilos) {
        this.vinilos = vinilos;
    }

    public boolean agregarVinilo(Vinilo vinilo){
        return vinilos.add(vinilo);
    }

    public boolean buscarVinilo(Vinilo vinilo){
        if(vinilos.isEmpty()){
            throw new NullPointerException("No hay vinilos en el estante");
        } else return vinilos.contains(vinilo);
    }

    public void venderVinilo(Vinilo vinilo){
        if(vinilos.isEmpty()){
            throw new NullPointerException("No hay vinilos en el estante");
        } else {
            vinilos.remove(vinilo);
        }
    }

    public static void imprimirVinilos(Set<Vinilo> vinilos){
        if(vinilos.isEmpty()){
            throw new NullPointerException("No hay vinilos en el estante");
        } else {
            System.out.println("Vinilos: ");
            Iterator<Vinilo> iterator = vinilos.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next().toString());
            }
        }
    }

}
