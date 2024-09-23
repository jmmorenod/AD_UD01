
import java.util.Arrays;
import java.util.List;

public class EJ03 {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        int sumOfSquares = numbers.stream()
                .map(n -> n * n)
                .reduce(0, Integer::sum);
        //explicación de la línea anterior:
        //.reduce(0, Integer::sum) reduce el flujo de los cuadrados a un solo valor. Aquí, 0 es el valor inicial de la reducción, e Integer::sum es una referencia a un método que toma dos enteros y devuelve su suma.

        System.out.println(sumOfSquares);

    }
}
