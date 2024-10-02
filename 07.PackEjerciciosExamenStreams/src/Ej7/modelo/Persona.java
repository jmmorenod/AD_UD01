package Ej7.modelo;

public class Persona {
    int id;
    String nombre;
    String apellidos;
    String curso;
    int nota;
    int edad;

    public Persona() {
    }

    public Persona(int id, String nombre, String apellidos, String curso, int nota, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.curso = curso;
        this.nota = nota;
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", curso='" + curso + '\'' +
                ", nota=" + nota +
                ", edad=" + edad +
                '}';
    }
}
