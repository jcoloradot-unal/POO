package Menus;

public class BandejaEntrada extends Menu {
    @Override
    public void iniciar(GestorMenus gestor) {
        gestor.cambiarMenu("Menu Principal");
    }
}
