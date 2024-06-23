package entities;

import javax.persistence.*;

@Entity
public class Immeuble {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "nom", nullable = false, length = 255)
    private String nom;
    @Basic
    @Column(name = "adresse", nullable = true, length = 255)
    private String adresse;
    @Basic
    @Column(name = "nbr_unite", nullable = false)
    private int nbrUnite;
    @Basic
    @Column(name = "equipement", nullable = false, length = -1)
    private String equipement;

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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getNbrUnite() {
        return nbrUnite;
    }

    public void setNbrUnite(int nbrUnite) {
        this.nbrUnite = nbrUnite;
    }

    public String getEquipement() {
        return equipement;
    }

    public void setEquipement(String equipement) {
        this.equipement = equipement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Immeuble immeuble = (Immeuble) o;

        if (id != immeuble.id) return false;
        if (nbrUnite != immeuble.nbrUnite) return false;
        if (nom != null ? !nom.equals(immeuble.nom) : immeuble.nom != null) return false;
        if (adresse != null ? !adresse.equals(immeuble.adresse) : immeuble.adresse != null) return false;
        if (equipement != null ? !equipement.equals(immeuble.equipement) : immeuble.equipement != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (adresse != null ? adresse.hashCode() : 0);
        result = 31 * result + nbrUnite;
        result = 31 * result + (equipement != null ? equipement.hashCode() : 0);
        return result;
    }
}
