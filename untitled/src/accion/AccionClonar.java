package accion;

import creacion.Juguete;
import menu.Main;
import creacion.Carrito;
import creacion.Peluche;
import utils.ActualizarId;
import utils.Impresion;
import utils.Kb;

import java.util.*;

public class AccionClonar implements Accion {
    private int clones, id;

    @Override
    public void aplicar() {
        int validacion;
        Impresion.impresion();
        do {
            try {
                validacion = 0;

                id = Kb.leerEntero("Id de el elemento a clonar");

                clones = Kb.leerEntero("cuantos clones quiere");

                if (id > Main.getInstance().juguetes.size() || id <= 0) {
                    System.out.println("objeto no disponible para clonacion");
                    validacion = 1;
                }
            } catch (InputMismatchException e) {
                System.out.println("por favor digite solo valores numericos");
                validacion = 1;

            }
        } while (validacion == 1);

        List<Juguete> juguetes = new ArrayList<>(Main.getInstance().juguetes);

        if (juguetes.get(id - 1) instanceof Peluche) {
            Peluche peluche = (Peluche) juguetes.get(id - 1);
            for (int i = 0; i < clones; i++) {
                Peluche peluche1 = peluche.clone();
                Main.getInstance().juguetes.add(peluche1);
            }
            System.out.println("  ______________________________  \n" +
                    " | Juguete clonado exitosamente | \n" +
                    " |______________________________| \n");

        } else {
            Carrito carrito = (Carrito) juguetes.get(id - 1);
            for (int i = 0; i < clones; i++) {
                Carrito carrito1 = carrito.clone();
                Main.getInstance().juguetes.add(carrito1);
            }
            System.out.println("  ______________________________  \n" +
                    " | Juguete clonado exitosamente | \n" +
                    " |______________________________| \n");

        }

        ActualizarId.actualizarNormal();
    }

    @Override
    public int getOpcion() {
        return 2;
    }
}
