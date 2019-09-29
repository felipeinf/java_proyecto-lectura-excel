package app.modelo;

import java.util.ArrayList;

public class ColeccionDespacho {
    private ArrayList<Despacho> despachos;
    private int posicionActual;
    
    public ColeccionDespacho(){
        despachos = new ArrayList<>();
        posicionActual = 0;
    }
    
    public void irAinicio(){
        posicionActual = 0;
    }
    
    public void avanzar(){
        posicionActual++;
    }
    
    public boolean agregarDespacho(Despacho despacho){
        return despachos.add(despacho);
    }
    
    public Despacho obtenerActual(){
        return despachos.get(posicionActual);
    }
    
    public boolean finalDeLista(){
        return (posicionActual == despachos.size());
    }
}
