import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ej05 {

    public static void main(String[] args) {
        List<Empleado> listaEmpleado = List.of(
                new Empleado("Juan", "Ventas"),
                new Empleado("Pedro", "Ventas"),
                new Empleado("Maria", "Sistemas"),
                new Empleado("Luis", "Sistemas"),
                new Empleado("Ana", "Ventas"),
                new Empleado("Jose", "Sistemas"),
                new Empleado("Carlos", "Ventas"),
                new Empleado("Andres", "Sistemas"),
                new Empleado("Jorge", "Ventas"),
                new Empleado("Marta", "Sistemas"),
                new Empleado("Lucia", "Desarrollo"),
                new Empleado("Julia", "Desarrollo"),
                new Empleado("Carmen", "Desarrollo"),
                new Empleado("Antonio", "Desarrollo"),
                new Empleado("Rosa", "Desarrollo"),
                new Empleado("Fernando", "Desarrollo"),
                new Empleado("Alberto", "Desarrollo"),
                new Empleado("Raul", "Desarrollo"),
                new Empleado("Javier", "Desarrollo"),
                new Empleado("Ricardo", "Desarrollo")
        );
        // Agrupamos los empleados por departamento
        Map<String, List<Empleado>> employeesByDepartment = listaEmpleado.stream()
                .collect(Collectors.groupingBy(Empleado::getDepartamento));

        System.out.println(employeesByDepartment);

        System.out.println("---------------------------------------------------");
        // Agrupamos los empleados por departamento y contamos cuantos empleados hay en cada departamento
        Map<String, Long> employeesCountByDepartment = listaEmpleado.stream()
                .collect(Collectors.groupingBy(Empleado::getDepartamento, Collectors.counting()));
        System.out.println(employeesCountByDepartment);
        System.out.println("---------------------------------------------------");
        // Imprimimos el número de empleados por departamento
        employeesCountByDepartment.forEach((departamento, count) -> System.out.println(departamento + " : " + count));
        // Dado un departamento mostraremos sus empleados.
        System.out.println("---------------------------------------------------");
        String departamento = "Ventas";
        employeesByDepartment.get(departamento).forEach(System.out::println);
        System.out.println("-----------otra forma-------------------------------");
        listaEmpleado.stream().filter(empleado -> empleado.getDepartamento().equals(departamento)).forEach(System.out::println);
        System.out.println("---------------------------------------------------");  
        // Dado un nombre de empleado, mostraremos su departamento.
        String nombreEmpleado = "Juan";
        listaEmpleado.stream()
                .filter(empleado -> empleado.getNombre().equals(nombreEmpleado))
                .map(Empleado::getDepartamento)
                .forEach(System.out::println);
    }
}