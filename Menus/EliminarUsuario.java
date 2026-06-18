package Menus;

import java.util.Scanner;

public class EliminarUsuario extends Menu{
    @Override
    public void iniciar(GestorMenus gestor) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el nombre del usuario que desea eliminar");
        String nombre = sc.next();

        if (gestor.sistema.getUsuarioActivo().getNombre().equals(nombre)) {
            System.out.println("No puede eliminar el usuario al cual pertenece la sesiòn actual");
            gestor.cambiarMenu("Usuarios");
            return;
        }

        boolean exitoso = gestor.sistema.eliminarUsuario(nombre);

        if (exitoso) {
            System.out.println("Usuario " + nombre + " eliminado correctamente");
        } else {
            System.out.println("El usuario especificado no existe");
        }

        gestor.cambiarMenu("Usuarios");
    }
}
