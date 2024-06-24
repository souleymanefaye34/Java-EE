package sn.isi.jeeexamen2024.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
public class Paiement {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "datePaiement", nullable = true)
    private Date datePaiement;

    @Basic
    @Column(name = "montant", nullable = true, precision = 2)
    private BigDecimal montant;

    @Basic
    @Column(name = "statut", nullable = true, length = 50)
    private String statut;

    @ManyToOne
    @JoinColumn(name = "contrat_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Contratdelocation contratdelocationByContratId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(Date datePaiement) {
        this.datePaiement = datePaiement;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Paiement paiement = (Paiement) o;

        if (id != paiement.id) return false;
        if (datePaiement != null ? !datePaiement.equals(paiement.datePaiement) : paiement.datePaiement != null)
            return false;
        if (montant != null ? !montant.equals(paiement.montant) : paiement.montant != null) return false;
        if (statut != null ? !statut.equals(paiement.statut) : paiement.statut != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (datePaiement != null ? datePaiement.hashCode() : 0);
        result = 31 * result + (montant != null ? montant.hashCode() : 0);
        result = 31 * result + (statut != null ? statut.hashCode() : 0);
        return result;
    }

    public Contratdelocation getContratdelocationByContratId() {
        return contratdelocationByContratId;
    }

    public void setContratdelocationByContratId(Contratdelocation contratdelocationByContratId) {
        this.contratdelocationByContratId = contratdelocationByContratId;
    }
}