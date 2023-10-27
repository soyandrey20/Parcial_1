package accion;

import creacion.Juguete;
import menu.Main;
import utils.ActualizarId;
import utils.Impresion;
import utils.Kb;
import java.util.*;

public class AccionClonar implements Accion {
    private int clones, id;
    private final List<Juguete> juguetes = new ArrayList<>(Main.getInstance().juguetes);

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

        Juguete jugueteClonar = juguetes.get(id - 1);

        for (int i = 0; i < clones; i++) {
            Juguete jugueteClonar1 = jugueteClonar.clone();
            Main.getInstance().juguetes.add(jugueteClonar1);
        }
        System.out.println("  ______________________________  \n" +
                " | Juguete clonado exitosamente | \n" +
                " |______________________________| \n");


        ActualizarId.actualizarNormal();
    }

    @Override
    public int getOpcion() {
        return 2;
    }
}
