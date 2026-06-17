import java.util.Scanner;

public class Menu {
    private Sistema sistema;
    private Scanner sc;
    private UsuarioEmpresa[] empleados;

    public Menu (Sistema sistema){
        this.sistema= sistema;
        this.sc = new Scanner(System.in);
        this.empleados=sistema.getEmpleados();
    }
    public void iniciarSesion(){
        while(true){
        System.out.println("===Inicie sesion==\nDigite su nombre:");
        String nombre = sc.nextLine();
        System.out.println("Digite su contraseña:");
        String contraseña = sc.nextLine();
        boolean verificador = sistema.ingresarSistema(nombre, contraseña);
        if (verificador){menu();    break;}
        else{System.out.println("No fue posible iniciar sesion :(, vuelva a intentarlo");   continue;}
        }
    }
    public void menu(){

    }
    
}
