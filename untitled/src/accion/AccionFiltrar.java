package accion;

import creacion.Carrito;
import menu.Main;

import java.util.Comparator;

public class AccionFiltrar implements Accion {
    @Override
    public void aplicar() {

        Main.getInstance().juguetes.stream()
                .filter(juguete -> juguete instanceof Carrito)
                .max(Comparator.comparing(juguete -> ((Carrito) juguete).getRellenoPuer()))
                .ifPresentOrElse(juguete -> System.out.println("el juguete si esxite" + juguete),
                        () -> System.out.println("no hay carritos disponibless"));

    }

    @Override
    public int getOpcion() {
        return 6;
    }
}
