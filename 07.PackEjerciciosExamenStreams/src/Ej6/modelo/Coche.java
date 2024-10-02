package Ej6.modelo;

public class Coche {
    String marca;
    String color;

    public Coche() {
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Coche(String marca, String color) {
        this.marca = marca;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "marca='" + marca + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

}
