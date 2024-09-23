import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class Ej3 {
    public static void main(String[] args) {
        try {
            // Abrimos el archivo de origen para lectura
            File archivoOrigen = new File("origen.txt");
            FileInputStream entradaOrigen = new FileInputStream(archivoOrigen);

            // Creamos un archivo de destino para escritura
            File archivoDestino = new File("destino.txt");
            FileOutputStream salidaDestino = new FileOutputStream(archivoDestino);

            // Generamos una clave de cifrado
            String clave = "MiClaveDeCifrado";
            SecretKeySpec claveCifrado = new SecretKeySpec(clave.getBytes(StandardCharsets.UTF_8), "AES");

            // Inicializamos el cifrador
            Cipher cifrador = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cifrador.init(Cipher.ENCRYPT_MODE, claveCifrado);

            // Ciframos el archivo
            byte[] buffer = new byte[1024];
            int bytesLeidos;
            while ((bytesLeidos = entradaOrigen.read(buffer)) != -1) {
                byte[] bytesCifrados = cifrador.update(buffer, 0, bytesLeidos);
                salidaDestino.write(bytesCifrados);
            }
            byte[] bytesCifrados = cifrador.doFinal();
            salidaDestino.write(bytesCifrados);

            // Cerramos los recursos
            entradaOrigen.close();
            salidaDestino.close();

            // Imprimimos un mensaje de éxito
            System.out.println("El archivo se ha cifrado correctamente.");

            // Ahora desciframos el archivo
            FileInputStream entradaCifrado = new FileInputStream(archivoDestino);
            FileOutputStream salidaDescifrado = new FileOutputStream(new File("descifrado.txt"));

            // Inicializamos el descifrador
            cifrador.init(Cipher.DECRYPT_MODE, claveCifrado);

            // Desciframos el archivo
            while ((bytesLeidos = entradaCifrado.read(buffer)) != -1) {
                byte[] bytesDescifrados = cifrador.update(buffer, 0, bytesLeidos);
                salidaDescifrado.write(bytesDescifrados);
            }
            byte[] bytesDescifrados = cifrador.doFinal();
            salidaDescifrado.write(bytesDescifrados);

            // Cerramos los recursos
            entradaCifrado.close();
            salidaDescifrado.close();

            // Imprimimos un mensaje de éxito
            System.out.println("El archivo se ha descifrado correctamente.");

        } catch (IOException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
