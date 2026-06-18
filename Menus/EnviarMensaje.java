package Menus;

import java.util.Scanner;

public class EnviarMensaje extends Menu {
    @Override
    public void iniciar(GestorMenus gestor) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\n--- ENVIAR MENSAJE ---");
        System.out.println("Estos son tus mensajes listos para enviar:\n");
        
        gestor.sistema.getUsuarioActivo().imprimirBorradores();
        
        System.out.println("\nIngrese el ID del mensaje que desea despachar:");
        String msgId = sc.nextLine();
        
        boolean exitoso = gestor.sistema.getUsuarioActivo().enviarMensaje(msgId);
        
        if (exitoso) {
            System.out.println("¡El mensaje ha sido enviado correctamente!");
        } else {
            System.out.println("Error: No se encontró ningún borrador con ese ID.");
        }
        
        System.out.println("\nIngrese cualquier letra y presione Enter para volver");
        sc.next();
        gestor.cambiarMenu("Mensajes");
    }
}