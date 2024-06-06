import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lista {


    private List<Persona> personas;






    public Lista() {
        personas = new ArrayList<Persona>();
    }



    public List<Persona> getPersonas() {
        return personas;
    }

    public void adicionarElementos(Persona p) throws Exception {
        if(buscarPersona(p.getId())==null) {
            personas.add(p);
        }else{
            throw new Exception("Persona con este ID de banner ya existe más de dos veces");
        }
    }

    public List<Persona> listarPersonas(){
        List<Persona> lista = new LinkedList<>();
        for (Persona e: personas)
            lista.add(e);
        return lista;
    }


    public Persona buscarPersona(String id) {
        for (Persona p : personas)
            if (p.getId().equals(id))
                return p;
        return null;
    }
    public void editar(String nuevoNombre, String id, String nuevoTipoPersona, Vehiculo nuevaPlaca, Vehiculo nuevoTipoVehiculo)  throws Exception {
        Persona persona = buscarPersona(id);
        if (persona != null) {
            persona.setNombre(nuevoNombre);
            persona.setTipoPersona(nuevoTipoPersona);
            persona.setVehiculo(nuevaPlaca);
            persona.setVehiculo(nuevoTipoVehiculo);
        } else {
            throw new Exception("No se encontró ninguna perona con el id : " + id);
        }
    }

    public void eliminarPersona(String id) throws Exception {
        Persona persona = buscarPersona(id);
        if (persona != null) {
            personas.remove(persona);
        } else {
            throw new Exception("La persona con el ID " + id + " no está en la lista.");
        }
    }




}
