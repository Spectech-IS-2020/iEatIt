package mx.spechtech.ieatlt.modelo;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCliente;
    private String nombre;
    @ManyToMany(mappedBy = "clientes")
    List<Direccion> direcciones;

    public Cliente() {}

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public Direccion obtenerDireccionDefault() {
        return direcciones.get(0);
    }
}
