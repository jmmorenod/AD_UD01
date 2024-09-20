import java.util.function.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Supplier<Integer> random = () -> new Random().nextInt(10);

        for (int i = 0; i < 10; i++) {
            System.out.println(random.get());
        }
    }
}