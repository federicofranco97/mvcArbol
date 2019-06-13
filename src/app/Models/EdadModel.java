
package app.Models;


public class EdadModel {
    
    private int edadEstimada;
    private boolean inmigrante;

    public EdadModel() {
    }

    public EdadModel(int edadEstimada) {
        this.edadEstimada = edadEstimada;
    }

    public int getEdadEstimada() {
        return edadEstimada;
    }

    public void setEdadEstimada(int edadEstimada) {
        this.edadEstimada = edadEstimada;
    }

    public boolean isInmigrante() {
        return inmigrante;
    }

    public void setInmigrante(boolean inmigrante) {
        this.inmigrante = inmigrante;
    }
    
}
