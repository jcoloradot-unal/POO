package Menus;

import Mensajes.UsuarioEmpresa;
import java.util.Scanner;

public class BuscarUsuario extends Menu {
    @Override
    public void iniciar(GestorMenus gestor) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el nombre del usuario que desea buscar");
        String nombre = sc.next();

        UsuarioEmpresa usuario = gestor.sistema.buscarUsuario(nombre);

        if (usuario == null) {
            System.out.println("El usuario no fue encontrado");
        } else {
            System.out.println(usuario);
            System.out.println("Ingrese cualquier tecla para salir");
            sc.next();
        }

        gestor.cambiarMenu("Usuarios");
    }
}
