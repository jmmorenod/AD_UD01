package Ej6;

import Ej6.modelo.Coche;
import Ej6.modelo.Persona;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Coche coche1 = new Coche("Seat", "Rojo");
        Coche coche2 = new Coche("Ford", "Azul");
        Coche coche3 = new Coche("Renault", "Verde");
        Coche coche4 = new Coche("Fiat", "Amarillo");
        Coche coche5 = new Coche("Opel", "Blanco");
        Coche coche6 = new Coche("Citroen", "Rojo");
        Coche coche7 = new Coche("Peugeot", "Azul");
        Coche coche8 = new Coche("Mercedes", "Verde");
        Coche coche9 = new Coche("BMW", "Amarillo");
        Coche coche10 = new Coche("Audi", "Blanco");
        Coche coche11 = new Coche("Volkswagen", "Rojo");
        Coche coche12 = new Coche("Toyota", "Azul");
        Coche coche13 = new Coche("Hyundai", "Verde");
        Coche coche14 = new Coche("Kia", "Amarillo");
        Coche coche15 = new Coche("Mazda", "Rojo");
        Coche coche16 = new Coche("Nissan", "Azul");
        Coche coche17 = new Coche("Honda", "Verde");
        Coche coche18 = new Coche("Suzuki", "Amarillo");
        Coche coche19 = new Coche("Mitsubishi", "Blanco");
        Coche coche20 = new Coche("Subaru", "Rojo");

        Persona persona1 = new Persona("Juan", List.of(coche1, coche2, coche3));
        Persona persona2 = new Persona("Pedro", List.of(coche4, coche5, coche6));
        Persona persona3 = new Persona("Maria", List.of(coche7, coche8, coche9));
        Persona persona4 = new Persona("Antonio", List.of(coche10, coche11, coche12));
        Persona persona5 = new Persona("Lucia", List.of(coche13, coche14, coche15));
        Persona persona6 = new Persona("Carlos", List.of(coche16, coche17, coche18));
        Persona persona7 = new Persona("Ana", List.of(coche19, coche20));

        List<Persona> personas = List.of(persona1, persona2, persona3, persona4, persona5, persona6, persona7);

        //Muestra la información de las personas que tiene un coche rojo
        List<String> personasConCocheRojo = personas.stream()
                .filter(persona -> persona.getCoches().stream().anyMatch(coche -> "Rojo".equals(coche.getColor())))
                .map(Persona::getNombre)
                .collect(Collectors.toList());

        System.out.println("Personas con coche rojo: " + personasConCocheRojo);

        //Personas con un coche Opel.
        List<String> personasConCocheOpel = personas.stream()
                .filter(persona -> persona.getCoches().stream().anyMatch(coche -> "Opel".equals(coche.getMarca())))
                .map(Persona::getNombre)
                .collect(Collectors.toList());
        System.out.println("Personas con coche Opel: " + personasConCocheOpel);

        //Encontrar a la persona con más coches
        Persona personaConMasCoches = personas.stream()
                .max((p1, p2) -> p1.getCoches().size() - p2.getCoches().size())
                .orElse(null);
        System.out.println("Persona con más coches: " + personaConMasCoches);



    }
}
