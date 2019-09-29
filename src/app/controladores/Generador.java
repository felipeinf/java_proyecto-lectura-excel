package app.controladores;

import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import app.modelo.ColeccionDespacho;
import app.modelo.ConsolidadoDespachos;
import java.io.FileNotFoundException;

public class Generador {
    final private ColeccionDespacho despachos;  // Son final ya que una vez que se instancia el generador estos datos no cambian.
    
    private ConsolidadoDespachos consolidados;
    private String nombreArchivoEscritura;

    public Generador(ColeccionDespacho despachos) {
        this.despachos = despachos;
    }

    public String getNombreArchivoEcritura(){
        return nombreArchivoEscritura;
    }
    
    private void setNombreArchivoEscritura(String nombreArchivoEscritura){
        this.nombreArchivoEscritura = nombreArchivoEscritura + ".xlsx";
    }
    
    public ConsolidadoDespachos generarConsolidados(String nombreArchivoEscritura, Date fechaInicio, Date fechaLimite, int m, int n){
        setNombreArchivoEscritura(nombreArchivoEscritura); //Aca se almacena el nombre del archivo.
        
        /*
            Aca hay que recorrer [despachos], crear el Consolidado con las especificaciones y retornarlo.
        */
        while(despachos.finalDeLista() == false){
            
        }
       
        return new ConsolidadoDespachos(); //Esto esta por mientras para que no tire error.
    }
    
    public Boolean generarPlanillaConsolidados(String nombreArchivoEscritura, Date fechaInicio, Date fechaLimite, int m, int n){
        File archivo;
        Workbook workbook;
        Sheet sheet;
        ConsolidadoDespachos consolidados;

        consolidados = generarConsolidados(nombreArchivoEscritura, fechaInicio, fechaLimite, m, n);
        archivo = new File(nombreArchivoEscritura);
        workbook = new XSSFWorkbook(); // Creamos el libro de Excel.
        sheet = workbook.createSheet("Consolidado de despachos"); // Creamos la hoja.

        /*
        
            Aca tienes que recorrer [consolidados], crear las filas y columnas.
        
        */

        try {
            FileOutputStream outputStream = new FileOutputStream(archivo); // Creamos el stream de salida.
            workbook.write(outputStream); // Almacenamos los datos en stream de salida, se supone que el workbook ya tiene todo lo que añadiste.  
            workbook.close(); // Cerramos el libro para concluir operaciones
            return true;
        } 
        catch (FileNotFoundException fileNotFoundExeption) {  //Si hay un problema con el arhivo.
            System.err.println(fileNotFoundExeption); // Se muestra el error en consola.
            return false;
        } 
        catch (IOException inputOuputExeption) {  //Si hay un problema con el stream de datos.
            System.err.println(inputOuputExeption); // Se muestra el error en consola.
            return false;
        }
    }
}
