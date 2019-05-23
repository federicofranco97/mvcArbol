package DTOs;

public class PersonaDTO{
    
    private String nombre;
    
    public PersonaDTO(String nombre) {
        setNombre(nombre);
    }

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
