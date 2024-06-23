package entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
public class Paiement {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "contrat_id", nullable = true)
    private Integer contratId;
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
    @JoinColumn(name = "contrat_id", referencedColumnName = "id")
    private Contratdelocation contratdelocationByContratId;
    @ManyToOne
    @JoinColumn(name = "contrat_id", referencedColumnName = "id")
    private Contratdelocation contratdelocationByContratId_0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getContratId() {
        return contratId;
    }

    public void setContratId(Integer contratId) {
        this.contratId = contratId;
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
        if (contratId != null ? !contratId.equals(paiement.contratId) : paiement.contratId != null) return false;
        if (datePaiement != null ? !datePaiement.equals(paiement.datePaiement) : paiement.datePaiement != null)
            return false;
        if (montant != null ? !montant.equals(paiement.montant) : paiement.montant != null) return false;
        if (statut != null ? !statut.equals(paiement.statut) : paiement.statut != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (contratId != null ? contratId.hashCode() : 0);
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

    public Contratdelocation getContratdelocationByContratId_0() {
        return contratdelocationByContratId_0;
    }

    public void setContratdelocationByContratId_0(Contratdelocation contratdelocationByContratId_0) {
        this.contratdelocationByContratId_0 = contratdelocationByContratId_0;
    }
}
