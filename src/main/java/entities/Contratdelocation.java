package entities;

import jakarta.persistence.*;

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
    @Column(name = "unite_id", nullable = true)
    private Integer uniteId;
    @Basic
    @Column(name = "locataire_id", nullable = true)
    private Integer locataireId;
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
    @JoinColumn(name = "unite_id", referencedColumnName = "id")
    private Unitedelocation unitedelocationByUniteId_0;
    @ManyToOne
    @JoinColumn(name = "locataire_id", referencedColumnName = "id")
    private Locataire locataireByLocataireId;
    @ManyToOne
    @JoinColumn(name = "locataire_id", referencedColumnName = "id")
    private Locataire locataireByLocataireId_0;
    @OneToMany(mappedBy = "contratdelocationByContratId")
    private Collection<Paiement> paiementsById;
    @OneToMany(mappedBy = "contratdelocationByContratId_0")
    private Collection<Paiement> paiementsById_0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getUniteId() {
        return uniteId;
    }

    public void setUniteId(Integer uniteId) {
        this.uniteId = uniteId;
    }

    public Integer getLocataireId() {
        return locataireId;
    }

    public void setLocataireId(Integer locataireId) {
        this.locataireId = locataireId;
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
        if (uniteId != null ? !uniteId.equals(that.uniteId) : that.uniteId != null) return false;
        if (locataireId != null ? !locataireId.equals(that.locataireId) : that.locataireId != null) return false;
        if (dateDebut != null ? !dateDebut.equals(that.dateDebut) : that.dateDebut != null) return false;
        if (dateFin != null ? !dateFin.equals(that.dateFin) : that.dateFin != null) return false;
        if (montant != null ? !montant.equals(that.montant) : that.montant != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (uniteId != null ? uniteId.hashCode() : 0);
        result = 31 * result + (locataireId != null ? locataireId.hashCode() : 0);
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

    public Unitedelocation getUnitedelocationByUniteId_0() {
        return unitedelocationByUniteId_0;
    }

    public void setUnitedelocationByUniteId_0(Unitedelocation unitedelocationByUniteId_0) {
        this.unitedelocationByUniteId_0 = unitedelocationByUniteId_0;
    }

    public Locataire getLocataireByLocataireId() {
        return locataireByLocataireId;
    }

    public void setLocataireByLocataireId(Locataire locataireByLocataireId) {
        this.locataireByLocataireId = locataireByLocataireId;
    }

    public Locataire getLocataireByLocataireId_0() {
        return locataireByLocataireId_0;
    }

    public void setLocataireByLocataireId_0(Locataire locataireByLocataireId_0) {
        this.locataireByLocataireId_0 = locataireByLocataireId_0;
    }

    public Collection<Paiement> getPaiementsById() {
        return paiementsById;
    }

    public void setPaiementsById(Collection<Paiement> paiementsById) {
        this.paiementsById = paiementsById;
    }

    public Collection<Paiement> getPaiementsById_0() {
        return paiementsById_0;
    }

    public void setPaiementsById_0(Collection<Paiement> paiementsById_0) {
        this.paiementsById_0 = paiementsById_0;
    }
}
