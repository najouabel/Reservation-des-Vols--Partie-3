package Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vols_reservation", schema = "public", catalog = "airafrikaapp")
public class VolsReservation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "id_reservation")
    private Integer idReservation;
    @Basic
    @Column(name = "id_vols")
    private Integer idVols;
    @ManyToOne
   // @JoinColumn(name = "id_reservation", referencedColumnName = "id")
    private Reservations reservationsByIdReservation;
    @ManyToOne
   // @JoinColumn(name = "id_vols", referencedColumnName = "id")
    private Vols volsByIdVols;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Integer getIdVols() {
        return idVols;
    }

    public void setIdVols(Integer idVols) {
        this.idVols = idVols;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VolsReservation that = (VolsReservation) o;

        if (id != that.id) return false;
        if (idReservation != null ? !idReservation.equals(that.idReservation) : that.idReservation != null)
            return false;
        if (idVols != null ? !idVols.equals(that.idVols) : that.idVols != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (idReservation != null ? idReservation.hashCode() : 0);
        result = 31 * result + (idVols != null ? idVols.hashCode() : 0);
        return result;
    }

    public Reservations getReservationsByIdReservation() {
        return reservationsByIdReservation;
    }

    public void setReservationsByIdReservation(Reservations reservationsByIdReservation) {
        this.reservationsByIdReservation = reservationsByIdReservation;
    }

    public Vols getVolsByIdVols() {
        return volsByIdVols;
    }

    public void setVolsByIdVols(Vols volsByIdVols) {
        this.volsByIdVols = volsByIdVols;
    }
}
