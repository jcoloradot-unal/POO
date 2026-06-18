package Menus;

import java.util.Scanner;

public class Autenticacion extends Menu {

    @Override
    public void iniciar(GestorMenus gestor) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese Usuario");
        String nombreUsuario = sc.next();
        System.out.println("Ingrese Contraseña");
        String contrasena = sc.next();

        //UsuarioEmpresa usuario = gestor.sistema.buscarUsuario(nombreUsuario);

        //if (usuario == null || !usuario.getContrasena().equals(contrasena)) {
        boolean exitoso = gestor.sistema.ingresarSistema(nombreUsuario, contrasena);
        if (!exitoso) {
            System.out.println("Usuario o contraseña incorrectos, por favor vuelva a intentar");
            gestor.cambiarMenu("Autenticacion");
        } else {
            System.out.println("Usuario autenticado correctamente!");
            gestor.cambiarMenu("Menu Principal");
        }

    }
}