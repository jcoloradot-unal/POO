package Menus;

import java.util.Scanner;

public class BandejaEntrada extends Menu {
    @Override
    public void iniciar(GestorMenus gestor) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- BANDEJA DE ENTRADA ---");
        
        gestor.sistema.getUsuarioActivo().imprimirMensajesRecibidos();
        
        System.out.println("\nIngrese cualquier letra y presione Enter para volver");
        sc.next();
        
        gestor.cambiarMenu("Mensajes");
    }
}
