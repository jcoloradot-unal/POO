package Menus;

import java.util.Scanner;

import Mensajes.Mensaje;
import Mensajes.UsuarioEmpresa;

public class EditarMensaje extends Menu {
    @Override
    public void iniciar(GestorMenus gestor) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n--- ENVIAR MENSAJE ---");
        System.out.println("Estos son tus mensajes listos para enviar:\n");
        
        gestor.sistema.getUsuarioActivo().imprimirBorradores();

        System.out.println("Ingrese el id del mensaje que desea editar");
        String id = sc.nextLine();

        Mensaje msg = gestor.sistema.getUsuarioActivo().getMensaje(id);

        if (msg == null) {
            System.out.println("El mensaje especificado no existe");
            gestor.cambiarMenu("Mensajes");
            return;
        }

        System.out.println("Deje el campo vacio si no desea editarlo");

        System.out.println("Nuevo asunto:");
        String asunto = sc.nextLine();

        System.out.println("Nuevo cuerpo:");
        String cuerpo = sc.nextLine();

        System.out.println("Nuevo receptor (ingrese el nombre del receptor):");
        String nombreReceptor = sc.nextLine();
        UsuarioEmpresa receptor = gestor.sistema.buscarUsuario(nombreReceptor);

        if (receptor == null && !nombreReceptor.equals("")) {
            System.out.println("El receptor especificado no existe");
            gestor.cambiarMenu("Mensajes");
            return;
        } else {
            gestor.sistema.getUsuarioActivo().editarMensaje(id, asunto, cuerpo,receptor);
            System.out.println("El mensaje ha sido modificado correctamente");
            gestor.cambiarMenu("Mensajes");
        }
    }
}