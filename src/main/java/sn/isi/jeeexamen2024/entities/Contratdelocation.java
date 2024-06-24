package sn.isi.jeeexamen2024.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Contratdelocation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "date_debut", nullable = true)
    private Date dateDebut;

    @Basic
    @Column(name = "date_fin", nullable = true)
    private Date dateFin;

    @Basic
    @Column(name = "montant", nullable = true, precision = 2)
    private BigDecimal montant;

    @ManyToOne
    @JoinColumn(name = "unite_id", referencedColumnName = "id")
    private Unitedelocation unitedelocationByUniteId;

    @ManyToOne
    @JoinColumn(name = "locataire_id", referencedColumnName = "id")
    private Locataire locataireByLocataireId;

    @OneToMany(mappedBy = "contratdelocationByContratId")
    private Collection<Paiement> paiementsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contratdelocation that = (Contratdelocation) o;

        if (id != that.id) return false;
        if (dateDebut != null ? !dateDebut.equals(that.dateDebut) : that.dateDebut != null) return false;
        if (dateFin != null ? !dateFin.equals(that.dateFin) : that.dateFin != null) return false;
        return montant != null ? montant.equals(that.montant) : that.montant == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (dateDebut != null ? dateDebut.hashCode() : 0);
        result = 31 * result + (dateFin != null ? dateFin.hashCode() : 0);
        result = 31 * result + (montant != null ? montant.hashCode() : 0);
        return result;
    }

    public Unitedelocation getUnitedelocationByUniteId() {
        return unitedelocationByUniteId;
    }

    public void setUnitedelocationByUniteId(Unitedelocation unitedelocationByUniteId) {
        this.unitedelocationByUniteId = unitedelocationByUniteId;
    }

    public Locataire getLocataireByLocataireId() {
        return locataireByLocataireId;
    }

    public void setLocataireByLocataireId(Locataire locataireByLocataireId) {
        this.locataireByLocataireId = locataireByLocataireId;
    }

    public Collection<Paiement> getPaiementsById() {
        return paiementsById;
    }

    public void setPaiementsById(Collection<Paiement> paiementsById) {
        this.paiementsById = paiementsById;
    }
}