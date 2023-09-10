package accion;

import menu.Main;
import creacion.Carrito;
import creacion.Peluche;

import java.util.Scanner;

public class AccionClonar implements Accion {
    private static final Scanner scanner = new Scanner(System.in);
    private int clones, id;

    @Override
    public void aplicar() {
        boolean op;
        do {
            try {
                op = false;
                System.out.println("Id de el elemento a clonar\n");
                id = scanner.nextInt();
                scanner.nextLine();

                System.out.println("cuantos clones quiere\n");
                clones = scanner.nextInt();
                scanner.nextLine();

            } catch (NumberFormatException e) {
                System.out.println("por favor digite solo valores numericos");
                op = true;
                scanner.nextLine();

            }
        } while (op);

        if (Main.getInstance().juguetes.get(id) instanceof Peluche) {
            Peluche peluche = (Peluche) Main.getInstance().juguetes.get(id);
            for (int i = 0; i < clones; i++) {
                Peluche peluche1 = peluche.clone();
                Main.getInstance().juguetes.add(peluche1);
            }

        } else {
            Carrito carrito = (Carrito) Main.getInstance().juguetes.get(id);
            for (int i = 0; i < clones; i++) {
                Carrito carrito1 = carrito.clone();
                Main.getInstance().juguetes.add(carrito1);
            }
        }
    }

    @Override
    public int getOpcion() {
        return 2;
    }
}
