package accion;

import creacion.Juguete;
import menu.Main;
import utils.ActualizarId;
import utils.Kb;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.stream.Collectors;

public class AccionEliminarC implements Accion {

    @Override
    public void aplicar() {

        int validacion, opcionColor = 0;

        String colorEliminar;

        Map<Integer, String> colorMapa = Main.getInstance().juguetes.stream()
                .collect(Collectors.toMap(Juguete::getId, Juguete::getColor));


        Map<String, Integer> colorMapas = colorMapa.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey, (existing, replacement) -> existing));

        colorMapas
                .forEach((id, color) -> System.out.println("color -> " + id + " id -> " + (color + 1)));

        do {
            try {

                validacion = 0;
                opcionColor = Kb.leerEntero("Digite el Id del color que desee eliminar");


            } catch (InputMismatchException ex) {

                System.out.println("Solo digite valores enteros");
                validacion = 1;

            }
        } while (validacion == 1);


        if (!colorMapas.containsValue(opcionColor - 1)) {
            System.out.println("Color fuera de la lista disponible");

        } else {
            colorEliminar = colorMapa.get(opcionColor - 1);
            Main.getInstance().juguetes = Main.getInstance().juguetes.stream()
                    .filter(juguete -> !juguete.getColor().equals(colorEliminar))
                    .collect(Collectors.toSet());

            System.out.println(" ____________________  \n" +
                    "|eliminacion exitosa | \n" +
                    "|____________________| \n");

            ActualizarId.actualizarStream();

        }


    }


    @Override
    public int getOpcion() {
        return 8;
    }
}
