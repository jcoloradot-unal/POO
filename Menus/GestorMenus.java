package Menus;

import Mensajes.Sistema;
import java.util.HashMap;
import java.util.Map;

public class GestorMenus {
    private Menu menuActual;
    private Map<String, Menu> menus = new HashMap<String, Menu>();
    public Sistema sistema = new Sistema();

    public GestorMenus() {
        agregarMenus();
    }
    
    public void cambiarMenu(String nombreMenu) {
        if (menuActual != null) {
            menuActual.detenerse();
        }
        menuActual = (Menu) menus.get(nombreMenu);
        menuActual.iniciar(this);
    }

    private void agregarMenus() {
        menus.put("Autenticacion", new Autenticacion());

        Menu menu = new Menu();
        menu.agregarOpciones(
            new String[] { "Usuarios", "Mensajes", "Cambiar Contrasena", "Cerrar Sesion" });
        menus.put("Menu Principal", menu);

        menu = new Menu();
        menu.agregarOpciones(
          new String[] { "Buscar Usuario", "Agregar Usuario_", "Eliminar Usuario_", "Imprimir Usuarios_", "Menu Principal" });
        menus.put("Usuarios", menu);

        menu = new Menu();
        menu.agregarOpciones(new String[] {"Bandeja de Entrada", "Redactar Mensaje", "Enviar Mensaje", "Borradores", "Editar Mensaje", "Menu Principal"});
        menus.put("Mensajes", menu);

        menus.put("Cambiar Contrasena", new CambiarContrasena());

        menus.put("Cerrar Sesion", new CerrarSesion());

        menus.put("Buscar Usuario", new BuscarUsuario());

        menus.put("Agregar Usuario_", new AgregarUsuario());

        menus.put("Eliminar Usuario_", new EliminarUsuario());

        menus.put("Imprimir Usuarios_", new ImprimirUsuarios());

        menus.put("Bandeja de Entrada", new BandejaEntrada());

        menus.put("Redactar Mensaje", new RedactarMensaje());

        menus.put("Enviar Mensaje", new EnviarMensaje());

        menus.put("Borradores", new Borradores());
        
        menus.put("Editar Mensaje", new EditarMensaje());
    }
}