package Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Ej3 {


        public static Map<String, Estudiante> mapearEstudiantesPorNombre(List<Estudiante> listaEstudiantes) {
            Map<String, Estudiante> mapaEstudiantes = new HashMap<>();
            for (Estudiante estudiante : listaEstudiantes) {
                mapaEstudiantes.put(estudiante.getNombre(), estudiante);
            }
            return mapaEstudiantes;
        }

        public static void main(String[] args) {
            List<Estudiante> listaEstudiantes = new ArrayList<>();
            listaEstudiantes.add(new Estudiante("Juan", 20, "Segundo"));
            listaEstudiantes.add(new Estudiante("Ana", 22, "Tercero"));
            listaEstudiantes.add(new Estudiante("Luis", 21, "Segundo"));
            listaEstudiantes.add(new Estudiante("Maria", 23, "Cuarto"));

            Map<String, Estudiante> mapaEstudiantes = mapearEstudiantesPorNombre(listaEstudiantes);
            for (Map.Entry<String, Estudiante> entry : mapaEstudiantes.entrySet()) {
                System.out.println("Nombre: " + entry.getKey() + ", Estudiante: " + entry.getValue());
            }
        }
    }

