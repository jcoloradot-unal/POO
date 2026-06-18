package Mensajes;
public class Sistema {

    private UsuarioEmpresa usuarioActivo;
    private UsuarioEmpresa[] empleados;
    private int cantidadEmpleados;

    public Sistema() {
        this.usuarioActivo = null;
        this.empleados = new UsuarioEmpresa[100];
        this.cantidadEmpleados = 0;

        registrarUsuarioInicial("admin",45142, "123", 1);

    }

    public UsuarioEmpresa getUsuarioActivo() {
        return usuarioActivo;
    }

    private void registrarUsuarioInicial(String nombreUsuario,long id, String contrasena, int rol) {
        UsuarioEmpresa admin = new UsuarioEmpresa(nombreUsuario, id, contrasena, rol);
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

    public boolean esAdmin() {
        if(this.usuarioActivo != null && this.usuarioActivo.getRol() == 1) {
            return true;
        }
        
        return false;

    }

    public boolean registrarUsuario(String nombreUsuario,long id, String contrasena, int rol) {
        if(esAdmin()) {
            if(cantidadEmpleados < empleados.length) {
                // El nombre de usuario no se puede repetir
                for (int i = 0; i < cantidadEmpleados; i++) {
                    if ( empleados[i].getNombre().equals(nombreUsuario)) {
                        return  false;
                    }
                }

                UsuarioEmpresa nuevoUsuario = new UsuarioEmpresa(nombreUsuario, id, contrasena, rol);
                empleados[cantidadEmpleados] = nuevoUsuario;
                this.cantidadEmpleados++;
                return true;
            }else {
                System.out.println("No se pueden registrar más usuarios, capacidad máxima alcanzada.");
                return false;
            }
        }else {
            System.err.println("Solo el administrador puede registrar nuevos usuarios.");
            return false;
        }

    }

    public void eliminarUsuario(long idUsuario) {
        if(esAdmin()) {
            int posicion = -1;
            for(int i = 0; i < this.cantidadEmpleados; i++) {
                if(empleados[i].getId()==(idUsuario)) {
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

    public boolean eliminarUsuario(String nombreUsuario) {
        if(esAdmin()) {
            int posicion = -1;
            for(int i = 0; i < this.cantidadEmpleados; i++) {
                if(empleados[i].getNombre().equals(nombreUsuario)) {
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
                //System.out.println("Usuario eliminado exitosamente.");
                return true;
            } else {
                //System.out.println("Usuario no encontrado.");
                return false;
            }
        } else {
            System.err.println("Solo el administrador puede eliminar usuarios.");
            return false;
        }
    }

    public UsuarioEmpresa buscarUsuario(long idUsuario) {
        for(int i = 0; i <cantidadEmpleados; i++) {
            if(empleados[i].getId()==(idUsuario)) {
                return empleados[i];
            }
        }
        return null;
    }

    public UsuarioEmpresa buscarUsuario(String nombre) {
        for(int i = 0; i <cantidadEmpleados; i++) {
            if(empleados[i].getNombre().equals(nombre)) {
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