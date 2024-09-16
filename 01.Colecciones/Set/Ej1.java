package Set;
import java.util.HashSet;
import java.util.Set;

public class Ej1 {
    public static void main(String[] args) {
        Set<String> conjunto = new HashSet<>();
        conjunto.add("Elemento 1");
        conjunto.add("Elemento 2");
        conjunto.add("Elemento 3");
        conjunto.add("Elemento 1"); // Elemento duplicado

        for (String elemento : conjunto) {
            System.out.println(elemento);
        }

        // Observación: El orden de los elementos no está garantizado y los duplicados no se permiten.
    }
}