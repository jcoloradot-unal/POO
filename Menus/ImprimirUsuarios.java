package Menus;

import java.util.Scanner;

public class ImprimirUsuarios extends Menu{
    @Override
    public void iniciar(GestorMenus gestor) {
        Scanner sc = new Scanner(System.in);

        System.out.println(gestor.sistema.imprimirUsuarios());

        System.out.println("Ingrese cualquier tecla para salir");
        sc.next();

        gestor.cambiarMenu("Usuarios");
    }
}
