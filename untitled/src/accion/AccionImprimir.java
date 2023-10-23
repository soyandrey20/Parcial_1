package accion;


import creacion.Carrito;
import creacion.Juguete;
import creacion.Peluche;
import menu.Main;
import utils.Kb;

import java.util.Comparator;
import java.util.InputMismatchException;


public class AccionImprimir implements Accion {


    @Override
    public void aplicar() {
        int validacion, opcion = 0;
        do {
            try {
                validacion = 0;

                opcion = Kb.leerEntero("|---------------------|\n" +
                        "| Que desea imprimir  |\n" +
                        "| 1. carritos         |\n" +
                        "| 2. peluches         |\n" +
                        "|---------------------|\n");
                if (opcion > 2 || opcion < 1) {
                    System.out.println("opcion no disponible");
                    validacion = 1;
                }

            } catch (InputMismatchException e) {
                System.out.println("Solo se permiten numeros");
                validacion = 1;
            }
        } while (validacion == 1);


        if (opcion == 1) {
            Main.getInstance().juguetes.stream()
                    .filter(juguete -> juguete instanceof Carrito)
                    .sorted(Comparator.comparing(Juguete::getId, Comparator.reverseOrder()))
                    .forEach(System.out::println);

        } else {
            Main.getInstance().juguetes.stream()
                    .filter(juguete -> juguete instanceof Peluche)
                    .sorted(Comparator.comparing(Juguete::getId, Comparator.reverseOrder()))
                    .forEach(System.out::println);
        }



    }

    @Override
    public int getOpcion() {
        return 5;
    }
}
