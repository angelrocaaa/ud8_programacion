package JSON;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {
    static Scanner teclado = new Scanner(System.in);
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    static List<Videojuego> listavideojuego = new ArrayList<>();

    public static void main(String[] args) {
        listavideojuego = crearLista();
        crearJsonFile(listavideojuego);
        cargarJsonFile();
        menor30();

        System.out.println("\nAñadiendo un nuevo videojuego a la colección de forma consecutiva:");
        listavideojuego.add(pedirUnVideojuego());
        crearJsonFile(listavideojuego);
    }

    static void menor30() {
        System.out.println("\n--- Videojuegos con precio menor a 30€ ---");
        for (Videojuego videojuego : listavideojuego) {
            if (videojuego.getPrecio() < 30) {
                System.out.println(videojuego.getNombre());
            }
        }
    }

    static void cargarJsonFile() {
        try {
            FileReader reader = new FileReader("src/main/resources/videojuegos.json");
            Videojuego[] videojuegosArray = gson.fromJson(reader, Videojuego[].class);
            listavideojuego = new ArrayList<>(Arrays.asList(videojuegosArray));
            reader.close();

            System.out.println("\n--- Contenido leído del archivo JSON directamente ---");
            BufferedReader lectorLinea = new BufferedReader(new FileReader("src/main/resources/videojuegos.json"));
            String linea;
            while ((linea = lectorLinea.readLine()) != null) {
                System.out.println(linea);
            }
            lectorLinea.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("mal leyendo");
        }
    }

    static void crearJsonFile(List<Videojuego> listavideojuegos) {
        try {
            FileWriter writer = new FileWriter("src/main/resources/videojuegos.json");
            gson.toJson(listavideojuegos, writer);
            writer.close();
            System.out.println("Hecho");
        } catch (IOException e) {
            System.out.println("mal");
            e.printStackTrace();
        }
    }

    static List<Videojuego> crearLista() {
        String nombre;
        String plataforma;
        double precio;
        boolean disponible;
        List<String> lista;
        String pDef;
        int vueltasGeneros;
        ArrayList<Videojuego> listaVideojuegos = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            System.out.println("Datos del juego número " + (i + 1));
            System.out.print("Nombre: ");
            nombre = teclado.nextLine();
            System.out.print("Plataforma: ");
            plataforma = teclado.nextLine();
            System.out.print("Precio: ");
            precio = teclado.nextDouble();
            teclado.nextLine();
            System.out.print("Disponibilidad (S/N): ");
            pDef = teclado.nextLine().toUpperCase();

            if (pDef.equals("S")) {
                disponible = true;
            } else {
                disponible = false;
            }

            lista = new ArrayList<>();
            System.out.print("Cuántos géneros? ");
            vueltasGeneros = teclado.nextInt();
            teclado.nextLine();

            for (int j = 0; j < vueltasGeneros; j++) {
                System.out.print("Género " + (j + 1) + ": ");
                lista.add(teclado.nextLine());
            }

            Videojuego videojuego = new Videojuego(nombre, plataforma, precio, disponible, lista);
            listaVideojuegos.add(videojuego);
        }

        return listaVideojuegos;
    }

    static Videojuego pedirUnVideojuego() {
        String nombre;
        String plataforma;
        double precio;
        boolean disponible;
        List<String> lista;
        String pDef;
        int vueltasGeneros;

        System.out.print("Nombre: ");
        nombre = teclado.nextLine();
        System.out.print("Plataforma: ");
        plataforma = teclado.nextLine();
        System.out.print("Precio: ");
        precio = teclado.nextDouble();
        teclado.nextLine();
        System.out.print("Disponibilidad (S/N): ");
        pDef = teclado.nextLine().toUpperCase();

        if (pDef.equals("S")) {
            disponible = true;
        } else {
            disponible = false;
        }

        lista = new ArrayList<>();
        System.out.print("Cuántos géneros? ");
        vueltasGeneros = teclado.nextInt();
        teclado.nextLine();

        for (int j = 0; j < vueltasGeneros; j++) {
            System.out.print("Género " + (j + 1) + ": ");
            lista.add(teclado.nextLine());
        }

        return new Videojuego(nombre, plataforma, precio, disponible, lista);
    }
}
