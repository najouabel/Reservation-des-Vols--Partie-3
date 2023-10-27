package Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;

@Entity
public class Escales {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "aeroport")
    private String aeroport;
    @Basic
    @Column(name = "heure")
    private Timestamp heure;
    @Basic
    @Column(name = "id_vol_prochaine")
    private Integer idVolProchaine;
    @Basic
    @Column(name = "id_aeroport")
    private Integer idAeroport;
    @ManyToOne
    //@JoinColumn(name = "id_vol_prochaine", referencedColumnName = "id")
    private Vols volsByIdVolProchaine;
    @ManyToOne
   //@JoinColumn(name = "id_aeroport", referencedColumnName = "id")
    private Aeroport aeroportByIdAeroport;
    @OneToMany(mappedBy = "escalesByIdEscale")
    private Collection<Extras> extrasById;
    @OneToMany(mappedBy = "escalesByIdEscale")
    private Collection<Reservations> reservationsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAeroport() {
        return aeroport;
    }

    public void setAeroport(String aeroport) {
        this.aeroport = aeroport;
    }

    public Timestamp getHeure() {
        return heure;
    }

    public void setHeure(Timestamp heure) {
        this.heure = heure;
    }

    public Integer getIdVolProchaine() {
        return idVolProchaine;
    }

    public void setIdVolProchaine(Integer idVolProchaine) {
        this.idVolProchaine = idVolProchaine;
    }

    public Integer getIdAeroport() {
        return idAeroport;
    }

    public void setIdAeroport(Integer idAeroport) {
        this.idAeroport = idAeroport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Escales escales = (Escales) o;

        if (id != escales.id) return false;
        if (aeroport != null ? !aeroport.equals(escales.aeroport) : escales.aeroport != null) return false;
        if (heure != null ? !heure.equals(escales.heure) : escales.heure != null) return false;
        if (idVolProchaine != null ? !idVolProchaine.equals(escales.idVolProchaine) : escales.idVolProchaine != null)
            return false;
        if (idAeroport != null ? !idAeroport.equals(escales.idAeroport) : escales.idAeroport != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (aeroport != null ? aeroport.hashCode() : 0);
        result = 31 * result + (heure != null ? heure.hashCode() : 0);
        result = 31 * result + (idVolProchaine != null ? idVolProchaine.hashCode() : 0);
        result = 31 * result + (idAeroport != null ? idAeroport.hashCode() : 0);
        return result;
    }

    public Vols getVolsByIdVolProchaine() {
        return volsByIdVolProchaine;
    }

    public void setVolsByIdVolProchaine(Vols volsByIdVolProchaine) {
        this.volsByIdVolProchaine = volsByIdVolProchaine;
    }

    public Aeroport getAeroportByIdAeroport() {
        return aeroportByIdAeroport;
    }

    public void setAeroportByIdAeroport(Aeroport aeroportByIdAeroport) {
        this.aeroportByIdAeroport = aeroportByIdAeroport;
    }

    public Collection<Extras> getExtrasById() {
        return extrasById;
    }

    public void setExtrasById(Collection<Extras> extrasById) {
        this.extrasById = extrasById;
    }

    public Collection<Reservations> getReservationsById() {
        return reservationsById;
    }

    public void setReservationsById(Collection<Reservations> reservationsById) {
        this.reservationsById = reservationsById;
    }
}
