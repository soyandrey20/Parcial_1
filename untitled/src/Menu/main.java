package Menu;

import java.lang.reflect.AccessibleObject;
import java.util.Map;
import java.util.Scanner;

public class main   {
    private  static Scanner scanner = new Scanner(System.in);
    private static final int OPCION_S=6;
    public static void main(String[] args) {
            int option =0;
        Map<Integer, Accion> strategy = AccionHandler.getStrategy();
        do{
            option = scanner.nextInt();
            scanner.nextLine();
            Accion accion = strategy.get(option);
            if(option == OPCION_S){
                continue;
            }
            if (accion == null){
                System.out.printf("Esta opcion no existe\n");
            }else {
                accion.aplicar();
            }
        }while (option != OPCION_S);
        System.out.println("Salida exitosa");

    }
}
