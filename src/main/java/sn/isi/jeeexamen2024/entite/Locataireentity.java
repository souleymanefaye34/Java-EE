package sn.isi.jeeexamen2024.entite;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "locataire", schema = "jee-exam", catalog = "")
public class Locataireentity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "Nom")
    private String nom;
    @Basic
    @Column(name = "Prenom")
    private String prenom;
    @Basic
    @Column(name = "Date_de_naissance")
    private Date dateDeNaissance;
    @Basic
    @Column(name = "Adresse")
    private String adresse;
    @Basic
    @Column(name = "Telephone")
    private String telephone;
    @OneToMany(mappedBy = "locataireByIdLocataire")
    private Collection<ContratDeLocationentity> contratDeLocationsById;

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

    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Locataireentity that = (Locataireentity) o;

        if (id != that.id) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (prenom != null ? !prenom.equals(that.prenom) : that.prenom != null) return false;
        if (dateDeNaissance != null ? !dateDeNaissance.equals(that.dateDeNaissance) : that.dateDeNaissance != null)
            return false;
        if (adresse != null ? !adresse.equals(that.adresse) : that.adresse != null) return false;
        if (telephone != null ? !telephone.equals(that.telephone) : that.telephone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (dateDeNaissance != null ? dateDeNaissance.hashCode() : 0);
        result = 31 * result + (adresse != null ? adresse.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        return result;
    }

    public Collection<ContratDeLocationentity> getContratDeLocationsById() {
        return contratDeLocationsById;
    }

    public void setContratDeLocationsById(Collection<ContratDeLocationentity> contratDeLocationsById) {
        this.contratDeLocationsById = contratDeLocationsById;
    }
}
