package Servicios;

import DTOs.PersonaDTO;
import Models.Persona;
import Repositorios.PersonaRepository;
import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Operaciones {
    
    public Operaciones(){
        generarFamiliaPrueba();
    }
    @Autowired
    private PersonaRepository perRepo;
    
    private ArrayList<Persona>lista= new ArrayList<Persona>();
    private ArrayList<PersonaDTO> aux = new ArrayList<>();
    
    public ArrayList<PersonaDTO> getLista() {
       return aux;
    }
     
    //En el constructor, cuando creo una persona que tiene padre, al padre setearle
    //la persona como hijo.
    public ArrayList<PersonaDTO> generarFamiliaPrueba(){
        
        //bisabuelos
        Persona bisa = new Persona("Don Carlos","Espinoza","m");
        Persona bisa2 = new Persona("Esmeralda","Lopez","f");
        Persona bisa3 = new Persona("Miguel","Maritinez","m");
        Persona bisa4 = new Persona("Rosa","Acasusso","f");
        //abuelos
        Persona abue = new Persona("Manuel","Espinoza", bisa, bisa2,"m");
        Persona abue2 = new Persona("Gilda","Martinez",bisa3,bisa4,"f");
        Persona abue3 = new Persona("Marcos","Martinez",bisa3,bisa4,"m");
        Persona abue4 = new Persona("Estela","Martinez",bisa3,bisa4,"f");
        //seteo abuelos como hijos de los bisa
        bisa.addHijo(abue);
        bisa2.addHijo(abue);
        bisa3.addHijo(abue2);
        bisa4.addHijo(abue2);
        //Creo papas
        Persona papa = new Persona("Jorge","Espinoza",abue,abue2,"m");
        Persona papa2 = new Persona("Maria","Martinez",abue3,abue4,"f");
        //Creo tios
        Persona tio = new Persona("Fernando","Espinoza",abue,abue2,"m");
        Persona tio2 = new Persona("Tomas","Espinoza",abue,abue2,"m");
        Persona tio3 = new Persona("Agustina","Espinoza",abue,abue2,"f");
        //Agrego hijos a los abuelos
        abue.addHijos(Arrays.asList(papa,tio, tio2, tio3));
        abue2.addHijos(Arrays.asList(papa,tio, tio2, tio3));
        //Creo los hijos
        Persona hijo = new Persona("Martin","Espinoza",papa,papa2,"m");
        lista.addAll(Arrays.asList(bisa,bisa2,bisa3,bisa4,abue,abue2,abue3,abue4,papa,papa2,tio,tio2,tio3,hijo));
        for (Persona persona : lista) {
            aux.add(new PersonaDTO(persona.getNombre(),persona.getApellido(), persona.getGenero()));
        }
        for (int i = 0; i < aux.size(); i++) {
            aux.get(i).setId(i);
        }
        for (int i = 0; i < lista.size(); i++) {
            lista.get(i).setId(i);
        }
        return aux;
    }
    
    public PersonaDTO getPadreDTO(PersonaDTO personaDTO){
        Persona modelPersona = buscarPorId(personaDTO.getId());
        if(modelPersona.getPadre()!=null){
            return new PersonaDTO(modelPersona.getPadre().getNombre(),
                    modelPersona.getPadre().getApellido(), modelPersona.getPadre().getGenero());
        }else{
            return null;
        }
    }
    
    public PersonaDTO getMadreDTO(PersonaDTO personaDTO){
        Persona modelPersona = buscarPorId(personaDTO.getId());
        if(modelPersona.getMadre()!=null){
            return new PersonaDTO(modelPersona.getMadre().getNombre(),
                    modelPersona.getMadre().getApellido(), modelPersona.getMadre().getGenero());
        }else{
            return null;
        }
    }
    
    public PersonaDTO buscarIdDTO(long id){
        for (PersonaDTO personaDTO : aux) {
            if(personaDTO.getId()==id) return personaDTO;
        }
        return null;
    }
    
    public PersonaDTO buscarNombreDTO(String nombre){
        for (PersonaDTO personaDTO : aux) {
            if(personaDTO.getNombre().equals(nombre)) return personaDTO;
        }
        return null;
        
    }
    
    public Persona buscarNombre(String nombre){
        for (Persona persona : lista) {
            if(persona.getNombre().equals(nombre))return persona;
        }
        return null;
    }
    
    public Persona buscarPorId(long id){
        for (Persona persona : lista) {
            if(persona.getId()==id)return persona;
        }
        return null;
    }
    
}
