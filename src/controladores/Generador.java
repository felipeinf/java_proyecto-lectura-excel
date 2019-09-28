/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import modelo.Despacho;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

/**
 *
 * @author Pauli
 */
public class Generador {
    ArrayList<Despacho> despachos = new ArrayList<>();

    double oeste, este, norte, sur;
    double latitudExtremoNorte= -91.000000;
    double latitudExtremoSur = 91.000000;
    double longitudExtremoEste= -181.000000;
    double longitudExtremoOeste= 181.00000;
    
    
    public ArrayList<Despacho> generarListaDespachos(XSSFSheet sheet){
        Iterator<Row> rowIterator = sheet.iterator();

        Row row;
        Iterator<Cell> cellIterator;

        row = rowIterator.next();

        while (rowIterator.hasNext()) {
            row = rowIterator.next();

            cellIterator = row.cellIterator();
            Cell cell;


            cell= cellIterator.next();
            int numeroDespacho= (int)cell.getNumericCellValue();

            cell= cellIterator.next();
            Date fechaIngreso= cell.getDateCellValue();

            cell= cellIterator.next();
            String ciudad= cell.getStringCellValue();

            cell= cellIterator.next();
            double longitud= cell.getNumericCellValue();

            if(longitud< longitudExtremoOeste)
                oeste= longitud;
            if(longitud> longitudExtremoEste)
                este= longitud;

            cell= cellIterator.next();
            double latitud= cell.getNumericCellValue();
            if(latitud < latitudExtremoSur)
                sur= latitud;
            if(latitud > latitudExtremoNorte)
                norte= latitud;

            cell= cellIterator.next();
            String codIso= cell.getStringCellValue();

            cell= cellIterator.next();

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
            despachos.add(nuevoDespacho);
        }
        
        return despachos;
    }
}
