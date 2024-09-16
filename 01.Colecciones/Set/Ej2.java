package Set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class Ej2 {


        public static Set<Integer> obtenerNumerosUnicos(List<Integer> listaOriginal) {
            return new HashSet<>(listaOriginal);
        }

        public static void main(String[] args) {
            List<Integer> lista = new ArrayList<>();
            lista.add(1);
            lista.add(2);
            lista.add(2);
            lista.add(3);
            lista.add(4);
            lista.add(4);
            lista.add(5);

            Set<Integer> conjuntoUnicos = obtenerNumerosUnicos(lista);
            System.out.println(conjuntoUnicos); // Imprime: [1, 2, 3, 4, 5]
        }
    }

