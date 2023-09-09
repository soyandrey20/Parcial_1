package Creacion;

import java.util.Scanner;

public class CreadorCarrito implements CreadorJuguete {
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public Juguete Crear() {
        System.out.println("ingrese el color del id");

        scanner.nextLine();
        int id = scanner.nextInt();

        System.out.println("ingrese el color del color");

        String color = scanner.nextLine();
        System.out.println("ingrese el color del marca");

        String  marca = scanner.nextLine();
        System.out.println("ingrese el color del puertas");
        scanner.nextLine();
        String puertas = scanner.nextLine();

        Carrito carrito = Carrito.builder()
                .id(id)
                .color(color)
                .marca(marca)
                .Puertas(puertas)
                .build();


        return new Carrito(id,color,marca,puertas);
    }

}


