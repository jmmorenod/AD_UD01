package Ej2;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        String archivoOriginal = "archivoOriginal.txt";
        String archivoNuevo = "archivoNuevo.txt";
        String textoBuscar = "cadenaBuscar";
        String textoReemplazar = "cadenaReemplazar";

        buscarYReemplazar(archivoOriginal, archivoNuevo, textoBuscar, textoReemplazar);
    }

    public static void buscarYReemplazar(String archivoOriginal, String archivoNuevo, String textoBuscar, String textoReemplazar) {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivoOriginal));
             BufferedWriter writer = new BufferedWriter(new FileWriter(archivoNuevo))) {

            String linea;
            while ((linea = reader.readLine()) != null) {
                String lineaModificada = linea.replace(textoBuscar, textoReemplazar);
                writer.write(lineaModificada);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
