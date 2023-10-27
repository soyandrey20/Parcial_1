package accion;

import creacion.Juguete;
import menu.Main;
import utils.ActualizarId;
import utils.Impresion;
import utils.Kb;

import java.util.*;

public class AccionEliminar implements Accion {
    private int id;
    private final List<Juguete> juguetes = new ArrayList<>(Main.getInstance().juguetes);


    @Override
    public void aplicar() {
        Impresion.impresion();

        int opcion;
        do {
            try {
                opcion = 0;
                id = Kb.leerEntero("Id de el elemento a eliminar");
            } catch (InputMismatchException e) {
                System.out.println("digite solo valores numericos");
                opcion = 1;


            }
        } while (opcion == 1);


        if (id <= Main.getInstance().juguetes.size() && id > 0) {


            Main.getInstance().juguetes.remove(juguetes.get(id-1));

            System.out.println(" ____________________  \n" +
                    "|eliminacion exitosa | \n" +
                    "|____________________| \n");
        } else {

            System.out.println("el juguete no esta en la lista");

        }
        ActualizarId.actualizarNormal();
    }

    @Override
    public int getOpcion() {
        return 3;
    }
}
