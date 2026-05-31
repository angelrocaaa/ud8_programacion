package practica4;
import java.io.*;
import java.util.HashMap;
import java.util.TreeMap;

public class ej4 {

    public static void main(String[] args) {
        HashMap<String, Persona> mapa = new HashMap<>();
        mapa.put("Zaira", new Persona("Zaira", 24, "pass1"));
        mapa.put("Alvaro", new Persona("Alvaro", 19, "pass2"));
        mapa.put("Manuel", new Persona("Manuel", 30, "pass3"));

        File fichero = new File("src/main/resources/mapa.ser");

        try {
            ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(fichero));
            escritor.writeObject(mapa);
            escritor.close();
            System.out.println("Mapa serializado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            ObjectInputStream lector = new ObjectInputStream(new FileInputStream(fichero));
            HashMap<String, Persona> mapaRecuperado = (HashMap<String, Persona>) lector.readObject();
            lector.close();
            System.out.println("Mapa deserializado correctamente.");

            TreeMap<String, Persona> mapaOrdenado = new TreeMap<>(mapaRecuperado);

            for (String clave : mapaOrdenado.keySet()) {
                Persona p = mapaOrdenado.get(clave);
                System.out.println("Clave: " + clave + " -> Nombre: " + p.getNombre() + ", Edad: " + p.getEdad());
            }

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
    }
}
