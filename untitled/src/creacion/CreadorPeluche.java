package creacion;

import menu.Main;


import java.util.InputMismatchException;
import java.util.Scanner;

public class CreadorPeluche implements CreadorJuguete {
    private static final Scanner scanner = new Scanner(System.in);

    private int id;
    private String material, color, relleno;

    @Override
    public Juguete Crear() {
        boolean op;
        do {
            try {
                op = false;


                id = Main.getInstance().juguetes.size();

                System.out.println("digite el material del peluche");
                material = scanner.next();

                System.out.println("digite el color del peluche");
                color = scanner.next();


                System.out.println("digite el relleno del peluche");
                relleno = scanner.next();


            } catch (InputMismatchException e) {
                System.out.println(" solo el numero de puertas se escriben en numero ");
                op = true;
                scanner.nextLine();
            }
        } while (op);


        Peluche peluche = Peluche.builder()
                .id(id)
                .color(color)
                .material(material)
                .relleno(relleno)
                .build();


        Main.getInstance().juguetes.add(peluche);
        return new Peluche(id, material, color, relleno);

    }
}
