import java.util.List;

public class Ej04 {
    public static void main(String[] args) {
        Persona persona1 = new Persona("Juan", 25);
        Persona persona2 = new Persona("Pedro", 30);
        Persona persona3 = new Persona("Ana", 20);
        Persona persona4 = new Persona("Maria", 28);
        Persona persona5 = new Persona("Juan Antonio", 23);
        Persona persona6 = new Persona("Pedro", 31);
        Persona persona7 = new Persona("Luisa", 68);
        Persona persona8 = new Persona("Josefina", 70);
        List<Persona> personas = List.of(persona1, persona2, persona3, persona4, persona5, persona6, persona7, persona8);

        // Imprimimos la lista de personas por edad de forma descendente
        personas.stream()
                .sorted((p1, p2) -> p2.getEdad() - p1.getEdad())
                .forEach(System.out::println);
        System.out.println("---------------------------------------------------");
        // Imprimimos la lista de personas por nombre de forma ascendente
        personas.stream()
                .sorted((p1, p2) -> p1.getNombre().compareTo(p2.getNombre()))
                .forEach(System.out::println);
    }
}