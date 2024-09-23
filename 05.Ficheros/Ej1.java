import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Ej1 {

            public static void main(String[] args) {


                String filePath = "texto.txt";
                int lineCount = countLines(filePath);
                System.out.println("Number of lines: " + lineCount);
            }

            public static int countLines(String filePath) {
                int lines = 0;
                try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                    while (reader.readLine() != null) {
                        lines++;
                    }
                } catch (IOException e) {
                    System.err.println("Error reading file: " + e.getMessage());
                }
                return lines;
            }
        }

