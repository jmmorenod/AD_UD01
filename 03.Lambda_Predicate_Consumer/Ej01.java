import java.util.*;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        Predicate<Integer> isOdd = n -> n % 2 != 0;

        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        numbers.removeIf(isOdd);

        System.out.println(numbers);  // Imprime: [2, 4, 6, 8, 10]
    }
}