package Menus;

import java.util.Scanner;

public class CambiarContrasena extends Menu {

    @Override
    public void iniciar(GestorMenus gestor) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese la contraseña actual");
        String actual = sc.nextLine();
        System.out.println("Ingrese la nueva contraseña");
        String nueva = sc.nextLine();

        boolean exitoso = gestor.sistema.getUsuarioActivo().modificarContraseña(actual, nueva);

        if (!exitoso) {
            System.out.println("La contraseña actual es incorrecta");
            gestor.cambiarMenu("Menu Principal");
        }

        System.out.println("La contraseña ha sido modificada correctamente");

        gestor.cambiarMenu("Menu Principal");
    }
}
