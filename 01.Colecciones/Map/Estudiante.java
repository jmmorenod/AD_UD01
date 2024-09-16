package Map;

public class Estudiante {

        private String nombre;
        private int edad;
        private String grado;

        public Estudiante(String nombre, int edad, String grado) {
            this.nombre = nombre;
            this.edad = edad;
            this.grado = grado;
        }

        public String getNombre() {
            return nombre;
        }

        public int getEdad() {
            return edad;
        }

        public String getGrado() {
            return grado;
        }

        @Override
        public String toString() {
            return "Estudiante{" +
                    "nombre='" + nombre + '\'' +
                    ", edad=" + edad +
                    ", grado='" + grado + '\'' +
                    '}';
        }
    }

