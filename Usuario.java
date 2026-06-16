public class Usuario {
    private String nombre;
    private long id;
    private Fecha fecha_nacimiento;
    private String ciudad_nacimiento;
    private long tel;
    private String email;
    private Direccion dir;
    
    public Usuario(){};
    public Usuario(String nombre, long id){
        this.nombre = nombre;
        this.id = id;
    };
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setId(long id){
        this.id = id;
    }
    public void setFechaNacimiento(Fecha fecha_nacimiento){
        this.fecha_nacimiento = fecha_nacimiento;
    }
    public void setCiudadNacimiento(String ciudad_nacimiento){
        this.ciudad_nacimiento = ciudad_nacimiento;
    }
    public void setTel(long tel){
        this.tel = tel;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setDir(Direccion dir){
        this.dir = dir;
    }
    public String getNombre(){
        return this.nombre;
    }
    public long getId(){
        return this.id;
    }
    public Fecha getFechaNacimiento(){
        return this.fecha_nacimiento;
    }
    public String getCiudad(){
        return this.ciudad_nacimiento;
    }
    public long getTel(){
        return this.tel;
    }
    public String getEmail(){
        return this.email;
    }
    public Direccion getDir(){
        return this.dir;
    }
    public String toString(){
        return "Nombre:"+nombre+"\nId:"+id+"\nFecha de nacimiento:"+fecha_nacimiento+"\nCiudad de nacimiento:"+ciudad_nacimiento+"\nTelefono:"+tel+"\nEmail:"+email+"\nDireccion:\n"+dir;
    }    
}
