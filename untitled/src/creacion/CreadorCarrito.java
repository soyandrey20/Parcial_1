package creacion;

import menu.Main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CreadorCarrito implements CreadorJuguete {
    private static final Scanner scanner = new Scanner(System.in);
    private int id, puertas;
    private String color, marca;

    @Override
    public Juguete Crear() {
        boolean op;
        do {
            try {
                op = false;

                id = Main.getInstance().juguetes.size();

                System.out.println("ingrese el color del carrito");
                color = scanner.nextLine();

                System.out.println("ingrese la marca del carrito");
                marca = scanner.nextLine();

                System.out.println("ingrese las puertas del carrito");
                puertas = scanner.nextInt();

            } catch (InputMismatchException e) {
                System.out.println(" solo el numero de puertas se escriben en numero ");
                op = true;
                scanner.nextLine();
            }
        } while (op);


        Carrito carrito = Carrito.builder()
                .id(id)
                .color(color)
                .marca(marca)
                .Puertas(puertas)
                .build();
//sacar el de agregar
        Main.getInstance().juguetes.add(carrito);
        return new Carrito(id, color, marca, puertas);
    }


}


