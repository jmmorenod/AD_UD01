package Ej8;

import Ej8.modelo.Cancion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Cancion> canciones = new ArrayList<>(
                Arrays.asList(
                        new Cancion("Livin' on Prayer", "Bon Jovi"),
                        new Cancion("Long Hot Summer", "Keith Urban"),
                        new Cancion("It's my Life", "Bon Jovi"),
                        new Cancion("Dolor Fantasma", "Amadeus"),
                        new Cancion("Run To You", "Bryan Adams"),
                        new Cancion("Summer of 69", "Bryna Adams"),
                        new Cancion("Paranoid", "Black Sabbath"),
                        new Cancion("Cherokee", "Europe"),
                        new Cancion("River Bank", "Brad Paisley")));
        //Busca las canciones de “Bon Jovi” usando programación tradicional (bucles)
        filtradoDatosBucle(canciones, "Bon Jovi");
        //	Busca las canciones de “Bon Jovi” usando programación funcional.
        fitradoDatosFuncional(canciones, "Bon Jovi");
        //  Busca las canciones de “Bon Jovi” usando programación funcional y las canciones encontradas deben acabar en nueva lista.
        List<Cancion> cancionesBonJovi = cancionesNuevaLista(canciones, "Bon Jovi");
        System.out.println("Canciones de Bon Jovi: " + cancionesBonJovi);
        //	Cuenta el número de canciones que tiene “Bon Jovi” en la lista.
        long numeroCancionesBonJovi = contarCanciones(canciones, "Bon Jovi");
        System.out.println("Número de canciones de Bon Jovi: " + numeroCancionesBonJovi);

        //Realiza una agrupación por cantante y muestra el número de canciones que tiene cada cantante.
        agruparCancionesPorCantante(canciones);

        //Añadimos a un duplicado:
        canciones.add(new Cancion("Summer of 69", "Bryan Adams"));
        //imprimir la información de todas las canciones, pero sin dicho duplicado
        imprimirCancionesSinDuplicados(canciones);

    }

    private static void imprimirCancionesSinDuplicados(List<Cancion> canciones) {
        System.out.println("Canciones sin duplicados: ");
        canciones.stream()
                .distinct()
                .forEach(System.out::println);
    }

    private static void agruparCancionesPorCantante(List<Cancion> canciones) {
        canciones.stream()
                .collect(Collectors.groupingBy(Cancion::getCantante, Collectors.counting()))
                .forEach((cantante, numeroCanciones) -> System.out.println("Cantante: " + cantante + " Número de canciones: " + numeroCanciones));
    }

    private static long contarCanciones(List<Cancion> canciones, String cantante) {
        long numeroCanciones = canciones.stream()
                .filter(c -> c.getCantante().equals(cantante))
                .count();

        return numeroCanciones;
    }

    private static List<Cancion> cancionesNuevaLista(List<Cancion> canciones, String cantante) {
        return canciones.stream()
                .filter(c -> c.getCantante().equals("Bon Jovi"))
                .collect(Collectors.toList());
    }


    private static void filtradoDatosBucle(List<Cancion> canciones, String cantante) {

            // Filtrando elementos forma tradicional
            for (Cancion cancion : filtrarCantante(canciones, cantante)) {
                System.out.println("Tradicional: " + cancion);
            }
        }

    public static List<Cancion> filtrarCantante(List<Cancion> canciones, String cantante) {
        List<Cancion> listaFiltrada = new LinkedList<>();
        for (Cancion cancion : canciones) {
            if (cancion.getCantante().equals(cantante))
                listaFiltrada.add(cancion);
        }
        return listaFiltrada;
    }

    private static void fitradoDatosFuncional(List<Cancion> canciones, String cantante) {

        System.out.println("Funcional: ");
        canciones.stream()
                .filter(c -> c.getCantante().equals(cantante))
                .forEach(System.out::println);

    }
}
