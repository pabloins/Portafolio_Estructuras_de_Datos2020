import java.util.*;

public class Estante {

    private Stack<Vinilo> vinilosStack;
    private List<Vinilo> vinilosList;
    private Set<Vinilo> vinilosHashSet;
    private Map<Vinilo, Double> vinilosMap;

    public Estante() {
        this.vinilosStack = new Stack<Vinilo>();
        this.vinilosList = new LinkedList<Vinilo>();
        this.vinilosHashSet = new HashSet<Vinilo>();
        this.vinilosMap = new HashMap<Vinilo, Double>();
    }

    public Stack<Vinilo> getVinilosStack() {
        return vinilosStack;
    }

    public List<Vinilo> getVinilosList() {
        return vinilosList;
    }

    public Set<Vinilo> getVinilosHashSet() {
        return vinilosHashSet;
    }

    public Map<Vinilo, Double> getVinilosMap() {
        return vinilosMap;
    }

    public void agregarViniloStack(String nombreArtista, Date fechaPublicacion, String nombreVinilo, double valorVinilo){
        this.vinilosStack.push(new Vinilo(nombreArtista, fechaPublicacion, nombreVinilo, valorVinilo));
    }

    public void agregarViniloList(String nombreArtista, Date fechaPublicacion, String nombreVinilo, double valorVinilo){
        this.vinilosList.add(new Vinilo(nombreArtista, fechaPublicacion, nombreVinilo, valorVinilo));
    }

    public void agregarViniloHashSet(String nombreArtista, Date fechaPublicacion, String nombreVinilo, double valorVinilo){
        this.vinilosHashSet.add(new Vinilo(nombreArtista, fechaPublicacion, nombreVinilo, valorVinilo));
    }

    public void agregarViniloMap(String nombreArtista, Date fechaPublicacion, String nombreVinilo, double valorVinilo){
         this.vinilosMap.put(new Vinilo(nombreArtista, fechaPublicacion, nombreVinilo, valorVinilo), valorVinilo);
    }

    public static void imprimirVinilosStack(Stack<Vinilo> vinilosStack){
        if(vinilosStack.empty()){
            throw new NullPointerException("No hay vinilos en la colección");
        } else {
            System.out.println("Vinilos: ");
            Iterator<Vinilo> iterator = vinilosStack.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next().toString());
            }
        }
    }

    public static void imprimirVinilosList(List<Vinilo> vinilosList){
        if(vinilosList.size() != 0){
            System.out.println("Vinilos: ");
            Iterator<Vinilo> iterator = vinilosList.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next().toString());
            }
        } else {
            throw new NullPointerException("No hay vinilos en la colección");
        }
    }

    public static void imprimirVinilosHashSet(HashSet<Vinilo> vinilosHashSet){
        if(vinilosHashSet.size() == 0){
            throw new NullPointerException("No hay vinilos en la colección");
        } else {
            System.out.println("Vinilos: ");
            Iterator<Vinilo> iterator = vinilosHashSet.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next().toString());
            }
        }
    }

    public static void imprimirVinilosMap(Map vinilosMap){
        if(vinilosMap == null){
            throw new NullPointerException("No hay vinilos en la colección");
        } else {
            System.out.println("Vinilos: ");
            Iterator<Map.Entry<Vinilo, Double>> iterator = vinilosMap.entrySet().iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next().toString());
            }
        }
    }
}
