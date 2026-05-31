package practica3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Actividad6 {
        static void main() {

//        try {
//            BufferedReader lector = new BufferedReader(new FileReader("src/main/resources/datos.txt"));
//            String linea;
//
//            while ((linea = lector.readLine()) != null) {
//                System.out.println(linea);
//            }
//
//            lector.close();
//
//        }catch (IOException e){
//            System.out.println(e.getStackTrace());
//            throw new RuntimeException(e);
//        }
            contarPalabras("prueba");
            contarPalabrasSC("actividad");
        }

        public static void contarPalabras(String palabra){

            HashMap<String,Integer> mapa = new HashMap<>();

            try {
                BufferedReader lector = new BufferedReader(new FileReader("src/main/resources/ejemplo1.txt"));
                String linea;

                while ((linea = lector.readLine()) != null) {

                    for (String palabra1 : linea.split(" ")){

                        if (mapa.containsKey(palabra1)){
                            mapa.put(palabra1, mapa.get(palabra1)+1);
                        }else {
                            mapa.put(palabra1,1);
                        }
                    }
                }

                System.out.println(mapa.get(palabra));

                lector.close();

            }catch (IOException e){
                System.out.println(e.getStackTrace());
                throw new RuntimeException(e);
            }

        }

        public static void contarPalabrasSC(String palabra){

            HashMap<String,Integer> mapa = new HashMap<>();

            try {
                File archivo = new File("src/main/resources/ejemplo1.txt");
                Scanner lector = new Scanner(archivo);

                while (lector.hasNextLine()) {

                    String linea = lector.nextLine();

                    for (String palabra2 : linea.split(" ")){
                        if (mapa.containsKey(palabra2)){
                            mapa.put(palabra2, mapa.get(palabra2)+1);
                        }else {
                            mapa.put(palabra2,1);
                        }
                    }
                }
                System.out.println(mapa.get(palabra));
                lector.close();

            }catch (IOException e){
                System.out.println(e.getStackTrace());
                throw new RuntimeException(e);
            }
        }
}
