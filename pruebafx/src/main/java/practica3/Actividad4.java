package practica3;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Actividad4 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Número de archivos: ");
        int num = teclado.nextInt();
        teclado.nextLine();

        System.out.println("Carpeta en la que crearlo?");
        String carpeta = teclado.nextLine();

        generarArchivos(num,carpeta);
    }

    public static void generarArchivos(int n, String carpeta) {
        File directorio = new File("src/main/resources/" + carpeta);

        if (directorio.mkdir()) {
            System.out.println("Directorio creado");
        } else {
            System.out.println("No se pudo crear el directorio");
        }

        for (int i = 1; i <= n; i++) {
            File archivo = new File(directorio, "nombre(" + i + ").txt");

            try {
                if (archivo.createNewFile()) {
                    System.out.println("Archivo creado");
                } else {
                    System.out.println("El archivo ya existe");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}