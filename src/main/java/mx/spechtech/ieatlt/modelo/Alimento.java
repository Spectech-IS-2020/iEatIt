package mx.spechtech.ieatlt.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Alimento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idAlimento;
    private double precio;
    private String nombre;

    public Alimento() {}

    public Alimento(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getIdAlimento() {
        return idAlimento;
    }

    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }
}
