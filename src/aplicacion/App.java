package aplicacion;

import controladores.Generador;
import controladores.Lector;
import java.io.File;
import java.io.IOException;
import modelo.ColeccionDespacho;
import modelo.Despacho;
 
/**
 *
 * @author 
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        String path;
        File file;
        Lector lector;
        ColeccionDespacho despachos;
        Despacho despacho;
        
        path = "merlina_legacy.xlsx";
        file = new File(path);
        lector = new Lector(file);
        despachos = lector.generarListaDespachos();
        
        
        //Mostramos la coleccion
        despachos.irAinicio(); //Nos aseguramos de estar en el incio.
        
        while(despachos.finalDeLista() == false) //Mientra no sea el final de la lista.
        { 
            despacho = despachos.obtenerActual(); //Obtenemos el elemento actual.
            
            System.out.println(despacho.getNumeroDespacho()); //Mostramos el codigo del producto.
            
            despachos.avanzar(); //Avanzamos en la coleccion.
        }
    }
}
