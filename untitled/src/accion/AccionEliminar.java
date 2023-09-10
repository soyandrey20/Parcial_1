package accion;

import menu.Main;
import creacion.Carrito;
import creacion.Peluche;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AccionEliminar implements Accion {
    private static final Scanner scanner = new Scanner(System.in);
    private int id;

    @Override
    public void aplicar() {

        boolean op;
        do {
            try {
                System.out.println("Id de el elemento a eliminar\n");
                id = scanner.nextInt();
                scanner.nextLine();
                op = false;
            }catch (InputMismatchException e){
                System.out.println("digite solo valores numericos");
                op = true;
            }
        }while (op);


        if (id <= Main.getInstance().juguetes.size()) {

            Main.getInstance().juguetes.remove(id);

        } else {

            System.out.println("el juguete no esta en la lista");

        }

        for (int i = 0; i < Main.getInstance().juguetes.size(); i++) {

            if (Main.getInstance().juguetes.get(i) instanceof Peluche) {

                Peluche peluche = (Peluche) Main.getInstance().juguetes.get(i);
                peluche.setId(i);

            } else {

                Carrito carrito = (Carrito) Main.getInstance().juguetes.get(i);
                carrito.setId(i);
            }
        }
    }

    @Override
    public int getOpcion() {
        return 3;
    }
}
