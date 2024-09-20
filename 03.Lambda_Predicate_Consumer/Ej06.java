import java.util.*;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        Consumer<Integer> multiplyBy2 = n -> System.out.println(n * 2);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.forEach(multiplyBy2);  // Imprime: 2, 4, 6, 8, 10
    }
}