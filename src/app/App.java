package app;

import java.io.File;
import java.io.IOException;

import app.controladores.Generador;
import app.controladores.Lector;
import app.modelo.ColeccionDespacho;
import java.util.Date;
 
public class App {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //Datos de lectura
        String rutaArhivoLectura = "merlina_legacy.xlsx";
        File file = new File(rutaArhivoLectura);
        Lector lector = new Lector(file);
        
        //Datos de escritura
        String nombreArchivoEscritura = "consolidado-despachos"; 
        ColeccionDespacho despachos = lector.generarListaDespachos(); //Usas el lector para crear la lista.
        
        Generador generador = new Generador(despachos); 
        
        Date fechaInicio = new Date();
        Date fechaTermino = new Date();
        int m = 4;
        int n = 6; 
       
        if(generador.generarPlanillaConsolidados(nombreArchivoEscritura, fechaInicio, fechaTermino, m, n) == true){  //Se le pasaron fechas vacias para que no tire error.
            //Si es true no hay errores y se creo el archivo.
            System.out.println("El archivo " + generador.getNombreArchivoEcritura()+ " ha sido creado con exito.");
        }
        else {
            System.out.println("Error al crear el archivo.");
        }
    }
}
