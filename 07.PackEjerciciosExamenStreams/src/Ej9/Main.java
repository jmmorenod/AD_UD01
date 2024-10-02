package Ej9;

import Ej9.modelo.Estudiante;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        List<Estudiante> listaAlumnos = new ArrayList<>();
        // Cargamos la lista de Alumnos
        listaAlumnos.add(new Estudiante(1, "1717213183", "Javier", "Molina Cano", "Java 8", 7, 28));
        listaAlumnos.add(new Estudiante(2, "1717456218", "Ana", "Gómez Álvarez", "Java 8", 10, 33));
        listaAlumnos.add(new Estudiante(3, "1717328901", "Pedro", "Marín López", "Java 8", 8.6, 15));
        listaAlumnos.add(new Estudiante(4, "1717567128", "Emilio", "Duque Gutiérrez", "Java 8", 10, 13));
        listaAlumnos.add(new Estudiante(5, "1717902145", "Alberto", "Sáenz Hurtado", "Java 8", 9.5, 15));
        listaAlumnos.add(new Estudiante(6, "1717678456", "Germán", "López Fernández", "Java 8", 8, 34));
        listaAlumnos.add(new Estudiante(7, "1102156732", "Oscar", "Murillo González", "Java 8", 10, 32));
        listaAlumnos.add(new Estudiante(8, "1103421907", "Antonio Jesús", "Palacio Martínez", "PHP", 9.5, 17));
        listaAlumnos.add(new Estudiante(9, "1717297015", "César", "González Martínez", "Java 8", 8, 26));
        listaAlumnos.add(new Estudiante(10, "1717912056", "Gloria", "González Castaño", "PHP", 10, 28));
        listaAlumnos.add(new Estudiante(11, "1717912058", "Jorge", "Ruiz Ruiz", "Python", 8, 22));
        listaAlumnos.add(new Estudiante(12, "1717912985", "Ignacio", "Duque García", "Java Script", 9.4, 32));
        listaAlumnos.add(new Estudiante(13, "1717913851", "Julio", "González Castaño", "C Sharp", 10, 22));
        listaAlumnos.add(new Estudiante(14, "1717986531", "Gloria", "Rodas Carretero", "Ruby", 7, 18));
        listaAlumnos.add(new Estudiante(15, "1717975232", "Jaime", "Jiménez Gómez", "Java Script", 10, 18));

        //Muestra todos los alumnos: Lista de Alumnos debes usar una referencia a método
        System.out.println("Lista de Alumnos: ");
        listaAlumnos.forEach(System.out::println);
        //Alumnos cuyo apellido empiezan con el caracter L u G
        System.out.println("\n*** Alumnos cuyo apellido empiezan con el caracter L u G ***");
        listaAlumnos.stream().
                filter(c -> c.getApellidos().charAt(0) == 'L' || c.getApellidos().charAt(0) == 'G')
                .forEach(System.out::println);
        //Numero de alumnos
        System.out.println("\n**** Número de Alumnos ***");
        System.out.println(listaAlumnos.stream().count());
        //Alumnos con nota mayor a 9 y que sean del curso PHP
        System.out.println("\n*** Alumnos con nota mayor a 9 y que sean del curso PHP ***");
        listaAlumnos.stream()
                .filter(c -> c.getNota() > 9 && c.getNombreCurso().equals("PHP"))
                .forEach(System.out::println);
        //Imprimir los 2 primeros Alumnos de la lista
        System.out.println("\n*** Los 2 primeros Alumnos de la lista ***");
        listaAlumnos.stream()
                .limit(2)
                .forEach(System.out::println);
        //Imprimir el alumno con menor edad
        System.out.println("\n*** El alumno con menor edad ***");
        listaAlumnos.stream()
                .min((c1, c2) -> c1.getEdad() - c2.getEdad())
                .ifPresent(System.out::println);
        //Imprimir el alumno con mayor edad
        System.out.println("\n*** El alumno con mayor edad ***");
        listaAlumnos.stream()
                .max((c1, c2) -> c1.getEdad() - c2.getEdad())
                .ifPresent(System.out::println);
        //Encontrar el primer Alumno
        System.out.println("\n*** El primer Alumno ***");
        listaAlumnos.stream()
                .findFirst()
                .ifPresent(System.out::println);

        //Alumnos que tienen un curso en el que el nombre contienen la A
        System.out.println("\n*** Alumnos que tienen un curso en el que el nombre contienen la A ***");
        listaAlumnos.stream()
                .filter(c -> c.getNombreCurso().contains("a"))
                .forEach(System.out::println);
        //Alumnos en que la longitud de su nombre es mayor a 10 caracteres
        System.out.println("\n*** Alumnos en que la longitud de su nombre es mayor a 10 caracteres ***");
        listaAlumnos.stream()
                .filter(c -> c.getNombre().length() > 10)
                .forEach(System.out::println);
        //Obtiene los alumnos en los cuales el nombre del curso empieza con el caracter 'P' y la longitud sea <= a 6
        System.out.println("\n*** Alumnos en los cuales el nombre del curso empieza con el caracter 'P' y la longitud sea <= a 6 ***");
        listaAlumnos.stream()
                .filter(c -> c.getNombreCurso().charAt(0) == 'P' && c.getNombreCurso().length() <= 6)
                .forEach(System.out::println);
        //Crea una nueva lista llamada “listaNueva” con el contenido de la consulta anterior.
        System.out.println("\n*** Crea una nueva lista llamada “listaNueva” con el contenido de la consulta anterior ***");
        List<Estudiante> listaNueva = listaAlumnos.stream()
                .filter(c -> c.getNombreCurso().charAt(0) == 'P' && c.getNombreCurso().length() <= 6)
                .toList();
        System.out.println(listaNueva);
    }

}
