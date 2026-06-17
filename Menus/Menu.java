package Menus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Menu {
    protected GestorMenus gestor;
    private ArrayList<String> opciones = new ArrayList<>();
    private ArrayList<String> opcionesValidas = new ArrayList<>();
    
    public Menu() { }
    
    public void iniciar(GestorMenus gestor) {
        if (!opciones.isEmpty()) {
            this.gestor = gestor;

            if (gestor.sistema.esAdmin()) {
                opcionesValidas = new ArrayList<>(opciones);
            } else {
                opcionesValidas.clear();


                System.out.println(opciones.size());

                for (int i=0; i<opciones.size();i++) {
                    if (opciones.get(i).contains("_")) {
                        continue;
                    }

                    opcionesValidas.add(opciones.get(i));
                }
            }

            iniciarSeleccion();
        }
    }
    
    public void detenerse() {
        
    }
    
    public void agregarOpciones(String[] opciones) {
        Collections.addAll(this.opciones, opciones);
    }
    
    private void iniciarSeleccion() {
        System.out.println("Ingresa una opciòn:");
        
        // Creado para evitar que cuando una opcion no se pueda mostrar por el tipo de rol, no se salte las opciones
        int indiceOpcion = 1;
        // Imprime una opciòn para cada uno de las opciones almacenadas en la lista
        for (int i=0; i < opcionesValidas.size(); i++) {
            String opcion = (String) opcionesValidas.get(i);
            // "_" es el identificador de una opciòn solo para admins
            if (opcion.contains("_") && !gestor.sistema.esAdmin()) {
                continue;
            }

            System.out.println((indiceOpcion) + ". " + opcion);
            indiceOpcion++;
        }
        
        Scanner sc = new Scanner(System.in);
        
        int input = sc.nextInt();
        
        if (input > 0 && input <= opcionesValidas.size()) {
            gestor.cambiarMenu((String) opcionesValidas.get(input - 1));
        }

        sc.close();
    }
}