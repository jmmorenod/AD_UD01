package Ej4;

import Ej4.modelo.Producto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        //leer el archivo csv de productos
        List<Producto> listaProductos = leerProductos("Ej4.csv");
        //Calcula el producto más caro de cada categoría.
        listaProductos.stream().collect(Collectors.groupingBy(Producto::getCategoria,
                        Collectors.maxBy(Comparator.comparing(Producto::getPrecio))))
                .forEach((categoria, producto) -> System.out.println("Producto más caro de la categoría " + categoria + ": " + producto.orElse(null)));
        //Imprime una lista con los productos cuyo precio está entre 10 y 20 euros.
        List<Producto> productosEntre10y20 = listaProductos.stream()
                .filter(p -> p.getPrecio() >= 10 && p.getPrecio() <= 20)
                .collect(Collectors.toList());
        System.out.println("Productos entre 10 y 20 euros: " + productosEntre10y20);


    }



private static List<Producto> leerProductos(String archivoCsv) {
    //Abrimos el archivo csv pasado como argumento y leemos los productos
    //por cada linea del archivo, creamos un objeto Producto y lo agregamos a la lista
    //devolvemos la lista de productos
    List<Producto> listaProductos = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(archivoCsv))) {
        String linea;
        linea = br.readLine(); //Leemos la primera línea que contiene los nombres de las columnas;
        while ((linea = br.readLine()) != null) {
            String[] campos = linea.split(";");
            if (campos.length == 3) {
                String nombre = campos[0];
                double precio = Double.parseDouble(campos[1].replace(',', '.'));
                String categoria = campos[2];
                Producto producto = new Producto(nombre, precio, categoria);
                listaProductos.add(producto);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return listaProductos;
}


    }

