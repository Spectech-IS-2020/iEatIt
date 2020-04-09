package mx.spechtech.ieatlt.modelo;

import javax.persistence.*;
import java.util.LinkedList;
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

    public Direccion(String direccion, Cliente cliente) {
        this.direccion = direccion;
        clientes = new LinkedList<>();
        clientes.add(cliente);
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
