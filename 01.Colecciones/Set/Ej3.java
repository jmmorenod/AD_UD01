package Set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ej3 {

    public static Set<String> obtenerStringsUnicos(List<String> listaOriginal) {
        return new HashSet<>(listaOriginal);
    }

    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();
        lista.add("Hola");
        lista.add("Mundo");
        lista.add("Hola");
        lista.add("Java");
        lista.add("Mundo");

        Set<String> conjuntoUnicos = obtenerStringsUnicos(lista);
        System.out.println(conjuntoUnicos); // Imprime: [Hola, Mundo, Java]
    }
}