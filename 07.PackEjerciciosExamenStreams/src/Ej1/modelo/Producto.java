package Ej1.modelo;

public class Producto {

    int id;
    String nombre;
    double precio;
    boolean descuento;
    char tipo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isDescuento() {
        return descuento;
    }

    public void setDescuento(boolean descuento) {
        this.descuento = descuento;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", descuento=" + descuento +
                ", tipo=" + tipo +
                '}';
    }

    public Producto() {
    }

    public Producto(int id, String nombre, double precio, boolean descuento, char tipo) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.descuento = descuento;
        this.tipo = tipo;
    }
}
