package practica3;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        File archivo = new File("src/main/resources/ejemplo1.txt");

        try {
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado: " + archivo.getName());
            } else {
                System.out.println("El archivo " + archivo.getName() + " ya existe.");
            }
        } catch (IOException e) {
            System.out.println("Ha habido algún problema.");
            e.printStackTrace();
        }

        System.out.println("Nombre: " + archivo.getName());
        System.out.println("Longitud: " + archivo.length());
        System.out.println("Ruta absoluta: " + archivo.getAbsolutePath());

        File carpeta = new File("src/main/resources");
        if(carpeta.exists()) System.out.println("La carpeta " + carpeta.getName() + " existe");
        else System.out.println("La carpeta " + carpeta.getName() + " no existe");
        System.out.println("Nombre: " + carpeta.getName());
        System.out.println("Longitud: " + carpeta.length());
        System.out.println("Ruta absoluta: " + carpeta.getAbsolutePath());

    }
}
