package DTOs;

import java.util.Date;

public class PersonaDTO{
    
    private String nombre;
    private String apellido;
    private long id;
    private String genero;
    private Date dob;

    public PersonaDTO(String nombre, String apellido, String genero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
    }

    public PersonaDTO(String nombre, String apellido, String genero, Date dob) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.dob = dob;
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
