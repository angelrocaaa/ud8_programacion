package practica4;

import java.io.*;
import java.util.ArrayList;

public class ej1_2_3 {

    public static void main(String[] args) {
        ArrayList<Persona> lista = new ArrayList<>();
        lista.add(new Persona("Juan", 20, "1234abcd"));
        lista.add(new Persona("Lucia", 25, "p@ssword"));
        lista.add(new Persona("Pedro", 22, "qwerty99"));

        File fichero = new File("src/main/resources/clase_prueba.ser");

        try {
            ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(fichero));
            escritor.writeObject(lista);
            escritor.close();
            System.out.println("Lista serializada correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Persona> listaRecuperada = null;

        try {
            ObjectInputStream lector = new ObjectInputStream(new FileInputStream(fichero));
            listaRecuperada = (ArrayList<Persona>) lector.readObject();
            lector.close();
            System.out.println("Lista deserializada correctamente.");

        } catch (FileNotFoundException e) {
            System.out.println("El fichero no existe. Creando archivo con datos por defecto...");
            crearDatosPorDefecto(fichero);
        } catch (IOException e) {
            System.out.println("El fichero está dañado o hay un error de E/S. Creando archivo con datos por defecto...");
            crearDatosPorDefecto(fichero);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (listaRecuperada != null) {
            for (Persona p : listaRecuperada) {
                System.out.println("Nombre: " + p.getNombre() + ", Edad: " + p.getEdad() + ", Contraseña: " + p.getContraseña());
            }
        }
    }

    public static void crearDatosPorDefecto(File fichero) {
        ArrayList<Persona> listaDefecto = new ArrayList<>();
        listaDefecto.add(new Persona("UsuarioDefecto", 99, "default123"));

        try {
            ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(fichero));
            escritor.writeObject(listaDefecto);
            escritor.close();
            System.out.println("Archivo por defecto generado con éxito.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}