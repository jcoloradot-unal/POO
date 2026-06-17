package Menus;

public class RedactarMensaje extends Menu {
    @Override
    public void iniciar(GestorMenus gestor) {
        gestor.cambiarMenu("Menu Principal");
    }
}
