package accion;


import creacion.*;
import menu.Main;
import utils.Kb;
import java.util.InputMismatchException;

public class AccionCrear implements Accion {

    private final CreadorCarrito creadorCarrito = new CreadorCarrito();
    private final CreadorPeluche creadorPeluche = new CreadorPeluche();
    private int op;

    @Override
    public void aplicar() {
        int validacion;
        do {
            try {
                validacion = 0;
                op = Kb.leerEntero(" _________________ \n" +
                        "| que desea crear |\n" +
                        "| 1. carrito      |\n" +
                        "| 2. peluche      |\n" +
                        "|_________________|\n");
                if (op >= 3 || op <= 0) {
                    System.out.println("Opcion no valida");
                    validacion = 1;
                }

            } catch (InputMismatchException e) {
                System.out.println("solo digite numeros");
                validacion = 1;
            }
        } while (validacion == 1);


        if (op == 1) {
            Carrito carrito = (Carrito) creadorCarrito.crear();
            Main.getInstance().juguetes.add(carrito);
            System.out.println("  __________________________ \n" +
                    " | Juguete creado con exito | \n" +
                    " |__________________________| \n");

        }
        if (op == 2) {
            Peluche peluche = (Peluche) creadorPeluche.crear();
            Main.getInstance().juguetes.add(peluche);
            System.out.println("  __________________________  \n" +
                    " | Juguete creado con exito | \n" +
                    " |__________________________| \n");

        }
    }

    @Override
    public int getOpcion() {
        return 1;
    }
}
