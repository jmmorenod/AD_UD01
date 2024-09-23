import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class Ej6 {

    public static List<Path> findFiles(String directory, String pattern) {
        List<Path> result = new ArrayList<>();
        try {
            Files.walkFileTree(Paths.get(directory), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (file.getFileName().toString().matches(pattern)) {
                        result.add(file);
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        String ruta = "src";
        String patron = "*.java";

        String directory = ruta;
        String pattern = patron.replace("*", ".*"); // Convert wildcard to regex
        List<Path> files = findFiles(directory, pattern);

        for (Path file : files) {
            System.out.println(file);
        }
    }
}
