package mx.spechtech.ieatlt.modelo;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
// @Table(schema="ieatit", name="alimento")
public class Alimento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // @Column(name="IdAlimento", table="alimento")
    private int id;
    // @Column(name="Nombre", table="alimento")
    private String nombre;
    // @Column(name="Precio", table="alimento")
    private int precio;
    // @Column(name="Descripcion", table="alimento")
    private String descripcion;

    public Alimento() {}

    public Alimento(int id, String nombre, int precio, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getPrecio() {
        return precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
