package Model;

public class Producto {
    private String id;
    private String nombre;
    private double precio;

    public Producto(String id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return nombre;
    }

    public void setName(String name) {
        this.nombre = name;
    }

    public double getPrice() {
        return precio;
    }

    public void setPrice(double price) {
        this.precio = price;
    }

    @Override

    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + nombre + '\'' +
                ", price=" + precio +
                '}';
    }
}
