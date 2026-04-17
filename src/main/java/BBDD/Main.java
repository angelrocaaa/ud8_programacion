package BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

        public static void main(String[] args) {
            Connection bd = conexion();
        }

        public static Connection conexion() {
            Connection conexion;
            String host = "jdbc:mariadb://localhost:3310/";
            String user = "root";
            String psw = "";
            String bd = "instituto";
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

}
