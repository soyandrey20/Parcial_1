package Creacion;

public class Peluche implements Juguete {


    public static PelucheBuilder builder() {
        return new PelucheBuilder();
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getColor() {
        return null;
    }

    public static class PelucheBuilder {
        private String relleno;
        private String material;
        private String color;

        public PelucheBuilder relleno(String relleno) {
            this.relleno = relleno;
            return this;
        }

        public PelucheBuilder material(String material) {
            this.material = material;
            return this;
        }

        public PelucheBuilder color(String color) {
            this.color = color;
            return this;
        }


    }

}
