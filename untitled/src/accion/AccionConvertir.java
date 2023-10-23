package accion;

import menu.Main;
import java.util.stream.Collectors;

public class AccionConvertir implements Accion {


    @Override
    public void aplicar() {
        Main.getInstance().juguetes.stream()
                .collect(Collectors.toMap(juguetes -> juguetes.getId(), juguetes -> juguetes))
                .forEach((id, juguete) -> System.out.println("key-> " + (id+1) + "\n" + juguete));
    }

    @Override
    public int getOpcion() {
        return 7;
    }
}
