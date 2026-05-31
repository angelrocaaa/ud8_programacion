package practica3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EjemploPrintWriter {
    static void main(String[] args) {
            try {
                PrintWriter impresor = new PrintWriter(new FileWriter("src/main/resources/salida.txt"));

                impresor.println("Primera línea con println()");
                impresor.flush();
                System.out.println("Datos volcados al fichero con éxito.");

                impresor.printf("Número: %.2f\n", 3.1416);
                impresor.println("Otra línea más.");

                impresor.close();
                System.out.println("El proceso ha finalizado correctamente.");

            } catch (IOException e) {
                System.out.println("Error al intentar escribir en el archivo de texto.");
                e.printStackTrace();
            }

    }
}
