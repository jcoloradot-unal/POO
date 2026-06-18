package Menus;

import Mensajes.Mensaje;
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
        
        Mensaje msg = gestor.sistema.getUsuarioActivo().getMensaje(msgId);

        if (gestor.sistema.buscarUsuario(msg.getReceptor().getId()) == null) {
            System.out.println("El receptor ya no existe");
            gestor.cambiarMenu("Mensajes");
            return;
        }

        String resultado = gestor.sistema.getUsuarioActivo().enviarMensaje(msgId);
        
        if (resultado.equals("")) {
            System.out.println("¡El mensaje ha sido enviado correctamente!");
        } else {
            System.out.println(resultado);
        }
        
        System.out.println("\nIngrese cualquier letra y presione Enter para volver");
        sc.next();
        gestor.cambiarMenu("Mensajes");
    }
}