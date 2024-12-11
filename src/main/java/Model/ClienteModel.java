package Model;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
public class ClienteModel {
    private Connection connection;
    private List<Cliente> clientes;

    public ClienteModel() {
        clientes = new ArrayList<>();
        connection = conecpostgres.obtenerConexion();
    }
   /* public void addCliente(Cliente cliente) {
        clientes.add(cliente);
    }
        */

    public List<Cliente> getClientes() {
        return clientes;
    }
    public void agregarCliente(Cliente cliente) {

        try {String query = "INSERT INTO tb_clientes (tb_cliente_id, tb_cliente_nom, tb_cliente_apellid,tb_cliente_direc,tb_cliente_ruc) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, cliente.getCodCliente());
            statement.setString(2, cliente.getNombre());
            statement.setString(3, cliente.getApellidoP());
            statement.setString(4, cliente.getDireccion());
            statement.setString(5, cliente.getRuc());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al agregar cliente: " + e.getMessage());
        }
    }

}
