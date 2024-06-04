public class Espacio {
    private int nivel;
    private String numeracion;
    private Vehiculo vehiculo;
    public Espacio(){

    }

    public Espacio(int nivel, String numeracion, Vehiculo vehiculo) {
        this.nivel = nivel;
        this.numeracion = numeracion;
        this.vehiculo = vehiculo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getNumeracion() {
        return numeracion;
    }

    public void setNumeracion(String numeracion) {
        this.numeracion = numeracion;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
}
