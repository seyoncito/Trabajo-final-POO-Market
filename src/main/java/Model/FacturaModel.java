package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacturaModel {
    private Connection Conectar;

    public FacturaModel(){
        this.Conectar = conecpostgres.obtenerConexion();
    }

    public String[] getClientes()  {
        String[] clientes = new String[0];

        try {

        Statement stmt = Conectar.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT tb_cliente_id FROM tb_clientes");

        List<String> listaClientes = new ArrayList<>();

        // Recorremos el ResultSet y agregamos los nombres de los clientes a la lista
        while (rs.next()) {
            listaClientes.add(rs.getString("tb_cliente_id"));
        }

        // Convertimos la lista a un arreglo
        clientes = listaClientes.toArray(new String[0]);

        // Cerramos el ResultSet, el Statement y la conexión
        rs.close();
        stmt.close();
    } catch (SQLException e) {
        System.out.println("SQL Exception: " + e.getMessage());
    }
        return clientes;
    }

    public List<Factura> getFacturas() {
        List<Factura> facturas = new ArrayList<>();
        String query = "SELECT factura_id, cliente_id, factura_date, producto_id, total FROM tb_facturas";

        try (Statement stmt = Conectar.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Factura factura = new Factura();
                factura.setFacturaId(rs.getString("factura_id"));
                factura.setClienteId(rs.getLong("cliente_id"));
                factura.setFacturaDate(rs.getDate("factura_date")); // Adjust if you use a different type
                factura.setProductoId(rs.getLong("producto_id"));
                factura.setTotal(rs.getBigDecimal("total"));
                facturas.add(factura);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching facturas: " + e.getMessage());
        }
        return facturas;
    }

}


