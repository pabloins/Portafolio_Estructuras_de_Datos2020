import java.util.Date;

public class Vinilo {

    private String nombreArtista;
    private Date fechaPublicacion;
    private String nombreVinilo;
    private double valorVinilo;

    public Vinilo(String nombreArtista, Date fechaPublicacion, String nombreVinilo, double valorVinilo) {
        this.nombreArtista = nombreArtista;
        this.fechaPublicacion = fechaPublicacion;
        this.nombreVinilo = nombreVinilo;
        this.valorVinilo = valorVinilo;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getNombreVinilo() {
        return nombreVinilo;
    }

    public void setNombreVinilo(String nombreVinilo) {
        this.nombreVinilo = nombreVinilo;
    }

    public double getValorVinilo() {
        return valorVinilo;
    }

    public void setValorVinilo(double valorVinilo) {
        this.valorVinilo = valorVinilo;
    }

    @Override
    public String toString() {
        return "Vinilo{" +
                "nombreArtista='" + nombreArtista + '\'' +
                ", fechaPublicacion=" + fechaPublicacion +
                ", nombreVinilo='" + nombreVinilo + '\'' +
                ", valorVinilo=" + valorVinilo +
                '}';
    }
}
