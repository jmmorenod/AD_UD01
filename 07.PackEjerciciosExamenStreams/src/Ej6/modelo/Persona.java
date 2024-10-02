package Ej6.modelo;

import java.util.List;

public class Persona {
    String nombre;
List<Coche> coches;

    public Persona(String nombre, List<Coche> coches) {
        this.nombre = nombre;
        this.coches = coches;
    }
    public Persona() {
          }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Coche> getCoches() {
        return coches;
    }

    public void setCoches(List<Coche> coches) {
        this.coches = coches;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", coches=" + coches +
                '}';
    }
}
