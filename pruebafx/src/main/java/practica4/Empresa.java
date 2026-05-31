package practica4;

import java.io.*;
import java.util.ArrayList;

public class Empresa {

    public static void main(String[] args) {
        ArrayList<Empleado> listaEmpresa = new ArrayList<>();
        listaEmpresa.add(new Empleado("Ana", 1800.50));
        listaEmpresa.add(new Jefe("Carlos", 3200.00, "Tecnología"));
        listaEmpresa.add(new Empleado("Luis", 1600.00));
        listaEmpresa.add(new Jefe("Marta", 3500.00, "Ventas"));

        File fichero = new File("src/main/resources/personal.ser");

        try {
            ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(fichero));
            escritor.writeObject(listaEmpresa);
            escritor.close();
            System.out.println("Lista de personal serializada.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try {
            ObjectInputStream lector = new ObjectInputStream(new FileInputStream(fichero));
            ArrayList<Empleado> listaRecuperada = (ArrayList<Empleado>) lector.readObject();
            lector.close();
            System.out.println("Lista de personal recuperada:");

            for (Empleado emp : listaRecuperada) {
                if (emp instanceof Jefe) {
                    Jefe jefe = (Jefe) emp;
                    System.out.println("Jefe -> Nombre: " + jefe.getNombre() + ", Salario: " + jefe.getSalario() + "€, Dept: " + jefe.getDepartamento());
                } else {
                    System.out.println("Empleado -> Nombre: " + emp.getNombre() + ", Salario: " + emp.getSalario() + "€");
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}