package app.Models;

import app.DTOs.PersonaDTO;
import java.util.ArrayList;
import java.util.Collection;
//fechaFallecimiento paisNatal paisReside Domicilio
public class Persona {
    private String nombre;
    private String apellido;
    private long id;
    private String genero;
    private String fechaMuerte;
    private String paisNatal;
    private String paisVive;
    private String domicilio;
    private String fechaNac;
    private Persona padre;
    private Persona madre;
    private ArrayList<Persona> hijos = new ArrayList<Persona>();
    

    public Persona(String nombre,String apellido, Persona padre, Persona madre,String genero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero=genero;
        this.padre = padre;
        this.madre = madre;
    }

    public Persona(String nombre,String apellido,String genero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero=genero;
    }

    public void actualizar(PersonaDTO personaDTO){
        this.nombre=personaDTO.getNombre();
        this.apellido=personaDTO.getApellido();
        this.id=personaDTO.getId();
        this.genero=personaDTO.getGenero();
        this.fechaMuerte=personaDTO.getFechaMuerte();
        this.fechaNac=personaDTO.getFechaNac();
        this.paisVive=personaDTO.getPaisVive();
        this.paisNatal=personaDTO.getPaisNatal();
        this.domicilio=personaDTO.getDomicilio();
    }
    
    public String getApellido() {
        return apellido;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getGenero() {
        return genero;
    }

    public String getFechaMuerte() {
        return fechaMuerte;
    }

    public void setFechaMuerte(String fechaMuerte) {
        this.fechaMuerte = fechaMuerte;
    }

    public String getPaisNatal() {
        return paisNatal;
    }

    public void setPaisNatal(String paisNatal) {
        this.paisNatal = paisNatal;
    }

    public String getPaisVive() {
        return paisVive;
    }

    public void setPaisVive(String paisVive) {
        this.paisVive = paisVive;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }
    
    public Persona getPadre() {
        return padre;
    }

    public Persona getMadre() {
        return madre;
    }

    public ArrayList<Persona> getHijos() {
        return hijos;
    }

    public void addHijo(Persona p){
        if(p==null)return;
        if(p.equals(this))return;
        getHijos().add(p);
    }
    
    public void addHijos(Collection<? extends Persona> hs)
    {
        if(hs.isEmpty() || hs.contains(null)) return;
        getHijos().addAll(hs);
    }
    
    public String traerNombreHijos(){
        String msj="";
        if(getHijos().isEmpty()){
            return "Esta persona no tiene hijos";
        }else{
            System.out.println("Los nombres de los hijos son:");
            for (int i = 0; i < getHijos().size(); i++) {
                msj=msj+(getHijos().get(i).getNombre()+"\n");
            }
            return msj;
        }
        
    }
    
}
