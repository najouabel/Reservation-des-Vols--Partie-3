package Entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Aeroport {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "nom")
    private String nom;
    @Basic
    @Column(name = "ville")
    private String ville;
    @OneToMany(mappedBy = "aeroportByIdAeroport")
    private Collection<Escales> escalesById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Aeroport aeroport = (Aeroport) o;

        if (id != aeroport.id) return false;
        if (nom != null ? !nom.equals(aeroport.nom) : aeroport.nom != null) return false;
        if (ville != null ? !ville.equals(aeroport.ville) : aeroport.ville != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (ville != null ? ville.hashCode() : 0);
        return result;
    }

    public Collection<Escales> getEscalesById() {
        return escalesById;
    }

    public void setEscalesById(Collection<Escales> escalesById) {
        this.escalesById = escalesById;
    }
}
