package accion;


import menu.Main;
import creacion.Juguete;

public class AccionVer implements Accion {


    @Override
    public void aplicar() {

        for (Juguete juguete : Main.getInstance().juguetes) {
            System.out.print(juguete.toString());
        }
    }

    @Override
    public int getOpcion() {
        return 4;
    }
}
