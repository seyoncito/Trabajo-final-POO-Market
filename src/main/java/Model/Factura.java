package Model;

import java.math.BigDecimal;
import java.sql.Date;

public class Factura {
    private String facturaId;
    private long clienteId;
    private Date facturaDate;
    private long productoId;
    private BigDecimal total;

    // Getters and Setters
    public String getFacturaId() {
        return facturaId;
    }

    public void setFacturaId(String facturaId) {
        this.facturaId = facturaId;
    }

    public long getClienteId() {
        return clienteId;
    }

    public void setClienteId(long clienteId) {
        this.clienteId = clienteId;
    }

    public Date getFacturaDate() {
        return facturaDate;
    }

    public void setFacturaDate(Date facturaDate) {
        this.facturaDate = facturaDate;
    }

    public long getProductoId() {
        return productoId;
    }

    public void setProductoId(long productoId) {
        this.productoId = productoId;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Factura ID: " + facturaId + ", Cliente ID: " + clienteId + ", Fecha: " + facturaDate + ", Producto ID: " + productoId + ", Total: " + total;
    }
}
