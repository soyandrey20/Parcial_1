package creacion;

import menu.Main;
import utils.Kb;


import java.util.InputMismatchException;

public class CreadorPeluche implements CreadorJuguete {

    private int id;
    private String material, color, relleno;

    @Override
    public Juguete crear() {
        int validacion;
        do {
            try {
                validacion = 0;


                id = Main.getInstance().juguetes.size();

                material = Kb.leerTexto("digite el material del peluche");

                color = Kb.leerTexto("digite el color del peluche");


                relleno = Kb.leerTexto("digite el relleno del peluche");


            } catch (InputMismatchException e) {
                System.out.println(" solo el numero de puertas se escriben en numero ");
                validacion = 1;

            }
        } while (validacion == 1);


        Peluche.builder()
                .id(id)
                .color(color)
                .material(material)
                .relleno(relleno)
                .build();

        return new Peluche(id, material, color, relleno);

    }
}
