import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Ej01 {
    public static void main(String[] args) {
        List<Fruta> frutas = Arrays.asList(new Fruta("Manzana", "Roja"),new Fruta("Pera", "Verde"),
        new Fruta("Naranja", "Naranja"), new Fruta("Banana", "Amarilla"),  new Fruta("Uva", "Morada"),
        new Fruta("Cereza", "Roja"), new Fruta("Kiwi", "Verde"), new Fruta("Mango", "Amarillo"));

        List<String> fruitNames = frutas.stream()
                .map(Fruta::getNombre)
                .collect(Collectors.toList());//hasta aquí la solución

        System.out.println(fruitNames);
    }
}