package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Despacho 
{
    SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");

    private int numeroDespacho;       //Verificar qué es una variable privada "final"
    private Date fechaIngreso;     //Verificar como utilizar atributos Date, por mientras se usa String para fechas
    private String ciudad;
    private double longitud;
    private double latitud;
    private String codIso;
    private int codProducto;
    private String marca;
    private String nomProducto;
    private double formato;
    private int unidades;
    private  int valorDespacho;
    public Date fechaEnvio; // La puse como "public" ya que una vez que se haga el envio se debe poner las fecha

   
    public Despacho(int numeroDespacho, Date fechaIngreso, String ciudad, double longitud, double latitud, String codIso, int codProducto, String marca, String nomProducto, double formato, int unidades, int valorDespacho, Date fechaEnvio) {
        this.numeroDespacho = numeroDespacho;
        this.fechaIngreso = fechaIngreso;
        this.ciudad = ciudad;
        this.longitud = longitud;
        this.latitud = latitud;
        this.codIso = codIso;
        this.codProducto = codProducto;
        this.marca = marca;
        this.nomProducto = nomProducto;
        this.formato = formato;
        this.unidades = unidades;
        this.valorDespacho = valorDespacho;
        this.fechaEnvio = fechaEnvio;
    }

    public int getNumeroDespacho() {
        return numeroDespacho;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public String getCiudad() {
        return ciudad;
    }

    public double getLongitud() {
        return longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public String getCodIso() {
        return codIso;
    }

    public int getCodProducto() {
        return codProducto;
    }

    public String getMarca() {
        return marca;
    }

    public String getNomProducto() {
        return nomProducto;
    }

    public double getFormato() {
        return formato;
    }

    public int getUnidades() {
        return unidades;
    }

  
    public int getValorDespacho() 
    {
        return valorDespacho;
    }

    public Date getFechaEnvio() 
    {
        return fechaEnvio;
    }

    
    public int localizarDespachoEnXFila(int n, double latitudExtremoNorte,  double largoAltura)
    {
      for (int i=0; i< n; i++)    
      {
          if(((((i*largoAltura)+ latitudExtremoNorte) < this.getLatitud())&& (((i+1)*largoAltura)+ latitudExtremoNorte)> this.getLatitud())||(Math.abs(this.getLatitud()- (i*largoAltura)+ latitudExtremoNorte)<0.0000011))
             return i;
      }
      return n;
    }
    
    public int localizarDespachoEnXColumna(int m,double longitudExtremoOeste, double largoBase)
    {
        for (int j=0; j< m; j++)
        {
            if(((this.getLongitud()>((j*largoBase) + longitudExtremoOeste)) && (this.getLongitud()<((j+1)*largoBase)+ longitudExtremoOeste)) || (Math.abs(this.getLongitud()-((j*largoBase)+longitudExtremoOeste))<0.000001))
            return j;
            
        }
        return m;
    }
    
}
