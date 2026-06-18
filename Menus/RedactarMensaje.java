package Menus;

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
            gestor.sistema.getUsuarioActivo().redactarMensaje(cuerpo, asunto, destinatario);
            System.out.println("Mensaje guardado en BORRADORES exitosamente.");
        }
        
        System.out.println("\nIngrese cualquier letra y presione Enter para volver");
        sc.next();
        gestor.cambiarMenu("Mensajes");
    }
}