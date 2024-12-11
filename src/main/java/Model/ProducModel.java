package Model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProducModel {
    private Connection connection;
    private List<Producto> products;

    public ProducModel() {
        products = new ArrayList<>();
        connection = conecpostgres.obtenerConexion();
    }
/*
    public void addProduct(Producto product) {
        products.add(product);
    }
     */

    public List<Producto> getProducts() {
        return products;
    }
    public void agregarproducto(Producto producto){

        try {

            String query = "INSERT INTO tb_productos(tb_producto_id,tb_producto_nom, tb_producto_pric) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, producto.getId());
            statement.setString(2, producto.getName());
            statement.setDouble(3, producto.getPrice());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al agregar Producto: " + e.getMessage());
        }
    }
    public void cerrarConexion() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}
