package app.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Despacho 
{
    private int numeroDespacho;       
    private Date fechaIngreso;     
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
    private Date fechaEnvio; 

    SimpleDateFormat sdf;

    public Despacho(int numeroDespacho, Date fechaIngreso, String ciudad, double longitud, double latitud, String codIso, int codProducto, String marca, String nomProducto, double formato, int unidades, int valorDespacho, Date fechaEnvio) {
        sdf = new SimpleDateFormat("dd-MM-yyyy");
        
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

    public int getValorDespacho() {
        return valorDespacho;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setNumeroDespacho(int numeroDespacho) {
        this.numeroDespacho = numeroDespacho;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public void setCodIso(String codIso) {
        this.codIso = codIso;
    }

    public void setCodProducto(int codProducto) {
        this.codProducto = codProducto;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setNomProducto(String nomProducto) {
        this.nomProducto = nomProducto;
    }

    public void setFormato(double formato) {
        this.formato = formato;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public void setValorDespacho(int valorDespacho) {
        this.valorDespacho = valorDespacho;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
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
