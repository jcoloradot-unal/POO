package Menus;

public class Borradores extends Menu {
    @Override
    public void iniciar(GestorMenus gestor) {
        gestor.cambiarMenu("Menu Principal");
    }
}
