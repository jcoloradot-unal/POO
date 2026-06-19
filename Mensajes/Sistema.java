package Mensajes;
public class Sistema {

    private UsuarioEmpresa usuarioActivo;
    private UsuarioEmpresa[] empleados;
    private int cantidadEmpleados;

    public Sistema() {
        this.usuarioActivo = null;
        this.empleados = new UsuarioEmpresa[100];
        this.cantidadEmpleados = 0;

        Fecha fecha1 = new Fecha(8,9,1991);
        Direccion dir1 = new Direccion();
        dir1.setCalle("15");
        dir1.setNomenclatura("22-61");
        dir1.setBarrio("Cuba");
        dir1.setCiudad("Pereira");

        registrarUsuario("admin", 0000, "0000", 1, fecha1, dir1, 300000000, "a@g.com");

        Fecha fecha2 = new Fecha(16,10,1987);
        Direccion dir2 = new Direccion();
        dir2.setCalle("48");
        dir2.setNomenclatura("22-61");
        dir2.setBarrio("Palermo");
        dir2.setCiudad("Manizales");
        dir2.setEdificio("El dorado");
        dir2.setApto("215");

        registrarUsuario("julian", 7841564, "123", 0, fecha2, dir2, 5325325, "f@ga.com");

        Fecha fecha3 = new Fecha(21,6,1996);
            Direccion dir3 = new Direccion();
                dir3.setCalle("43");
                dir3.setNomenclatura("33-11");
                dir3.setBarrio("Rodadero");
                dir3.setCiudad("Santa Marta");

        registrarUsuario("juan", 7841542, "123", 0, fecha3, dir3, 5325322, "g@ga.com");

        Fecha fecha4 = new Fecha (8,1,2008);
            Direccion dir4 = new Direccion();
                dir4.setCalle("77DD");
                dir4.setNomenclatura("85B-16");
                dir4.setBarrio("Robledo");
                dir4.setCiudad("Medellin");
        
        registrarUsuario("carlos", 784164, "profeteamo", 0, fecha4, dir4, 5325320, "h@ga.com");

        Fecha fecha5 = new Fecha(28,2,2001);
            Direccion dir5 = new Direccion();
                dir5.setCalle("45");
                dir5.setNomenclatura("55-23");
                dir5.setBarrio("San Antonio");
                dir5.setCiudad("Rionegro");
                dir5.setEdificio("Monaco");
                dir5.setApto("501");
        
        registrarUsuario("abelardito", 78413632, "eltigre", 0, fecha5, dir5, 53253654, "l@ga.com");

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

    public boolean registrarUsuario(String nombreUsuario,long id, String contrasena, int rol, Fecha fechaNacimiento, Direccion dirreccion, long telefono, String correo) {
        if(esAdmin() || usuarioActivo == null) {
            if(cantidadEmpleados < empleados.length) {
                // El nombre de usuario no se puede repetir
                for (int i = 0; i < cantidadEmpleados; i++) {
                    if ( empleados[i].getNombre().equals(nombreUsuario)) {
                        return  false;
                    }
                }

                UsuarioEmpresa nuevoUsuario = new UsuarioEmpresa(nombreUsuario, id, contrasena, rol);
                nuevoUsuario.setFechaNacimiento(fechaNacimiento);
                nuevoUsuario.setTel(311845229);
                nuevoUsuario.setEmail("laura@gmail.com");
                nuevoUsuario.setDir(dirreccion);
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