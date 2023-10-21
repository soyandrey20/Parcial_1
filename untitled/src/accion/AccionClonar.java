package accion;

import creacion.Juguete;
import menu.Main;
import creacion.Carrito;
import creacion.Peluche;

import java.util.*;

public class AccionClonar implements Accion {
    private static final Scanner scanner = new Scanner(System.in);
    private int clones, id;

    private List<Juguete> juguetes = new ArrayList<>();

    @Override
    public void aplicar() {
        boolean op;
        do {
            try {
                op = false;
                System.out.println("Id de el elemento a clonar");
                id = scanner.nextInt();

                System.out.println("cuantos clones quiere");
                clones = scanner.nextInt();

                if (id >= Main.getInstance().juguetes.size() || id < 0) {
                    System.out.println("objeto no disponible para clonacion");
                    op = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("por favor digite solo valores numericos");
                op = true;
                scanner.nextLine();

            }
        } while (op);

        juguetes = new ArrayList<>(Main.getInstance().juguetes);

        if (juguetes.get(id) instanceof Peluche) {
            Peluche peluche = (Peluche) juguetes.get(id);
            for (int i = 0; i < clones; i++) {
                Peluche peluche1 = peluche.clone();
                Main.getInstance().juguetes.add(peluche1);
            }
            System.out.println("  ______________________________  \n" +
                    " | Juguete clonado exitosamente | \n" +
                    " |______________________________| \n");

        } else {
            Carrito carrito = (Carrito) juguetes.get(id);
            for (int i = 0; i < clones; i++) {
                Carrito carrito1 = carrito.clone();
                Main.getInstance().juguetes.add(carrito1);
            }
            System.out.println("  ______________________________  \n" +
                    " | Juguete clonado exitosamente | \n" +
                    " |______________________________| \n");

        }

        Main.getInstance().juguetes.addAll(Set.of((Juguete) juguetes));
    }

    @Override
    public int getOpcion() {
        return 2;
    }
}
