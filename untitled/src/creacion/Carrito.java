package creacion;

import menu.Main;

public class Carrito implements Juguete {
    private int id;
    private String color;
    private String marca;
    private int numeroPuertas;

    public Carrito(int id, String Color, String marca, int numeroPuertas) {
        this.id = id;
        this.color = Color;
        this.marca = marca;
        this.numeroPuertas = numeroPuertas;

    }

    public void setId(int id) {
        this.id = id;
    }

    public static carritoBuilder builder() {



        return new carritoBuilder();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getColor() {
        return color;
    }


    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public static class carritoBuilder {
        private int id;
        private String color;
        private String marca;
        private int numeroPuertas;

        public carritoBuilder id(int id) {
            this.id = id;
            return this;
        }

        public carritoBuilder color(String color) {
            this.color = color;
            return this;
        }

        public carritoBuilder marca(String marca) {
            this.marca = marca;
            return this;
        }

        public carritoBuilder Puertas(int numeroPuertas) {
            this.numeroPuertas = numeroPuertas;
            return this;
        }

        public Carrito build() {

            return new Carrito(id, color, marca, numeroPuertas);

        }
    }

    @Override
    public String toString() {

        return String.format("%-5s | %-15s | %-15s | %-15s -> %-15s%n", "id", "color", "marca", "numero de puertas", "carrito") +
                String.format("%-5d | %-15s | %-15s | %-15s%n", (id + 1), color, marca, numeroPuertas);

    }

    public Carrito clone() {

        return new Carrito(Main.getInstance().juguetes.size(), color, marca, numeroPuertas);

    }
}
