package accion;


import menu.Main;
import creacion.Juguete;
import utils.Impresion;

public class AccionVer implements Accion {


    @Override
    public void aplicar() {

        Impresion.impresion();
    }

    @Override
    public int getOpcion() {
        return 4;
    }
}
