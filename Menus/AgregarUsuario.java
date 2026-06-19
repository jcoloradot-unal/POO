package Menus;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import Mensajes.Direccion;
import Mensajes.Fecha;

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
        
        System.out.println("Ingrese su dia de nacimiento:");
        int Dn = sc.nextInt();
        System.out.println("Ingrese su mes de nacimiento:");
        int Mn = sc.nextInt();
        System.out.println("Digite su año de nacimiento:");
        int An = sc.nextInt();
        sc.nextLine();
        
        Fecha fecha2 = new Fecha(Dn,Mn,An);
        
        System.out.println("Digite su ciudad de nacimiento:");
        String Cn = sc.nextLine();
        
        System.out.println("Digite su numero de telefono:");
        long Tel = sc.nextLong();
        
        sc.nextLine();
        
        System.out.println("Digite su email:");
        String Email = sc.nextLine();
        
        Direccion dir2= new Direccion();
        
        System.out.println("Vamos a digitar tu direccion.\nCalle:");
        String Cl = sc.nextLine();
        dir2.setCalle(Cl);
        
        System.out.println("Nomenclatura:");
        String Nm = sc.nextLine();
        dir2.setNomenclatura(Nm);
        
        System.out.println("Barrio:");
        String Br = sc.nextLine();
        dir2.setBarrio(Br);
        
        System.out.println("Ciudad:");
        String Cd = sc.nextLine();
        dir2.setCiudad(Cd);
        
        System.out.println("Edificio:");
        String Ed = sc.nextLine();
        dir2.setEdificio(Ed);
        
        System.out.println("Apartamento:");
        String Apto = sc.nextLine();
        dir2.setApto(Apto);
        
        boolean exitoso = gestor.sistema.registrarUsuario(nombre, id, contrasena, rol, fecha2, dir2, Tel, Email);

        if (exitoso) {
            System.out.println("Usuario registrado correctamente");
            gestor.cambiarMenu("Usuarios");
        } else {
            System.out.println("El nombre de usuario ya se encuentra registrado en el sistema. Intente otro nombre de usuario");

            gestor.cambiarMenu("Agregar Usuario_");
        }

    }
}
