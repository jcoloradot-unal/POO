public class Sistema {

    private UsuarioEmpresa usuarioActivo;
    private UsuarioEmpresa[] empleados;
    private int cantidadEmpleados;

    public Sistema() {
        this.usuarioActivo = null;
        this.empleados = new UsuarioEmpresa[100];
        this.cantidadEmpleados = 0;

        registrarUsuarioInicial("admin", "admin123", 1);

    }

    private void registrarUsuarioInicial(String nombreUsuario, String contrasena, int rol) {
        UsuarioEmpresa admin = new UsuarioEmpresa(nombreUsuario, contrasena, rol);
        this.empleados[this.cantidadEmpleados] = admin;
        this.cantidadEmpleados++;
    }


    public boolean ingresarSistema(String nombreUsuario, String contrasena) {
        for(int i = 0; i < this.cantidadEmpleados; i++) {
           UsuarioEmpresa emp=empleados[i];
           
           if(emp.getNombre().equals(nombreUsuario) && emp.getContrasena().equals(contrasena)) {
               this.usuarioActivo = emp;
               return true;
           }
        }
      return false;
}


    private boolean esAdmin() {
        if(this.usuarioActivo != null && this.usuarioActivo.getRol() == 1) {
            return true;
        }
        return false;

}

public boolean registrarUsuario(String nombreUsuario, String contrasena, int rol) {
    if(esAdmin()) {
        if(cantidadEmpleados < empleados.length) {
            UsuarioEmpresa nuevoUsuario = new UsuarioEmpresa(nombreUsuario, contrasena, rol);
            empleados[cantidadEmpleados] = nuevoUsuario;
            this.cantidadEmpleados++;
            return true;
        }else {
            System.out.println("No se pueden registrar más usuarios, capacidad máxima alcanzada.");
            return false;
        }
    }else {
        System.out.println("Solo el administrador puede registrar nuevos usuarios.");
        return false;
    }

}

public void EliminarUsuario(String idUsuario) {
    if(esAdmin()) {
        int posicion = -1;
        for(int i = 0; i < this.cantidadEmpleados; i++) {
            if(empleados[i].getId().equals(idUsuario)) {
                posicion = i;
                break;
            }
        }
        if(posicion != -1) {
            for(int i = posicion; i < this.cantidadEmpleados - 1; i++) {
                empleados[i] = empleados[i + 1];
            }
            empleados[this.cantidadEmpleados - 1] = null;
            this.cantidadEmpleados--;
            System.out.println("Usuario eliminado exitosamente.");
    }else {
            System.out.println("Usuario no encontrado.");
        }
    }else {
        System.out.println("Solo el administrador puede eliminar usuarios.");
    }
}

public UsuarioEmpresa buscarUsuario(String idUsuario) {
    for(int i = 0; i <cantidadEmpleados; i++) {
        if(empleados[i].getId().equals(idUsuario)) {
            return empleados[i];
        }
    }
    return null;
}

public String imprimirUsuarios() {
   if(esAdmin()) {
       String listado = "Usuarios registrados:\n";
       for(int i = 0; i <cantidadEmpleados; i++) {
           listado += "ID: " + empleados[i].getId() + ", | Nombre: " + empleados[i].getNombre()+ "\n";
       }
      return listado;
    }else {
         return "Solo el administrador puede ver la lista de usuarios.";

}
}
public void cerrarSesion() {
    this.usuarioActivo = null;
    System.out.println("Sesión cerrada exitosamente.");   
}
}