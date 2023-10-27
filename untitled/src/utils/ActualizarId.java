package utils;

import creacion.Carrito;
import creacion.Juguete;
import creacion.Peluche;
import menu.Main;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ActualizarId {


    public static void actualizarNormal() {

        List<Juguete> listaJuguetes = new ArrayList<>(Main.getInstance().juguetes);

        for (int i = 0; i < Main.getInstance().juguetes.size(); i++) {
            if (listaJuguetes.get(i) instanceof Peluche) {
                Peluche peluche = (Peluche) listaJuguetes.get(i);
                peluche.setId(i);
            } else {
                Carrito carrito = (Carrito) listaJuguetes.get(i);
                carrito.setId(i);
            }
        }
        Main.getInstance().juguetes.addAll(new LinkedHashSet<>(listaJuguetes));

    }
    public static void actualizarStream(){

        List<Juguete> listaJuguete = Main.getInstance().juguetes.stream()
                .collect(Collectors.toList());

        IntStream.range(0, listaJuguete.size())
                .forEach(i -> {
                    Juguete juguete = listaJuguete.get(i);
                    if (juguete instanceof Peluche) {
                        ((Peluche) juguete).setId(i);
                    } else if (juguete instanceof Carrito) {
                        ((Carrito) juguete).setId(i);
                    }
                });

        Main.getInstance().juguetes.addAll(new LinkedHashSet<>(listaJuguete));

    }


}
