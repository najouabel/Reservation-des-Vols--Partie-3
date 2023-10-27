package Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "extras_reservation", schema = "public", catalog = "airafrikaapp")
public class ExtrasReservation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "id_reservation")
    private Integer idReservation;
    @Basic
    @Column(name = "id_extra")
    private Integer idExtra;
    @ManyToOne
    //@JoinColumn(name = "id_reservation", referencedColumnName = "id")
    private Reservations reservationsByIdReservation;
    @ManyToOne
   // @JoinColumn(name = "id_extra", referencedColumnName = "id")
    private Extras extrasByIdExtra;

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

    public Integer getIdExtra() {
        return idExtra;
    }

    public void setIdExtra(Integer idExtra) {
        this.idExtra = idExtra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExtrasReservation that = (ExtrasReservation) o;

        if (id != that.id) return false;
        if (idReservation != null ? !idReservation.equals(that.idReservation) : that.idReservation != null)
            return false;
        if (idExtra != null ? !idExtra.equals(that.idExtra) : that.idExtra != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (idReservation != null ? idReservation.hashCode() : 0);
        result = 31 * result + (idExtra != null ? idExtra.hashCode() : 0);
        return result;
    }

    public Reservations getReservationsByIdReservation() {
        return reservationsByIdReservation;
    }

    public void setReservationsByIdReservation(Reservations reservationsByIdReservation) {
        this.reservationsByIdReservation = reservationsByIdReservation;
    }

    public Extras getExtrasByIdExtra() {
        return extrasByIdExtra;
    }

    public void setExtrasByIdExtra(Extras extrasByIdExtra) {
        this.extrasByIdExtra = extrasByIdExtra;
    }
}
