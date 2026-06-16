public class Direccion {
    private String calle;
    private String nomenclatura;
    private String barrio;
    private String ciudad;
    private String edificio;
    private String apto;
    
    public Direccion(){
        this.calle = "Desconocido";
        this.nomenclatura = "Desconocido";
        this.barrio= "Desconocido";
        this.ciudad = "Desconocido";
        this.edificio = "Desconocido";
        this.apto = "Desconocido";
    }
    
    public void setCalle(String calle){
        this.calle = calle;
    }
    public void setNomenclatura(String nomenclatura){
        this.nomenclatura = nomenclatura;
    }
    public void setBarrio(String barrio){
        this.barrio = barrio;
    }
    public void setCiudad(String ciudad){
        this.ciudad = ciudad;
    }
    public void setEdificio(String edificio){
        this.edificio = edificio;
    }
    public void setApto(String apto){
        this.apto = apto;
    }
    public String getCalle(){
        return this.calle;
    }
    public String getNomenclatura(){
        return this.nomenclatura;
    }
    public String getBarrio(){
        return this.barrio;
    }
    public String getCiudad(){
        return this.ciudad;
    }
    public String getEdificio(){
        return this.edificio;
    }
    public String getApto(){
        return this.apto;
    }
    public String toString(){
        return "Calle "+calle+" #"+nomenclatura+" "+barrio+"\nCiudad: "+ciudad+"\nEdificio: "+edificio+"\nApartamento: "+apto;
    }
    
}