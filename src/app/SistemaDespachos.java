package app;

import java.io.File;
import java.util.Date;
import java.io.IOException;

import app.controladores.Generador;
import app.controladores.Lector;
import app.modelo.ColeccionDespacho;
import app.modelo.Despacho;

public class SistemaDespachos {
    
    public static void main(String[] args) throws IOException{
        
        //Datos de lectura
        String rutaArhivoLectura = "merlina_legacy.xlsx";
        File file = new File(rutaArhivoLectura);
        Lector lector = new Lector(file);
        
        double latExtNorte;
        double latExtSur;
        double lngExtEste;
        double lngExtOeste;
        
        //Datos de escritura
        String nombreArchivoEscritura = "consolidado-despachos"; 
        ColeccionDespacho despachos = lector.generarListaDespachos(); //Usas el lector para crear la lista.
        
        //Aca obtenemos los limites
        latExtNorte = lector.getLatitudExtremoNorte();
        latExtSur = lector.getLatitudExtremoSur();
        lngExtEste = lector.getLongitudExtremoEste();
        lngExtOeste = lector.getLongitudExtremoOeste();
        
        Generador generador = new Generador(despachos); 
        
        Date fechaInicio = new Date();
        Date fechaTermino = new Date();
        int m = 4;
        int n = 6; 
       
        /*
            AQUI RECORREMOS LA COLECCION USANDO LOS METODOS
        */
        despachos.irAinicio(); //Te aseguras de estar en el principio antes de entrar al bucle.
        
        while(despachos.finalDeLista() == false){  //Mientras no sea el final de la lista.
            Despacho despachoAuxiliar;
            
            despachoAuxiliar = despachos.obtenerActual(); //Obtenemos el actual.
            
            System.out.print("Lat: " + despachoAuxiliar.getLatitud() + "   ");  //Hacemos lo que tenemos que hacer.
            System.out.println("Lng: " + despachoAuxiliar.getLongitud());
            
            despachos.avanzar(); //Finalmente avanzamos al siguiente elemento.
        }
        
        //Mostramos los limites
        System.out.println("\nLimites: \n");
        System.out.println("LatExtNorte"+latExtNorte);
        System.out.println("LatExtSur"+latExtSur);
        System.out.println("lngExtEste"+lngExtEste);
        System.out.println("lngExtOeste"+lngExtOeste);
        
        /*if(generador.generarPlanillaConsolidados(nombreArchivoEscritura, fechaInicio, fechaTermino, m, n) == true){  //Se le pasaron fechas vacias para que no tire error.
            //Si es true no hay errores y se creo el archivo.
            System.out.println("El archivo " + generador.getNombreArchivoEcritura()+ " ha sido creado con exito.");
        }
        else {
            System.out.println("Error al crear el archivo.");
        }*/
    }
}
