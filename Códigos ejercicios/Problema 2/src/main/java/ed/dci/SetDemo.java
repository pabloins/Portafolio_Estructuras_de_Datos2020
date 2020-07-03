package ed.dci;

import java.util.ArrayList;

public class SetDemo {

    public ArrayList<Integer>[] buckets;

    private int tamanoActual = 0;

    private double factorIndicador;

    public SetDemo(int tamano, double factorIndicador){
        buckets = new ArrayList[tamano];
        for( int i=0 ;i < tamano ;i++){
            buckets[i] = new ArrayList<Integer>();
        }
        this.factorIndicador = factorIndicador;
    }

    private int hashCode(int valor){
        return valor;
    }

    public boolean add(int valor) {
        int index = hashCode(valor) % buckets.length;
        if(buckets[index] == null){
            buckets[index] = buckets[valor];
            return true;
        } else if(!contiene(valor)){
        ArrayList<Integer> bucket = buckets[index];
        bucket.add(valor);
        return true;
        } else {
            return false;
        }
     }

    public boolean contiene(int valor){
        int index = hashCode(valor) % buckets.length;
        ArrayList<Integer> bucket = buckets[index];
        if(bucket.contains(valor)){
            return true;
        } else {
            return false;
        }
    }
}
