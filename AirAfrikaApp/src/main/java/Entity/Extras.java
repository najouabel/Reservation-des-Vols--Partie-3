package Entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Extras {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "tarifmad")
    private double tarifmad;
    @Basic
    @Column(name = "tarifeuro")
    private double tarifeuro;
    @Basic
    @Column(name = "id_escale")
    private Integer idEscale;
    @ManyToOne
   // @JoinColumn(name = "id_escale", referencedColumnName = "id")
    private Escales escalesByIdEscale;
    @OneToMany(mappedBy = "extrasByIdExtra")
    private Collection<ExtrasReservation> extrasReservationsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTarifmad() {
        return tarifmad;
    }

    public void setTarifmad(double tarifmad) {
        this.tarifmad = tarifmad;
    }

    public double getTarifeuro() {
        return tarifeuro;
    }

    public void setTarifeuro(double tarifeuro) {
        this.tarifeuro = tarifeuro;
    }

    public Integer getIdEscale() {
        return idEscale;
    }

    public void setIdEscale(Integer idEscale) {
        this.idEscale = idEscale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Extras extras = (Extras) o;

        if (id != extras.id) return false;
        if (Double.compare(tarifmad, extras.tarifmad) != 0) return false;
        if (Double.compare(tarifeuro, extras.tarifeuro) != 0) return false;
        if (name != null ? !name.equals(extras.name) : extras.name != null) return false;
        if (idEscale != null ? !idEscale.equals(extras.idEscale) : extras.idEscale != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(tarifmad);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(tarifeuro);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (idEscale != null ? idEscale.hashCode() : 0);
        return result;
    }

    public Escales getEscalesByIdEscale() {
        return escalesByIdEscale;
    }

    public void setEscalesByIdEscale(Escales escalesByIdEscale) {
        this.escalesByIdEscale = escalesByIdEscale;
    }

    public Collection<ExtrasReservation> getExtrasReservationsById() {
        return extrasReservationsById;
    }

    public void setExtrasReservationsById(Collection<ExtrasReservation> extrasReservationsById) {
        this.extrasReservationsById = extrasReservationsById;
    }
}
