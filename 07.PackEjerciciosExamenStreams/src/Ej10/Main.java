package Ej10;

import Ej10.modelo.Product;
import Ej10.utils.Util;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Product> products;
        try {
            products = Util.getProducts();
            procesarStreams(products);
        } catch (Exception e) {
            System.err.println("Error al leer el fichero de productos: " + e.getMessage());
        }
    }

    private static void procesarStreams(List<Product> products) {

            todosProductos(products);

            consultasSimples(products);

            consultasFiltradas(products);

            consultasOrdenacion(products);

            consultasAgrupados(products);

            consultasHaving(products);

            consultasOtras(products);

        }

    private static void todosProductos(List<Product> products) {
        // Equivale a selec * from products
        System.out.println("Todos los productos");
        Stream<Product> s = products.stream(); //flujo de elementos Product
        s.forEach(System.out::println); // imprime la lista de productos
        // productStream.forEach(System.out::println); esta linea es equivalente a la anterior
        System.out.println();
    }

    private static void consultasSimples(List<Product> products) {
        // Consultas Simples
        // select name from products
        System.out.println("Nombre de los productos");
        Stream<String> s = products.stream()
                .map(Product::getName);
        s.forEach(System.out::println);
        System.out.println();
    }

    private static void consultasFiltradas(List<Product> products) {
        // Filtrado
        //   select name from products where units_in_stock < 10
        // Importante el filter va antes del map
        System.out.println("Nombre de los productos con unidades en stock mayor de 10");
        Stream<String> s = products.stream()
                .filter(p -> p.getUnitsInStock() < 10)
                .map(Product::getName);
        s.forEach(System.out::println); //imprime el resultado en consola
        System.out.println();
    }

    private static void consultasOrdenacion(List<Product> products) {
        //Ordenacion
        // select name from products where units_in_stock < 1 order by units_in_stock asc
//        El método sorted recibe un Comparator. Ésta misma interfaz Comparator tiene algunos métodos que nos serán de gran ayuda
//
//        comparingInt() Permite comparar elementos de tipo int
//        comparingDouble() Permite comparar elementos de tipo double
//        comparingLong() Permite comparar elementos de tipo long
//        thenComparing() Permite anidar comparaciones. Útil cuándo deseamos ordenar por más de 1 atributo (ejemplo más adelante)
        System.out.println("Nombre de los productos con unidades en stock mayor de 10 ordenados por unidades en stock ascendente");
        Stream<String> s = products.stream()
                .filter(p -> p.getUnitsInStock() < 10)
                .sorted(Comparator.comparingInt(Product::getUnitsInStock))
                .map(Product::getName);
        s.forEach(System.out::println); //imprime el resultado en consola
        System.out.println();

        // Si deseamos ordenar en forma descendente necesitamos aplicar un reverso
        System.out.println("Nombre de los productos con unidades en stock mayor de 10 ordenados por unidades en stock descedente");
        s = products.stream()
                .filter(p -> p.getUnitsInStock() < 10)
                .sorted(Comparator.comparingDouble(Product::getUnitsInStock).reversed())
                .map(Product::getName);
        s.forEach(System.out::println); //imprime el resultado en consola
        System.out.println();

        // Otra forma diferente de ordenar, es que nuestra clase Product implemente a la interfaz Comparable
        System.out.println("Nombre de los productos con unidades en stock mayor de 10 ordenados por unidades en stock ascendente - Comparable");
        s = products.stream()
                .filter(p -> p.getUnitsInStock() < 10)
                .sorted()
                .map(Product::getName);
        s.forEach(System.out::println); //imprime el resultado en consola
        System.out.println();

        System.out.println("Nombre de los productos con unidades en stock mayor de 10 ordenados por unidades en stock descendente - Comparable");
        s = products.stream()
                .filter(p -> p.getUnitsInStock() < 10)
                .sorted(Comparator.reverseOrder())
                .map(Product::getName);
        s.forEach(System.out::println); //imprime el resultado en consola
        System.out.println();

        System.out.println("Nombre de los productos con unidades en stock mayor de 10 ordenados ordenar por unidad de stock de forma descendente y por nombre de producto de forma ascendente");
        // select productName, unitsInStock from products where unitsInStock < 10 order by unitsInStock desc, productName asc;
        s = products.stream()
                .filter(p -> p.getUnitsInStock() < 10)
                //recordar que el método sorted recibe un Comparator.
                .sorted(Comparator
                        .comparing(Product::getUnitsInStock)
                        .reversed() //invertimos el orden, será de mayor a menor
                        .thenComparing(Product::getName)) //una vez ordenado por unitsInStock, entonces ordenamos por nombre
                .map(Product::getName);
        s.forEach(System.out::println); //imprime el resultado en consola
        System.out.println();

        System.out.println("Nombre de los productos con unidades en stock mayor de 10 ordenados ordenar por unidad de stock de forma ascendente y por nombre de producto de forma descendente");
        // select productName, unitsInStock from products where unitsInStock < 10 order by unitsInStock desc, productName asc;
        s = products.stream()
                .filter(p -> p.getUnitsInStock() < 10)
                //recordar que el método sorted recibe un Comparator.
                .sorted(
                        Comparator
                                .comparing(Product::getUnitsInStock) //ordenamos ascendente por unitsInStock
                                .thenComparing( // después ordenamos por otro campo
                                        Collections.reverseOrder( // pero este segundo campo será por orden descendente
                                                Comparator.comparing(Product::getName) // el segundo campo a ordenar
                                        )
                                )
                )
                .map(Product::getName);
        s.forEach(System.out::println); //imprime el resultado en consola
        System.out.println();

//        El método sorted()recibe un Comparator
//        La interfaz Comparator nos proporciona algúnos métodos que nos serán útiles para las ordenaciones.
//        Existe una clase Collections que tiene un método reverseOrder() el cual devuelve un Comparator que impone el reverso de una ordenación.
//        Hay que tener cuidado donde se aplican las operaciones como reversos ya que podríamos aplicarlos a toda la colección y no a los campos que deseamos.

    }

    private static void consultasAgrupados(List<Product> products) {
        // Agrupado
        //   select name from products where units_in_stock < 10
        // En SQL las operaciones como sum, max, min, avg, group by, partition by, etc., se llaman funciones de agregado.
        // En Java, se especifican en el método collect
        // Select count(1), supplierID from products GROUP BY  supplierID
        System.out.println("Obtener el número de productos agrupados por proveedor");
        Map<Integer, Long> c1 = products.stream()
                .collect( //en el metodo collect se especifican las funciones de agregacion
                        Collectors.groupingBy( // deseamos agrupar
                                Product::getSupplier, // agrupamos por proveedor
                                Collectors.counting() // realizamos el conteo
                        )
                );

        c1.forEach((s, c) -> System.out.printf("proveedor: %s: productos: %s \n", s, c));
        System.out.println();

//        Dado que en el método collect especificamos funciones de agregado, casi siempre nos auxiliaremos de la clase Collectors
//        la cuál nos proporciona varios métodos de funciones de agregado. En este ejemplo, usamos el método groupingBy
//        Si deseamos filtrar todos los productos que en almacen tengan menos de 20 unidades de existencia y agrupados por existencia,

        Map<Integer, List<Product>> c2 = products.stream()
                .filter(p -> p.getUnitsInStock() < 20)
                .collect(Collectors.groupingBy(Product::getUnitsInStock));

        c2.forEach((unidades, producto) -> System.out.printf("existencias: %s Productos: %s \n", unidades, producto));
    }


    private static void consultasHaving(List<Product> products) {
        // Having, filtros sobre los agregados o agrupamientos
        // Select  unitsInStock, sum(unitPrice) from products GROUP BY unitsInStock HAVING sum(unitPrice) > 100
        System.out.println("Obtener la suma del precio unitario de todos los productos agrupados por el número de existencias en el almacén, pero solo obtener aquellos registros cuya suma sea mayor a 100");
        List<Map.Entry<Integer, Double>> entryList = products.stream()
                .collect( //en el método collect se especifican las funciones de agregación
                        Collectors.groupingBy( // deseamos agrupar
                                Product::getUnitsInStock, //agrupamos por existencias en stock
                                Collectors.summingDouble( //sumamos el precio unitario el cual es tipo double
                                        Product::getUnitPrice // agrupamos por proveedor
                                )
                        )
                ).entrySet()
                .stream() //volvemos a generar un stream
                .filter(p -> p.getValue() > 100) //filtramos (simula el having)
                .collect(Collectors.toList());

        entryList.forEach(list -> System.out.printf("en stock: %s, suma: %s\n", list.getKey(), list.getValue()));
        System.out.println();
    }

    private static void consultasOtras(List<Product> products) {
        // prromedio de existencias en almacén
        System.out.println("Promedio de existencias en almacén");
        Double average = products.stream()
                .collect(Collectors.averagingInt(Product::getUnitsInStock));
        System.out.printf("Promedio de existencias en almacén: %s", average);
        System.out.println();

        // Producto con el precio unitario más alto
        System.out.println("Producto con el precio unitario más alto");
        Optional<Product> product = products.stream().max(Comparator.comparing(Product::getUnitPrice));
        System.out.println(product.get());
        System.out.println();



        // Limitar el numero de productos devueltos
        System.out.println("Limitar el numero de productos devueltos");
        products.stream().limit(50).forEach(System.out::println); // limitamos a 50 productos
        // Saltar hasta el elemento indicado y a partir de ahí devolver todos los elementos
        System.out.println("Saltar hasta el elemento indicado y a partir de ahí devolver todos los elementos");
        Stream<Product> skip = products.stream().skip(5); //obtenemos los productos a partir del 6 (inclusive)
        skip.forEach(System.out::println);
        System.out.println();
    }


}
