public class Persona {

    private String nombre;
    private String id;
    private String tipoPersona;

    private Vehiculo vehiculo;

    public Persona(String nombre, String id, String tipoPersona, Vehiculo vehiculo) {
        this.nombre = nombre;
        this.id = id;
        this.tipoPersona = tipoPersona;
        this.vehiculo = vehiculo;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public String toString() {
        return  " \n\nNombre: " + nombre +
                " \nId: " + id +
                " \nTipo de Persona: " + tipoPersona+
                " \nTipo vehiculo: "+vehiculo.getTipoVehiculo()+
                " \nPlaca: "+ vehiculo.getPlaca();
    }
}
