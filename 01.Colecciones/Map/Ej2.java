package Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ej2 {

        public static Map<String, Integer> contarFrecuenciaStrings(List<String> lista) {
            Map<String, Integer> frecuenciaMap = new HashMap<>();
            for (String str : lista) {
                frecuenciaMap.put(str, frecuenciaMap.getOrDefault(str, 0) + 1);
            }
            return frecuenciaMap;
        }

        public static void main(String[] args) {
            List<String> lista = new ArrayList<>();
            lista.add("Hola");
            lista.add("Mundo");
            lista.add("Hola");
            lista.add("Java");
            lista.add("Mundo");
            lista.add("Hola");

            Map<String, Integer> frecuenciaMap = contarFrecuenciaStrings(lista);
            for (Map.Entry<String, Integer> entry : frecuenciaMap.entrySet()) {
                System.out.println("String: " + entry.getKey() + ", Frecuencia: " + entry.getValue());
            }
        }

}
