package Ej1;

import Ej1.modelo.Producto;

import java.io.RandomAccessFile;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Producto producto1 = new Producto(1, "Producto1", 10.99, true, 'A');
        Producto producto2 = new Producto(2, "Producto2", 1.99, true, 'B');
        Producto producto3 = new Producto(3, "Producto3", 5.99, true, 'C');
        Producto producto4 = new Producto(4, "Producto4", 7.99, true, 'A');
        Producto producto5 = new Producto(5, "Producto5", 20.99, false, 'A');
        List<Producto> productos = List.of(producto1, producto2, producto3, producto4, producto5);

        //escribeFichero(productos);
        leeFichero("productos.dat");
    }


    private static void escribeFichero(List<Producto> productos) {
        try (RandomAccessFile raf = new RandomAccessFile("productos.dat", "rw")) {

            // Calcular el tamaño fijo de un registro
            //int tamañoRegistro = Integer.BYTES + 10 + Double.BYTES + 1 + Character.BYTES; //Boolean ocupa 1 byte

            // Escribir los productos en el archivo
            for (Producto producto : productos) {
                raf.writeInt(producto.getId());
                raf.writeBytes(String.format("%-10s", producto.getNombre()));
                raf.writeDouble(producto.getPrecio());
                raf.writeBoolean(producto.isDescuento());
                raf.writeChar(producto.getTipo());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void leeFichero(String fichero) {
        try (RandomAccessFile raf = new RandomAccessFile(fichero, "r")) {
            // Calcular el tamaño de un registro (igual al que usamos al escribir)
            int tamanoRegistro = Integer.BYTES + 10 + Double.BYTES + 1 + Character.BYTES;

            // Posicionarnos al inicio del archivo
            raf.seek(0);

            while (raf.getFilePointer() < raf.length()) {
                int id = raf.readInt();
                byte[] nombreBytes = new byte[10];
                raf.readFully(nombreBytes);
                String nombre = new String(nombreBytes).trim();
                double precio = raf.readDouble();
                boolean descuento = raf.readBoolean();
                char tipo = raf.readChar();

                System.out.println("ID: " + id);
                System.out.println("Nombre: " + nombre);
                System.out.println("Precio: " + precio);
                System.out.println("Descuento: " + descuento);
                System.out.println("Tipo: " + tipo);
                System.out.println("------------------------");

                // Posicionarnos al inicio del siguiente registro
                // No es necesario saltar bytes manualmente ya que hemos leído todos los campos
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
