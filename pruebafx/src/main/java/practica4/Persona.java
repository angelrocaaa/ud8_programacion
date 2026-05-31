package practica4;

import java.io.Serializable;

public class Persona implements Serializable {
    private String nombre;
    private int edad;
    private transient String contraseña;

    public Persona(String nombre, int edad, String contraseña) {
        this.nombre = nombre;
        this.edad = edad;
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getContraseña() {
        return contraseña;
    }
}
