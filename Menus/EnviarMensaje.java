package Menus;

public class EnviarMensaje extends Menu {
   @Override
    public void iniciar(GestorMenus gestor) {
        gestor.cambiarMenu("Menu Principal");
    } 
}
