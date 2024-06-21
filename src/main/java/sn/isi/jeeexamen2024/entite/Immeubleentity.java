package sn.isi.jeeexamen2024.entite;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "immeuble", schema = "jee-exam")
public class Immeubleentity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Basic
    @Column(name = "Adresse")
    private String adresse;

    @Basic
    @Column(name = "Nom")
    private String nom;

    @Basic
    @Column(name = "description")
    private String description;

    @Basic
    @Column(name = "équipements")
    private String équipements;

    @OneToMany(mappedBy = "immeubleByIdImmeuble")
    private Collection<UniteDeLocationentity> uniteDeLocationsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getÉquipements() {
        return équipements;
    }

    public void setÉquipements(String équipements) {
        this.équipements = équipements;
    }

    public Collection<UniteDeLocationentity> getUniteDeLocationsById() {
        return uniteDeLocationsById;
    }

    public void setUniteDeLocationsById(Collection<UniteDeLocationentity> uniteDeLocationsById) {
        this.uniteDeLocationsById = uniteDeLocationsById;
    }

}
