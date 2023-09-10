package accion;


import creacion.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AccionCrear implements Accion {

    private final CreadorCarrito creadorCarrito = new CreadorCarrito();
    private final CreadorPeluche creadorPeluche = new CreadorPeluche();
    private static final Scanner scanner = new Scanner(System.in);
    private int op;

    @Override
    public void aplicar() {
        boolean opp;
        do {
            try {
                opp = false;
                System.out.println(" _________________ \n"  +
                                   "| que desea crear |\n" +
                                   "| 1. carrito      |\n" +
                                   "| 2. peluche      |\n" +
                                   "|_________________|\n");
                op = scanner.nextInt();
                if(op >= 3 || op <=0){
                    System.out.println("Opcion no valida");
                    opp = true;
                }

            } catch (InputMismatchException e) {
                System.out.println("solo digite numeros");
                opp = true;
                scanner.nextLine();
            }
        } while (opp);


        if (op == 1) {
            creadorCarrito.Crear();
        }
        if (op == 2) {
            creadorPeluche.Crear();

        }

    }

    @Override
    public int getOpcion() {
        return 1;
    }
}
