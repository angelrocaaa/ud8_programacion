package BBDD;

import java.sql.*;

public class Main {
        public static void main(String[] args) {

            Connection bd = conexion();
            System.out.println("Realizando consultas...");
            consulta(bd);
            modificar(bd);
            consulta(bd);
            desconectar(bd);

        }

        public static Connection conexion() {
            Connection conexion;
            String host = "jdbc:mariadb://localhost:3310/";
            String user = "root";
            String psw = "";
            String bd = "colegio";
            System.out.println("Conectando...");

            try {
                conexion = DriverManager.getConnection(host+bd,user,psw);
                System.out.println("Conexión realizada con éxito.");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                throw new RuntimeException(e);
            }

            return conexion;
        }

        public static void desconectar(Connection conexion){

            System.out.println("Desconectando...");

            try {
                conexion.close();
                System.out.println("Conexión finalizada.");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                throw new RuntimeException(e);
            }
        }

        public static void consulta(Connection connection) {
            String query = "SELECT * FROM estudiante";

            Statement statement;

            try {
                statement = connection.createStatement();
                ResultSet respuesta = statement.executeQuery(query);

                while (respuesta.next()) {
                    int nia = respuesta.getInt("nia");
                    String nombre = respuesta.getString("nombre");
                    Date fecha_nacimiento = respuesta.getDate("fecha_nacimiento");

                    System.out.println("Estudiante con NIA: " + nia + " nombre " + nombre + " fecha de nacimiento " + fecha_nacimiento);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                throw new RuntimeException(e);
            }
        }

        public static void modificar(Connection connection) {
            String query = "UPDATE estudiante SET nombre='angel' WHERE nia='23434'";

            Statement statement;

            try {
                statement = conexion().createStatement();
                statement.executeQuery(query);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                throw new RuntimeException(e);
            }
        }

}

