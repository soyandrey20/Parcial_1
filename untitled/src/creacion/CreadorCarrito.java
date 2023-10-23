package creacion;

import menu.Main;
import utils.Kb;

import java.util.InputMismatchException;

public class CreadorCarrito implements CreadorJuguete {

    private int id;
    private int puertas;
    private String color, marca;


    @Override
    public Juguete crear() {

        int validacion;
        do {
            try {
                validacion = 0;

                id = Main.getInstance().juguetes.size();

                color = Kb.leerTexto("ingrese el color del carrito");

                marca = Kb.leerTexto("ingrese la marca del carrito");


                puertas = Kb.leerEntero("ingrese las puertas del carrito");

            } catch (InputMismatchException e) {
                System.out.println(" solo el numero de puertas se escriben en numero ");
                validacion = 1;

            }
        } while (validacion == 1);


        Carrito.builder()
                .id(id)
                .color(color)
                .marca(marca)
                .Puertas(puertas)
                .build();

        return new Carrito(id, color, marca, puertas);
    }


}


