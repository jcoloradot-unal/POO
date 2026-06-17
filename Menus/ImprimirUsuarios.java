package Menus;

public class ImprimirUsuarios extends Menu{
    @Override
    public void iniciar(GestorMenus gestor) {
        gestor.cambiarMenu("Menu Principal");
    }
}
