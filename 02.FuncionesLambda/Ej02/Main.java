import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("Alicia", "Bob", "Carlos", "David", "Alberto", "Alex"));

        names.removeIf(name -> !name.startsWith("A"));

        System.out.println(names);
    }
}
