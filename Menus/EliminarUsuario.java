package Menus;

public class EliminarUsuario extends Menu{
    @Override
    public void iniciar(GestorMenus gestor) {
        gestor.cambiarMenu("Menu Principal");
    }
}
