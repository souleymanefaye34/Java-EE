package entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Locataire {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "nom", nullable = true, length = 255)
    private String nom;
    @Basic
    @Column(name = "prenom", nullable = true, length = 255)
    private String prenom;
    @Basic
    @Column(name = "email", nullable = true, length = 255)
    private String email;
    @Basic
    @Column(name = "telephone", nullable = true, length = 20)
    private String telephone;
    @Basic
    @Column(name = "motDePasse", nullable = true, length = 255)
    private String motDePasse;
    @OneToMany(mappedBy = "locataireByLocataireId")
    private Collection<Contratdelocation> contratdelocationsById;
    @OneToMany(mappedBy = "locataireByLocataireId_0")
    private Collection<Contratdelocation> contratdelocationsById_0;

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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Locataire locataire = (Locataire) o;

        if (id != locataire.id) return false;
        if (nom != null ? !nom.equals(locataire.nom) : locataire.nom != null) return false;
        if (prenom != null ? !prenom.equals(locataire.prenom) : locataire.prenom != null) return false;
        if (email != null ? !email.equals(locataire.email) : locataire.email != null) return false;
        if (telephone != null ? !telephone.equals(locataire.telephone) : locataire.telephone != null) return false;
        if (motDePasse != null ? !motDePasse.equals(locataire.motDePasse) : locataire.motDePasse != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (motDePasse != null ? motDePasse.hashCode() : 0);
        return result;
    }

    public Collection<Contratdelocation> getContratdelocationsById() {
        return contratdelocationsById;
    }

    public void setContratdelocationsById(Collection<Contratdelocation> contratdelocationsById) {
        this.contratdelocationsById = contratdelocationsById;
    }

    public Collection<Contratdelocation> getContratdelocationsById_0() {
        return contratdelocationsById_0;
    }

    public void setContratdelocationsById_0(Collection<Contratdelocation> contratdelocationsById_0) {
        this.contratdelocationsById_0 = contratdelocationsById_0;
    }
}
