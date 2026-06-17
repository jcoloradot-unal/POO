public class UsuarioEmpresa extends Usuario{
    private int rol;
    private String contraseña;
    private Mensaje[] mensajesRecibidos;
    private Mensaje[] borradores;
    private int CantidadMensajes;
    private int CantidadBorradores;
        
    public UsuarioEmpresa(String nombre, long id, String contraseña, int rol){
        super(nombre, id);
        this.rol=rol;
        this.contraseña=contraseña;
        this.mensajesRecibidos=new Mensaje[50];
        this.borradores= new Mensaje[20];
        this.CantidadMensajes = 0;
        this.CantidadBorradores = 0;
        
        }
    public int getRol(){
        return this.rol;
    }
    public String getContraseña(){
        return this.contraseña;
    }
    
    
    public boolean modificarContraseña(String actual, String nueva){
        if (actual!=contraseña){
            return false;
        }
        else{
            contraseña=nueva;
            return true;
        }
    }  
    public boolean enviarMensaje(String MsgId){
        for(int i= 0;i<borradores.length; i++){
            if ((borradores[i]).getMensajeId()== MsgId){
                Mensaje msg = borradores[i];
                UsuarioEmpresa receptor = msg.getReceptor();    
                receptor.agregarMensajeRecibido(msg);
                for (int b=i; b<CantidadBorradores-1; b++)
                    borradores[b]=borradores[b+1];
                    borradores[CantidadBorradores-1]= null;
                    CantidadBorradores --;
                    return true;
            }
        }
        return false;
    }
    public void agregarMensajeRecibido (Mensaje msg){
        mensajesRecibidos [CantidadMensajes]= msg;
    }
    public void redactarMensaje (String cuerpo, String asunto, UsuarioEmpresa receptor){
        Mensaje msg = new Mensaje(asunto, cuerpo, getNombre(),receptor);
        borradores[CantidadBorradores]= msg;
    }
    public void editarMensaje (String mensajeId, String asunto, String cuerpo, UsuarioEmpresa receptor){
        int indice = 0;
        for(int i=0; i<CantidadBorradores; i++){
            if ((borradores[i]).getMensajeId()==mensajeId){
                indice = i;
                break;
            }
        }
        if (asunto!=""){
            (borradores[indice]).setAsunto(asunto);
        }
        if (cuerpo!=""){
            (borradores[indice]).setCuerpo(cuerpo);
        }
        if (receptor!=null){
            (borradores[indice]).setReceptor(receptor);
        }
    }
    
    private String imprimir(Mensaje[] lista){
        String impresion = "";
        for(int i=0; i<lista.length; i++ ){
            if(lista[i]==null){
                break;
            }
            else{
                impresion += (lista[i]).toString();
            }
        }
        return impresion;
    }
    public void imprimirMensajesRecibidos(){
        System.out.println(imprimir(mensajesRecibidos));
    }
    public void imprimirBorradores(){
        System.out.println(imprimir(borradores));
    }
    
}
