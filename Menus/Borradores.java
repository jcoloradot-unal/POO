package Menus;

import java.util.Scanner;

public class Borradores extends Menu {
    @Override
    public void iniciar(GestorMenus gestor) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- TUS BORRADORES ---");
        
        gestor.sistema.getUsuarioActivo().imprimirBorradores();
        
        System.out.println("\nIngrese cualquier letra y presione Enter para volver");
        sc.next();
        
        gestor.cambiarMenu("Mensajes");
    }
}
