package Menus;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class AgregarUsuario extends Menu {

    @Override
    public void iniciar(GestorMenus gestor) {
        Scanner sc = new Scanner(System.in);

        long id = ThreadLocalRandom.current().nextLong(99999L);

        System.out.println("Ingrese nombre de usuario para el usuario que desea crear");
        String nombre = sc.next();

        System.out.println("Ingrese una contraseña");
        String contrasena = sc.next();

        System.out.println("Es Administrador? true/false");
        while (!sc.hasNextBoolean()) {    
            System.out.println("Por favor ingrese un valor valido true/false");
            sc.next();

        }
        boolean esAdmin = sc.nextBoolean();
        int rol = 0;

        if (esAdmin) {
            rol = 1;
        }

        gestor.sistema.registrarUsuario(nombre, id, contrasena, rol);

        System.out.println("Usuario registrado correctamente");
        gestor.cambiarMenu("Usuarios");
    }
}
