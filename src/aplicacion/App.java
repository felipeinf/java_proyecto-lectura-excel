/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import controladores.Generador;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import modelo.Despacho;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

 
/**
 *
 * @author Pauli
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String path = "merlina_legacy.xlsx";
        File file = new File(path);

        FileInputStream fileStream = new FileInputStream(file);
        // leer archivo excel
        XSSFWorkbook workbook = new XSSFWorkbook(fileStream);
        //obtener la hoja que se va leer
        XSSFSheet sheet = workbook.getSheetAt(0);
        //obtener todas las filas de la hoja excel
        
        Generador generador = new Generador();
        
        generador.generarListaDespachos(sheet).forEach((Despacho despacho) -> System.out.println(despacho.getNomProducto()));
    }
}
