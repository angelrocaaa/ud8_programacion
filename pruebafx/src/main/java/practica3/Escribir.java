package practica3;
import java.io.*;
import java.util.Scanner;

public class Escribir {

    static void main() {
        File archivo = new File("src/main/resources/ejemplo1.txt");
        ejercicio8();
        ejercicio9(archivo);
        ejercicio10();
    }

    public static void ejercicio8() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Número de archivos: ");
        int num = teclado.nextInt();
        teclado.nextLine();

        System.out.println("Carpeta en la que crearlo?");
        String carpeta = teclado.nextLine();

        File directorio = new File("src/main/resources/" + carpeta);
        if (!directorio.exists()) {
            directorio.mkdir();
        }

        for (int i = 1; i <= num; i++) {
            File archivo = new File(directorio, "nombre(" + i + ").txt");
            BufferedWriter escritor = null;

            try {
                if (archivo.createNewFile()) {
                    escritor = new BufferedWriter(new FileWriter(archivo));
                    System.out.println("Archivo creado");
                    escritor.write("Este es el fichero nombre(" + i + ").txt");
                } else {
                    System.out.println("El archivo ya existe");
                }

                if (escritor != null) {
                    escritor.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void ejercicio9(File archivo) {
        File archivoTemp = new File("src/main/resources/ejemplo1.txt");

        try {
            BufferedReader lector = new BufferedReader(new FileReader(archivo));
            BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoTemp));
            String linea;

            while ((linea = lector.readLine()) != null) {
                if (linea.length() > 0) {
                    escritor.write(linea.substring(0, 1).toUpperCase() + linea.substring(1));
                } else {
                    escritor.write(linea);
                }
                escritor.newLine();
            }
            lector.close();
            escritor.close();

            if (archivo.exists()) {
                archivo.delete();
                archivoTemp.renameTo(archivo);
                System.out.println("Archivo modificado correctamente.");
            } else {
                System.out.println("No se ha podido reemplazar el archivo original.");
            }

        } catch (IOException e) {
            System.out.println("Ha habido algún problema.");
            e.printStackTrace();
        }
    }

    public static void ejercicio10() {
        String rutaFich1 = "src/main/resources/nombre1.txt";
        String rutaFich2 = "src/main/resources/nombre2.txt";

        try {
            BufferedReader reader1 = new BufferedReader(new FileReader(rutaFich1));
            BufferedReader reader2 = new BufferedReader(new FileReader(rutaFich2));
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/combinado.txt"));

            String linea1 = reader1.readLine();
            String linea2 = reader2.readLine();

            String[] pal1 = (linea1 != null) ? linea1.split(" ") : new String[0];
            String[] pal2 = (linea2 != null) ? linea2.split(" ") : new String[0];

            int i = 0, j = 0;
            while (i < pal1.length || j < pal2.length) {
                if (i < pal1.length) {
                    writer.write(pal1[i] + " ");
                    i++;
                }
                if (j < pal2.length) {
                    writer.write(pal2[j] + " ");
                    j++;
                }
            }

            reader1.close();
            reader2.close();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}