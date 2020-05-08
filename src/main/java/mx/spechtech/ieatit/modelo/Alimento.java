package mx.spechtech.ieatit.modelo;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
    private float precio;
    // @Column(name="Descripcion", table="alimento")
    private String descripcion;
    @ManyToOne
    private Categoria categoria;

    public Alimento() {}

    public Alimento(int id, String nombre, float precio, String descripcion, Categoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.categoria = categoria;
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

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getPrecio() {
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
