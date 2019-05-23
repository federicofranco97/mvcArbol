package Repositorios;

import Models.Persona;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class PersonaRepository {
   
    List<Persona> listaPersonas=new ArrayList<Persona>();

    public List<Persona> getListaPersonas() {
        return listaPersonas;
    }
    
    public long addPersona(Persona p){
        listaPersonas.add(p);
        return listaPersonas.indexOf(p);
    }
}
