package Menus;

import Mensajes.Mensaje;
import Mensajes.UsuarioEmpresa;
import java.util.Scanner;

public class RedactarMensaje extends Menu {
    @Override
    public void iniciar(GestorMenus gestor) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\n--- REDACTAR MENSAJE ---");
        System.out.println("Ingrese el nombre exacto del destinatario:");
        String nombreDest = sc.nextLine();
        
        UsuarioEmpresa destinatario = gestor.sistema.buscarUsuario(nombreDest);
        
        if (destinatario == null) {
            System.out.println("Error: El usuario no existe en el sistema.");
        } else {
            System.out.println("Ingrese el asunto del mensaje:");
            String asunto = sc.nextLine();
            
            System.out.println("Ingrese el cuerpo del mensaje:");
            String cuerpo = sc.nextLine();

            // Se guarda en los borradores del usuario que tiene la sesión activa
            Mensaje msg = gestor.sistema.getUsuarioActivo().redactarMensaje(cuerpo, asunto, destinatario);
            
            System.out.println("Desea enviar el mensaje? (De lo contrario serà guardado en tus borradores) true/false");

            while (!sc.hasNextBoolean()) {    
                System.out.println("Por favor ingrese un valor valido true/false");
                sc.next();
            }

            boolean enviar = sc.nextBoolean();
            
            if (enviar) {
                String resultado = gestor.sistema.getUsuarioActivo().enviarMensaje(msg.getMensajeId());

                if (resultado.equals("")) {
                    System.out.println("¡El mensaje ha sido enviado correctamente!");
                } else {
                    System.out.println(resultado);
                }

            } else {
                System.out.println("Mensaje guardado en BORRADORES exitosamente.");                
            }

        }
        
        System.out.println("\nIngrese cualquier letra y presione Enter para volver");
        sc.next();
        gestor.cambiarMenu("Mensajes");
    }
}