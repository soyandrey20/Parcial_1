package Creacion;

public class Carrito implements Juguete{
    private  int id;
    private String Color;
    private String marca;
    private String numeroPuertas;

    public Carrito (int id,String Color,String marca,String numeroPuertas) {
    this.id = id;
    this.Color = Color;
    this.marca = marca;
    this.numeroPuertas = numeroPuertas;

    }
    public static CarritoBuilder builder() {

        return new CarritoBuilder();
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getColor() {
        return null;
    }

    public static class CarritoBuilder {
        private  int id;
        private String Color;
        private String marca;
        private String numeroPuertas;

        public CarritoBuilder id(int id){
            this.id = id;
            return this;
        }
        public CarritoBuilder color(String color) {
            this.Color = color;
            return this;
        }

        public CarritoBuilder marca(String marca) {
            this.marca = marca;
            return this;
        }

        public CarritoBuilder Puertas(String numeroPuertas) {
            this.numeroPuertas = numeroPuertas;
            return this;
        }
        public Carrito build() {

            return new Carrito(id, Color, marca, numeroPuertas);

        }

    }

}
