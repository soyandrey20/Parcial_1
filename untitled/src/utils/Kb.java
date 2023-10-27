package utils;

import java.util.Scanner;

public class Kb {
    public static int leerEntero(String mensaje) {
        Scanner in = new Scanner(System.in);
        System.out.print(mensaje + "\n");
        return in.nextInt();
    }

    public static String leerTexto(String mensaje) {
        Scanner in = new Scanner(System.in);
        System.out.print(mensaje + "\n");
        return in.nextLine();
    }
}
