package menu;

import accion.Accion;
import accion.AccionHandler;
import creacion.Juguete;

import java.util.*;

public class Main {
    private static Main instance;
    private static final Scanner scanner = new Scanner(System.in);
    private static final int OPCION_S = 5;
    public Set<Juguete> juguetes = new LinkedHashSet<>();

    private Main() {

    }

    public static Main getInstance() {
        if (instance == null) {
            instance = new Main();
        }
        return instance;
    }

    public void comenzar() {
        int option = 0;
        boolean opcion;
        Map<Integer, Accion> strategy = AccionHandler.getStrategy();

        do {
            do {


                try {
                    opcion = false;
                    System.out.println(" --------------------- \n" +
                            "| Que desea realizar  |\n" +
                            "|   1. crear          |\n" +
                            "|   2. clonar         |\n" +
                            "|   3. eliminar       |\n" +
                            "|   4. ver Todo       |\n" +
                            "|   5. imprimir       |\n"+
                            "|   6. filtrar        |\n" +
                            "|   7. convertir      |\n" +
                            "|   8. eliminar color |\n" +
                            "|   9. salir          |\n" +
                            "|_____________________|");
                    option = scanner.nextInt();

                    if (juguetes.isEmpty() && option != 1 && option !=9 ) {
                        System.out.println("lista vacia, no se puede hacer esta operacion");
                        opcion = true;
                    }

                } catch (InputMismatchException e) {
                    opcion = true;
                    System.out.println("Solo numeros validos ");
                    scanner.nextLine();
                }
            } while (opcion);


            Accion accion = strategy.get(option);

            if (option == OPCION_S) {
                continue;
            }

            if (accion == null) {
                System.out.print("Esta opcion no existe\n");
            } else {
                accion.aplicar();
            }

        } while (option != OPCION_S);
        System.out.println("Salida exitosa");

    }


}