package Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;

@Entity
public class Reservations {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "date_reservation")
    private Timestamp dateReservation;
    @Basic
    @Column(name = "estannulee")
    private boolean estannulee;
    @Basic
    @Column(name = "tariftotalmad")
    private double tariftotalmad;
    @Basic
    @Column(name = "tariftotaleuro")
    private double tariftotaleuro;
    @Basic
    @Column(name = "id_client")
    private int idClient;
    @Basic
    @Column(name = "id_escale")
    private Integer idEscale;
    @OneToMany(mappedBy = "reservationsByIdReservation")
    private Collection<ExtrasReservation> extrasReservationsById;
    @ManyToOne
   // @JoinColumn(name = "id_client", referencedColumnName = "id", nullable = false)
    private Clients clientsByIdClient;
    @ManyToOne
    @JoinColumn(name = "id_escale", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)

    private Escales escalesByIdEscale;
    @OneToMany(mappedBy = "reservationsByIdReservation")
    private Collection<VolsReservation> volsReservationsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Timestamp getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Timestamp dateReservation) {
        this.dateReservation = dateReservation;
    }

    public boolean isEstannulee() {
        return estannulee;
    }

    public void setEstannulee(boolean estannulee) {
        this.estannulee = estannulee;
    }

    public double getTariftotalmad() {
        return tariftotalmad;
    }

    public void setTariftotalmad(double tariftotalmad) {
        this.tariftotalmad = tariftotalmad;
    }

    public double getTariftotaleuro() {
        return tariftotaleuro;
    }

    public void setTariftotaleuro(double tariftotaleuro) {
        this.tariftotaleuro = tariftotaleuro;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
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

        Reservations that = (Reservations) o;

        if (id != that.id) return false;
        if (estannulee != that.estannulee) return false;
        if (Double.compare(tariftotalmad, that.tariftotalmad) != 0) return false;
        if (Double.compare(tariftotaleuro, that.tariftotaleuro) != 0) return false;
        if (idClient != that.idClient) return false;
        if (dateReservation != null ? !dateReservation.equals(that.dateReservation) : that.dateReservation != null)
            return false;
        if (idEscale != null ? !idEscale.equals(that.idEscale) : that.idEscale != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (dateReservation != null ? dateReservation.hashCode() : 0);
        result = 31 * result + (estannulee ? 1 : 0);
        temp = Double.doubleToLongBits(tariftotalmad);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(tariftotaleuro);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + idClient;
        result = 31 * result + (idEscale != null ? idEscale.hashCode() : 0);
        return result;
    }

    public Collection<ExtrasReservation> getExtrasReservationsById() {
        return extrasReservationsById;
    }

    public void setExtrasReservationsById(Collection<ExtrasReservation> extrasReservationsById) {
        this.extrasReservationsById = extrasReservationsById;
    }

    public Clients getClientsByIdClient() {
        return clientsByIdClient;
    }

    public void setClientsByIdClient(Clients clientsByIdClient) {
        this.clientsByIdClient = clientsByIdClient;
    }

    public Escales getEscalesByIdEscale() {
        return escalesByIdEscale;
    }

    public void setEscalesByIdEscale(Escales escalesByIdEscale) {
        this.escalesByIdEscale = escalesByIdEscale;
    }

    public Collection<VolsReservation> getVolsReservationsById() {
        return volsReservationsById;
    }

    public void setVolsReservationsById(Collection<VolsReservation> volsReservationsById) {
        this.volsReservationsById = volsReservationsById;
    }
}
