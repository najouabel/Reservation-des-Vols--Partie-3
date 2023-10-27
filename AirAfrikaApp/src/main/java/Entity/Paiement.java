package Entity;

import jakarta.persistence.*;

@Entity
public class Paiement {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "tarifmad")
    private double tarifmad;
    @Basic
    @Column(name = "tarifeuro")
    private double tarifeuro;
    @Basic
    @Column(name = "id_client")
    private Integer idClient;
    @ManyToOne
   // @JoinColumn(name = "id_client", referencedColumnName = "id")
    private Clients clientsByIdClient;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Paiement paiement = (Paiement) o;

        if (id != paiement.id) return false;
        if (Double.compare(tarifmad, paiement.tarifmad) != 0) return false;
        if (Double.compare(tarifeuro, paiement.tarifeuro) != 0) return false;
        if (idClient != null ? !idClient.equals(paiement.idClient) : paiement.idClient != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        temp = Double.doubleToLongBits(tarifmad);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(tarifeuro);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (idClient != null ? idClient.hashCode() : 0);
        return result;
    }

    public Clients getClientsByIdClient() {
        return clientsByIdClient;
    }

    public void setClientsByIdClient(Clients clientsByIdClient) {
        this.clientsByIdClient = clientsByIdClient;
    }
}
