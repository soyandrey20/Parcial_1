package menu;

import accion.Accion;
import accion.AccionHandler;
import creacion.Juguete;

import java.util.*;

public class Main {
    private static Main instance;
    private static final Scanner scanner = new Scanner(System.in);
    private static final int OPCION_S = 5;
    public List<Juguete> juguetes = new ArrayList<>();

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
        boolean op;
        Map<Integer, Accion> strategy = AccionHandler.getStrategy();

        do {
            do {


                try {
                    op = false;
                    System.out.println(" -------------------- \n" +
                            "| Que desea realizar |\n" +
                            "|   1. crear         |\n" +
                            "|   2. clonar        |\n" +
                            "|   3. eliminar      |\n" +
                            "|   4. ver           |\n" +
                            "|   5. salir         |\n" +
                            "|____________________|");
                    option = scanner.nextInt();

                    if (juguetes.isEmpty() && option != 1 && option !=5 ) {
                        System.out.println("lista vacia, no se puede hacer esta operacion");
                        op = true;
                    }

                } catch (InputMismatchException e) {
                    op = true;
                    System.out.println("Solo numeros validos ");
                    scanner.nextLine();
                }
            } while (op);


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