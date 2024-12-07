import java.sql.*;

public class conecpostgres {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/tienda";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "123456";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            System.out.println("Connected to the database!");

            // Create a statement object
            try (Statement stmt = conn.createStatement()) {
                // Execute a query
                try (ResultSet rs = stmt.executeQuery("SELECT * FROM fabricante")) {
                    while (rs.next()) {
                        System.out.println(rs.getString("nombref"));
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }
}
