package utils;

import creacion.Juguete;
import menu.Main;

public class Impresion {
    public static void impresion() {

        for (Juguete juguete : Main.getInstance().juguetes) {
            System.out.print(juguete.toString());
        }

    }
}
