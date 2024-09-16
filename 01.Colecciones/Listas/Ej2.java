package Listas;

import java.util.ArrayList;
import java.util.List;

public class Ej2 {
    public static List<Integer> obtenerNumerosPares(List<Integer> listaOriginal) {
        List<Integer> listaPares = new ArrayList<>();
        for (Integer numero : listaOriginal) {
            if (numero % 2 == 0) {
                listaPares.add(numero);
            }
        }
        return listaPares;
    }

    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(5);

        List<Integer> listaPares = obtenerNumerosPares(lista);
        System.out.println(listaPares); // Imprime: [2, 4]
    }
}
