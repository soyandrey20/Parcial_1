package accion;


import creacion.Carrito;
import creacion.Juguete;
import menu.Main;

import java.util.Map;
import java.util.stream.Collectors;

public class AccionConvertir implements Accion {


    @Override
    public void aplicar() {
        Main.getInstance().juguetes.stream()
                .collect(Collectors.toMap(juguetes -> juguetes.getId(), empleado -> empleado))
                .forEach((id, juguete) -> System.out.println("key->" + id + " value-> " + juguete));
    }

    @Override
    public int getOpcion() {
        return 7;
    }
}
