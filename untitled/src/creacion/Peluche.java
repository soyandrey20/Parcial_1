package creacion;

import menu.Main;

public class Peluche implements Juguete {
    private String  relleno;
    private String material;
    private String color;

    private int id;

    public Peluche(int id, String material, String color, String relleno) {
        this.relleno = relleno;
        this.material = material;
        this.color = color;
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static PelucheBuilder builder() {

        return new PelucheBuilder();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getColor() {
        return color;
    }


    public static class PelucheBuilder {
        private String relleno;
        private String material;
        private String color;

        private int id;

        public PelucheBuilder id(int id) {
            this.id = id;
            return this;
        }

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

        public Peluche build() {
            return new Peluche(id, material, color, relleno);

        }
    }

    @Override
    public String toString() {
        return String.format("%-5s | %-15s | %-15s | %-15s -> %-15s%n", "id", "color", "material", "relleno", "peluche") +
                String.format("%-5d | %-15s | %-15s | %-15s%n", (id+1), color, material, relleno);

    }

    public Peluche clone() {
        return new Peluche(Main.getInstance().juguetes.size(), material, color, relleno);
    }

}
