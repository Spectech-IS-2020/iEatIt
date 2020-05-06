package mx.spechtech.ieatlt.modelo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
public class Orden {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String idOrden;
    private Date horaCreacion;
    private Date horaDeEntregaAproximada;
    @Enumerated(EnumType.STRING)
    private Estado estado;
    private double costoTotal;
    @ManyToOne
    private Direccion direccionDeEntrega;
    @ManyToOne
    private Cliente cliente;
    @ManyToMany
    private List<Alimento> alimentos;

    public Orden() {
    }

    public Orden(List<Alimento> alimentos, Cliente cliente, Direccion direccionDeEntrega) {
        this.alimentos = alimentos;
        this.cliente = cliente;
        this.direccionDeEntrega = direccionDeEntrega;
        horaCreacion = new Date();
        asignarHoraDeEntrega();
        estado = Estado.PENDIENTE;
        calculaCostoTotal();
    }

    private void asignarHoraDeEntrega() {
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.MINUTE, 30);
        horaDeEntregaAproximada = calendar.getTime();
    }

    private void calculaCostoTotal() {
        costoTotal = 0;
        for (Alimento a : alimentos) {
            costoTotal += a.getPrecio();
        }
    }

    public String getIdOrden() {
        return idOrden;
    }

    public Date getHoraCreacion() {
        return horaCreacion;
    }

    public Date getHoraDeEntregaAproximada() {
        return horaDeEntregaAproximada;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public Direccion getDireccionDeEntrega() {
        return direccionDeEntrega;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public List<Alimento> getAlimentos() {
        return alimentos;
    }
}
