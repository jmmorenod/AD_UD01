package Listas;

import java.util.ArrayList;
import java.util.List;

    public class Ej3 {
        public static int longitudStringMasLargo(List<String> lista) {
            int maxLength = 0;
            for (String str : lista) {
                if (str.length() > maxLength) {
                    maxLength = str.length();
                }
            }
            return maxLength;
        }

        public static void main(String[] args) {
            List<String> lista = new ArrayList<>();
            lista.add("Hola");
            lista.add("Mundo");
            lista.add("Programación");
            lista.add("Java");

            int maxLength = longitudStringMasLargo(lista);
            System.out.println("La longitud del string más largo es: " + maxLength); // Imprime: 12
        }
    }

