import java.util.*;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        Consumer<String> print = s -> System.out.println(s);

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        names.forEach(print);  // Imprime: Alice, Bob, Charlie
    }
}