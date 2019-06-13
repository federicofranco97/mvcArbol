
package app.Models;


public class Seteo {
    String valor;
    String descripcion;

    public Seteo(String valor, String descripcion) {
        this.valor = valor;
        this.descripcion = descripcion;
    }

    public Seteo() {
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
