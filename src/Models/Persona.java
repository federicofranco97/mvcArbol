package Models;

import java.util.ArrayList;
import java.util.Collection;

public class Persona {
    private String nombre;
    private String apellido;
    private long id;
    private String genero;
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
