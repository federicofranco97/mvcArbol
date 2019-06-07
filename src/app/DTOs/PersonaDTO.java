package app.DTOs;

import java.util.Date;

public class PersonaDTO{
    
    private String nombre;
    private String apellido;
    private long id;
    private String genero;
    private String fechaMuerte;
    private String paisNatal;
    private String paisVive;
    private String domicilio;
    private String fechaNac;

    public PersonaDTO(String nombre, String apellido, String genero,long id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.id=id;
    }

    public PersonaDTO(String nombre, String apellido, String genero, Date dob) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        
    }

    private PersonaDTO(){}

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
    
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    
    
    
    
}
