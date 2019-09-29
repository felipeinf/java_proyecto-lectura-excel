package app.controladores;

import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import app.modelo.ColeccionDespacho;
import app.modelo.Despacho;

public class Lector {
    private final ColeccionDespacho despachos;
    
    final private FileInputStream fileStream;   
    final private XSSFWorkbook workbook;        
    final private XSSFSheet sheet;              
        
    private double oeste;
    private double este;
    private double norte;
    private double sur;
    
    private double latitudExtremoNorte;
    private double latitudExtremoSur;
    private double longitudExtremoEste;
    private double longitudExtremoOeste;
    
    public Lector(File file) throws IOException {
        despachos = new ColeccionDespacho(); //Se instancia la coleccion.
        fileStream = new FileInputStream(file);
        workbook = new XSSFWorkbook(fileStream);  // leer archivo excel
        sheet = workbook.getSheetAt(0); //obtener la hoja que se va leer

        //Aca seteamos los limites
        latitudExtremoNorte= -91.000000;
        latitudExtremoSur = 91.000000;
        longitudExtremoEste= -181.000000;
        longitudExtremoOeste= 181.00000;
    }

    public double getOeste() {
        return oeste;
    }

    public double getEste() {
        return este;
    }

    public double getNorte() {
        return norte;
    }

    public double getSur() {
        return sur;
    }

    public double getLatitudExtremoNorte() {
        return latitudExtremoNorte;
    }

    public void setLatitudExtremoNorte(double latitudExtremoNorte) {
        this.latitudExtremoNorte = latitudExtremoNorte;
    }

    public double getLatitudExtremoSur() {
        return latitudExtremoSur;
    }

    public void setLatitudExtremoSur(double latitudExtremoSur) {
        this.latitudExtremoSur = latitudExtremoSur;
    }

    public double getLongitudExtremoEste() {
        return longitudExtremoEste;
    }

    public void setLongitudExtremoEste(double longitudExtremoEste) {
        this.longitudExtremoEste = longitudExtremoEste;
    }

    public double getLongitudExtremoOeste() {
        return longitudExtremoOeste;
    }

    public void setLongitudExtremoOeste(double longitudExtremoOeste) {
        this.longitudExtremoOeste = longitudExtremoOeste;
    }
    
    public ColeccionDespacho generarListaDespachos(){
        Iterator<Row> rowIterator;
        Iterator<Cell> cellIterator; 
        Row row;
        Cell cell;
        
        rowIterator = sheet.iterator(); //obtener todas las filas de la hoja excel
        rowIterator.next();  //Se salta la primera fila ya que contiene los nombres de las columnas.

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
