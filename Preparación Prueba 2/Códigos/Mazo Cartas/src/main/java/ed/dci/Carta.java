package ed.dci;

public class Carta {

   private TipoCarta tipoCarta;
   private RangoCarta rangoCarta;

    public Carta(TipoCarta tipoCarta, RangoCarta rangoCarta) {
        this.tipoCarta = tipoCarta;
        this.rangoCarta = rangoCarta;
    }

    public TipoCarta getTipoCarta() {
        return tipoCarta;
    }

    public void setTipoCarta(TipoCarta tipoCarta) {
        this.tipoCarta = tipoCarta;
    }

    public RangoCarta getRangoCarta() {
        return rangoCarta;
    }

    public void setRangoCarta(RangoCarta rangoCarta) {
        this.rangoCarta = rangoCarta;
    }

    @Override
    public String toString() {
        return "Carta{" +
                "tipoCarta=" + tipoCarta +
                ", rangoCarta=" + rangoCarta +
                '}';
    }
}
