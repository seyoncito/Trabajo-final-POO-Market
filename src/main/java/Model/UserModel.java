package Model;

import java.sql.*;



public class UserModel {
    private String username;
    private String password;
    private Connection connection;

    public UserModel(String username, String password) {
        this.username = username;
        this.password = password;
        this.connection = conecpostgres.obtenerConexion();
    }

    public boolean validateCredentials(String inputUsername, String inputPassword) {
        //return inputUsername.equals(username) && inputPassword.equals(password);

        String query = "SELECT login_password FROM logueo WHERE login_username = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, inputUsername);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String storedPassword = rs.getString("login_password");
                return storedPassword.equals(inputPassword); // comparar contraseña
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
        return false; // Username not found or password didn't match
    }
}
