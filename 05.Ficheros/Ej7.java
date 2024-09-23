import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class Ej7 {

    public static List<Path> findFiles(String directory, String pattern, int maxDepth) {
        List<Path> result = new ArrayList<>();
        try {
            Files.walkFileTree(Paths.get(directory), new SimpleFileVisitor<Path>() {
                private int currentDepth = 0;

                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    if (currentDepth > maxDepth) {
                        return FileVisitResult.SKIP_SUBTREE;
                    }
                    currentDepth++;
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    currentDepth--;
                    return FileVisitResult.CONTINUE;
                }

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
        String ruta = "/users/juanma/IdeaProjects/";
        String patron = "*.java";
        int maxDepth = 3;

        String directory = ruta;
        String pattern = patron.replace("*", ".*"); // Convert wildcard to regex
        List<Path> files = findFiles(directory, pattern, maxDepth);

        for (Path file : files) {
            System.out.println(file);
        }
    }
}
