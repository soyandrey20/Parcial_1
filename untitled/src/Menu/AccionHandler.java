package Menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccionHandler {
    private  AccionHandler(){

    }
    private  static final List<Accion> listaDeJuguetes =
            List.of(new AccionCrear(),
            new AccionClonar(),
            new AccionEliminar(),
            new AccionVer());

    public  static Map<Integer,Accion> getStrategy(){
        Map<Integer,Accion> strategy = new HashMap<>();
        for (Accion accion : listaDeJuguetes){
            strategy.put(accion.getOpcion(),accion);
        }
        return strategy;
    }
}
