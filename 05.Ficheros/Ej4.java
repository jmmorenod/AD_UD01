import java.io.*;

public class Ej4 {
    public static void main(String[] args) {
        try {
            // Creamos un archivo de destino para escritura
            File archivoDestino = new File("destino.txt");
            FileOutputStream salidaDestino = new FileOutputStream(archivoDestino);

            // Recorremos la lista de archivos de origen
            for (String nombreArchivo : args) {
                System.out.println(nombreArchivo);
                File archivoOrigen = new File(nombreArchivo);

                // Abrimos el archivo de origen para lectura
                FileInputStream entradaOrigen = new FileInputStream(archivoOrigen);

                // Copiamos el contenido del archivo de origen al archivo de destino
                byte[] buffer = new byte[1024];
                int bytesLeidos;
                while ((bytesLeidos = entradaOrigen.read(buffer)) != -1) {
                    salidaDestino.write(buffer, 0, bytesLeidos);
                }

                // Cerramos los recursos
                entradaOrigen.close();
            }

            // Cerramos el recurso de escritura del archivo de destino
            salidaDestino.close();

            // Imprimimos un mensaje de éxito
            System.out.println("Los archivos se han combinado correctamente.");

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}