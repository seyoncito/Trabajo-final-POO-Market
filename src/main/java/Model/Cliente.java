package Model;

public class Cliente {
    private String CodCliente;
    private String Nombre;
    private String ApellidoP;
    private String Direccion;
    private String Ruc;

    public Cliente(String codCliente, String nombre,String apellidoP, String direccion, String ruc) {
        this.CodCliente=codCliente;
        this.Nombre=nombre;
        this.ApellidoP=apellidoP;
        this.Direccion=direccion;
        this.Ruc=ruc;

    }

    public String getCodCliente() {
        return CodCliente;
    }

    public void setCodCliente(String codCliente) {
        CodCliente = codCliente;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellidoP() {
        return ApellidoP;
    }

    public void setApellidoP(String apellidoP) {
        ApellidoP = apellidoP;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getRuc() {
        return Ruc;
    }

    public void setRuc(String ruc) {
        Ruc = ruc;
    }

    public String toString() {
        return "Clientes {" +
                "id='" + CodCliente + '\'' +
                ", nombre='" + Nombre + '\'' +
                ", apellido= '"+ApellidoP+ '\''+
                ", direccion =' " + Direccion + '\'' +
                ", ruc= '"+Ruc+ '\''+
                '}';
    }
}
