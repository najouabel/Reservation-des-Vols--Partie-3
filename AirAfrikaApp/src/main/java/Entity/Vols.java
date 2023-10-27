package Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;

@Entity
public class Vols {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "ville_depart")
    private String villeDepart;
    @Basic
    @Column(name = "ville_arrivee")
    private String villeArrivee;
    @Basic
    @Column(name = "depart_time")
    private Timestamp departTime;
    @Basic
    @Column(name = "arrive_time")
    private Timestamp arriveTime;
    @Basic
    @Column(name = "nb_place")
    private int nbPlace;
    @Basic
    @Column(name = "type_vols")
    private String typeVols;
    @Basic
    @Column(name = "nb_place_dispo")
    private int nbPlaceDispo;
    @OneToMany(mappedBy = "volsByIdVolProchaine")
    private Collection<Escales> escalesById;
    @OneToMany(mappedBy = "volsByIdVols")
    private Collection<VolsReservation> volsReservationsById;

    @ManyToOne
    @JoinColumn(name = "id_societe", referencedColumnName = "id")
    private Societe id_societe;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVilleDepart() {
        return villeDepart;
    }

    public void setVilleDepart(String villeDepart) {
        this.villeDepart = villeDepart;
    }

    public String getVilleArrivee() {
        return villeArrivee;
    }

    public void setVilleArrivee(String villeArrivee) {
        this.villeArrivee = villeArrivee;
    }

    public Timestamp getDepartTime() {
        return departTime;
    }

    public void setDepartTime(Timestamp departTime) {
        this.departTime = departTime;
    }

    public Timestamp getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Timestamp arriveTime) {
        this.arriveTime = arriveTime;
    }

    public int getNbPlace() {
        return nbPlace;
    }

    public void setNbPlace(int nbPlace) {
        this.nbPlace = nbPlace;
    }

    public String getTypeVols() {
        return typeVols;
    }

    public void setTypeVols(String typeVols) {
        this.typeVols = typeVols;
    }

    public int getNbPlaceDispo() {
        return nbPlaceDispo;
    }

    public void setNbPlaceDispo(int nbPlaceDispo) {
        this.nbPlaceDispo = nbPlaceDispo;
    }

    public Societe getId_societe() {
        return id_societe;
    }

    public void setId_societe(Societe societe) {
        this.id_societe = societe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vols vols = (Vols) o;

        if (id != vols.id) return false;
        if (nbPlace != vols.nbPlace) return false;
        if (nbPlaceDispo != vols.nbPlaceDispo) return false;
        if (villeDepart != null ? !villeDepart.equals(vols.villeDepart) : vols.villeDepart != null) return false;
        if (villeArrivee != null ? !villeArrivee.equals(vols.villeArrivee) : vols.villeArrivee != null) return false;
        if (departTime != null ? !departTime.equals(vols.departTime) : vols.departTime != null) return false;
        if (arriveTime != null ? !arriveTime.equals(vols.arriveTime) : vols.arriveTime != null) return false;
        if (typeVols != null ? !typeVols.equals(vols.typeVols) : vols.typeVols != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (villeDepart != null ? villeDepart.hashCode() : 0);
        result = 31 * result + (villeArrivee != null ? villeArrivee.hashCode() : 0);
        result = 31 * result + (departTime != null ? departTime.hashCode() : 0);
        result = 31 * result + (arriveTime != null ? arriveTime.hashCode() : 0);
        result = 31 * result + nbPlace;
        result = 31 * result + (typeVols != null ? typeVols.hashCode() : 0);
        result = 31 * result + nbPlaceDispo;
        return result;
    }

    public Collection<Escales> getEscalesById() {
        return escalesById;
    }

    public void setEscalesById(Collection<Escales> escalesById) {
        this.escalesById = escalesById;
    }

    public Collection<VolsReservation> getVolsReservationsById() {
        return volsReservationsById;
    }

    public void setVolsReservationsById(Collection<VolsReservation> volsReservationsById) {
        this.volsReservationsById = volsReservationsById;
    }


}
