import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ej02 {
    public static void main(String[] args) {
        List<Fruta> frutas = Arrays.asList(new Fruta("Manzana", "Roja"),new Fruta("Pera", "Verde"),
                new Fruta("Naranja", "Naranja"), new Fruta("Banana", "Amarillo"),  new Fruta("Uva", "Morada"),
                new Fruta("Cereza", "Roja"), new Fruta("Kiwi", "Verde"), new Fruta("Mango", "Amarillo"), new Fruta("Mandarina", "Naranja"));

        List<String> fruitColors = frutas.stream()
                .map(Fruta::getColor)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(fruitColors);
    }
}
