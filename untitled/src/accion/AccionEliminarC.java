package accion;

import creacion.Carrito;
import creacion.Juguete;
import menu.Main;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class AccionEliminarC implements Accion {

    @Override
    public void aplicar() {


        Main.getInstance().juguetes.stream()
                .collect(juguete -> juguete.getColor()  )
                .collect(Collectors.toSet())
                .forEach(color -> System.out.println("id -> " + "color -> " + color ));


        String r = "rojo";

        List<Juguete> juguetesc = Main.getInstance().juguetes.stream()
                .filter(juguete -> juguete.getColor().equals(r));

        Main.getInstance().juguetes.addAll(Set.of())

    }
        Main.getInstance().juguetes.addAll(Set.of((Juguete) juguetes));


    @Override
    public int getOpcion() {
        return 8;
    }
}
