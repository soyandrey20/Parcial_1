package Creacion;

public class CreadorPeluche implements CreadorJuguete {

    @Override
    public Juguete Crear() {
        return new Peluche();
    }
}
