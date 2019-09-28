package controladores;

import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import modelo.ColeccionDespacho;
import modelo.Despacho;

/**
 *
 * @author 
 */
public class Lector {
    private ColeccionDespacho despachos;
    
    private FileInputStream fileStream;   // leer archivo excel
    private XSSFWorkbook workbook;        //obtener la hoja que se va leer
    private XSSFSheet sheet;              //obtener todas las filas de la hoja excel
        
    private double oeste;
    private double este;
    private double norte;
    private double sur;
    
    private final double latitudExtremoNorte= -91.000000;
    private final double latitudExtremoSur = 91.000000;
    private final double longitudExtremoEste= -181.000000;
    private final double longitudExtremoOeste= 181.00000;
    
    public Lector(File file) throws IOException {
        despachos = new ColeccionDespacho(); //Se instancia la coleccion.
       
        fileStream = new FileInputStream(file);
        workbook = new XSSFWorkbook(fileStream);
        sheet = workbook.getSheetAt(0);
    }
    
    public ColeccionDespacho generarListaDespachos(){
        Iterator<Row> rowIterator;
        Iterator<Cell> cellIterator; 
        Row row;
        Cell cell;
        
        rowIterator = sheet.iterator();
        rowIterator.next();  //Se salta la primera colummna ya que contiene los nombres de las filas.

        while( rowIterator.hasNext()){
            row = rowIterator.next();
            cellIterator = row.cellIterator();
            
            cell= cellIterator.next();
            int numeroDespacho= (int)cell.getNumericCellValue();

            cell= cellIterator.next();
            Date fechaIngreso= cell.getDateCellValue();

            cell= cellIterator.next();
            String ciudad= cell.getStringCellValue();

            cell= cellIterator.next();
            double longitud= cell.getNumericCellValue();

            if(longitud < longitudExtremoOeste){
                oeste= longitud;
            }
            
            if(longitud > longitudExtremoEste){
                este= longitud;
            }
     
            cell= cellIterator.next();
            double latitud= cell.getNumericCellValue();
            
            if(latitud < latitudExtremoSur){
                sur= latitud;
            }
                
            if(latitud > latitudExtremoNorte){
                norte= latitud;
            }
                
            cell= cellIterator.next();
            String codIso= cell.getStringCellValue();

            cellIterator.next();

            cell= cellIterator.next();
            int codProducto= (int)cell.getNumericCellValue();

            cell= cellIterator.next();
            String marca= cell.getStringCellValue();

            cell= cellIterator.next();
            String nomProducto= cell.getStringCellValue();

            cell= cellIterator.next();
            double formato= cell.getNumericCellValue();

            cell= cellIterator.next();
            int unidades= (int)cell.getNumericCellValue();

            cell= cellIterator.next();
            int valorDespacho= (int)cell.getNumericCellValue();

            cell= cellIterator.next();
            Date fechaEnvio= cell.getDateCellValue();

            Despacho nuevoDespacho = new Despacho (numeroDespacho, fechaIngreso, ciudad, longitud, latitud, codIso, codProducto, marca, nomProducto, formato, unidades, valorDespacho, fechaEnvio);
            despachos.agregarDespacho(nuevoDespacho);
        }
        
        return despachos;
    }
}
