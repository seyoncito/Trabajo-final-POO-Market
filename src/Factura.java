import java.util.ArrayList;
import java.util.List;

public class Factura {
    private String cliente;
    private List<String> items;
    private double total;

    public Factura(String cliente) {
        this.cliente = cliente;
        this.items = new ArrayList<>();
        this.total = 0.0;
    }

    public void agregarItem(String descripcion, double precio) {
        items.add(descripcion + " - S/ " + precio);
        total += precio;
    }

    public String getCliente() {
        return cliente;
    }

    public List<String> getItems() {
        return items;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Factura para: " + cliente + " - Total: S/ " + total;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
}
