package Map;

import java.util.HashMap;
import java.util.Map;

public class Ej1 {
        public static void main(String[] args) {
            // Crear un Map que asocie nombres de países con sus capitales
            Map<String, String> paisesCapitales = new HashMap<>();
            paisesCapitales.put("España", "Madrid");
            paisesCapitales.put("Francia", "París");
            paisesCapitales.put("Alemania", "Berlín");
            paisesCapitales.put("Italia", "Roma");
            paisesCapitales.put("Portugal", "Lisboa");

            // Imprimir todos los pares de clave-valor del Map
            for (Map.Entry<String, String> entry : paisesCapitales.entrySet()) {
                System.out.println("País: " + entry.getKey() + ", Capital: " + entry.getValue());
            }
        }
    }

