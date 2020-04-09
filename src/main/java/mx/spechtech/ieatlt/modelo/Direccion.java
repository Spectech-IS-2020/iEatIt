package mx.spechtech.ieatlt.modelo;

import javax.persistence.*;
import java.util.List;

@Entity
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idDireccion;
    private String direccion;
    @ManyToMany
    private List<Cliente> clientes;

    public Direccion() {}

    public Direccion(String direccion, List<Cliente> clientes) {
        this.direccion = direccion;
        this.clientes = clientes;
    }

    public int getIdDireccion() {
        return idDireccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
}
