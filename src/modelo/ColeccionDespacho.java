package modelo;

import java.util.ArrayList;
import java.util.LinkedList;


public class ColeccionDespacho {
    private LinkedList<Despacho> despachos;
    //private ArrayList<Despacho> despachos;
    private int posicionActual;
    
    public ColeccionDespacho(){
        despachos = new LinkedList<>(); 
        //despachos = new ArrayList<>();
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
