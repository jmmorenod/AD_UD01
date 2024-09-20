import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Function<Integer, Integer> cube = n -> n * n * n;

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> cubes = numbers.stream()
                                     .map(cube)
                                     .collect(Collectors.toList());

        System.out.println(cubes);  // Imprime: [1, 8, 27, 64, 125]
    }
}