import java.util.*;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        Predicate<String> startsWithA = s -> s.startsWith("A");

        List<String> names = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie", "David", "Albert", "Alex"));
        names.removeIf(startsWithA.negate());

        System.out.println(names);  // Imprime: [Alice, Albert, Alex]
    }
}