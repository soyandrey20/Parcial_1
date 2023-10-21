package accion;

import creacion.Juguete;
import menu.Main;
import creacion.Carrito;
import creacion.Peluche;

import java.util.*;

public class AccionEliminar implements Accion {
    private static final Scanner scanner = new Scanner(System.in);
    private int id;

    private List<Juguete> juguetes = new ArrayList<>();


    @Override
    public void aplicar() {

        boolean op;
        do {
            try {
                op = false;
                System.out.println("Id de el elemento a eliminar");
                id = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("digite solo valores numericos");
                op = true;
                scanner.nextLine();

            }
        } while (op);


        if (id < Main.getInstance().juguetes.size() && id >= 0) {

            Main.getInstance().juguetes.remove(id);
            System.out.println(" ____________________  \n" +
                    "|eliminacion exitosa | \n" +
                    "|____________________| \n");
        } else {

            System.out.println("el juguete no esta en la lista");

        }

        //comverir a list y luego a set

        for (int i = 0; i < Main.getInstance().juguetes.size(); i++) {


            juguetes = new ArrayList<>(Main.getInstance().juguetes);


            if (juguetes.get(i) instanceof Peluche) {

                Peluche peluche = (Peluche) juguetes.get(i);
                peluche.setId(i);


            } else {

                Carrito carrito = (Carrito) juguetes.get(i);
                carrito.setId(i);


            }

        }
        Main.getInstance().juguetes.addAll(Set.of((Juguete) juguetes));
    }

    @Override
    public int getOpcion() {
        return 3;
    }
}
