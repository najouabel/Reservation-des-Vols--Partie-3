package Entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Clients {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "code")
    private int code;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "prenom")
    private String prenom;
    @Basic
    @Column(name = "phone")
    private int phone;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "clientsByIdClient")
    private Collection<Paiement> paiementsById;
    @OneToMany(mappedBy = "clientsByIdClient")
    private Collection<Reservations> reservationsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }





    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Clients clients = (Clients) o;

        if (id != clients.id) return false;
        if (code != clients.code) return false;
        if (phone != clients.phone) return false;
        if (name != null ? !name.equals(clients.name) : clients.name != null) return false;
        if (prenom != null ? !prenom.equals(clients.prenom) : clients.prenom != null) return false;
        if (email != null ? !email.equals(clients.email) : clients.email != null) return false;
        if (password != null ? !password.equals(clients.password) : clients.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + code;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + phone;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    public Collection<Paiement> getPaiementsById() {
        return paiementsById;
    }

    public void setPaiementsById(Collection<Paiement> paiementsById) {
        this.paiementsById = paiementsById;
    }

    public Collection<Reservations> getReservationsById() {
        return reservationsById;
    }

    public void setReservationsById(Collection<Reservations> reservationsById) {
        this.reservationsById = reservationsById;
    }
}
