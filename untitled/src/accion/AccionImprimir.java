package accion;


import creacion.Carrito;

import menu.Main;

import java.util.Comparator;


public class AccionImprimir implements Accion {



    @Override
    public void aplicar() {


        Main.getInstance().juguetes.stream()
                .filter(juguete -> juguete instanceof Carrito )
                .sorted(Comparator.comparing(juguete -> juguete.getId(), Comparator.reverseOrder()))
                .forEach(carrito -> System.out.println(carrito));







    }

    @Override
    public int getOpcion() {
        return 5;
    }
}
