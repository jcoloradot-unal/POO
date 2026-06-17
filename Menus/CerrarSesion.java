package Menus;

public class CerrarSesion extends Menu {
    @Override
    public void iniciar(GestorMenus gestor) {
        gestor.sistema.cerrarSesion();
        gestor.cambiarMenu("Autenticacion");
    }
    
}
