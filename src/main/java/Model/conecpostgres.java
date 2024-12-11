package Model;

import java.sql.*;

import static java.lang.Class.forName;

public class conecpostgres {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/Tienda";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "123456";
    private static Connection conectar = null;
    public static Connection obtenerConexion() {
        try {
            Class.forName("org.postgresql.Driver");
            conectar = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            if (conectar != null) {
                System.out.println("Conecto correctamente");
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("No conecto a Base de datos" + e.getMessage());
        }
        return conectar;
    }
    public static void  cerrarConexion(){
        try {
            if (conectar != null) {
                conectar.close();
                System.out.println("Conexión cerrada correctamente");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}
