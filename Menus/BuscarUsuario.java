package Menus;

public class BuscarUsuario extends Menu {
    @Override
    public void iniciar(GestorMenus gestor) {
        gestor.cambiarMenu("Menu Principal");
    }
}
