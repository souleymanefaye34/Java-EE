package sn.isi.jeeexamen2024.entite;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "paiement", schema = "jee-exam", catalog = "")
public class Paiemententity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "Date_paiement")
    private Date datePaiement;
    @Basic
    @Column(name = "Montant")
    private BigDecimal montant;
    @Basic
    @Column(name = "ID_Contrat")
    private Integer idContrat;
    @ManyToOne
    @JoinColumn(name = "ID_Contrat", referencedColumnName = "ID")
    private ContratDeLocationentity contratDeLocationByIdContrat;

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

    public Integer getIdContrat() {
        return idContrat;
    }

    public void setIdContrat(Integer idContrat) {
        this.idContrat = idContrat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Paiemententity that = (Paiemententity) o;

        if (id != that.id) return false;
        if (datePaiement != null ? !datePaiement.equals(that.datePaiement) : that.datePaiement != null) return false;
        if (montant != null ? !montant.equals(that.montant) : that.montant != null) return false;
        if (idContrat != null ? !idContrat.equals(that.idContrat) : that.idContrat != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (datePaiement != null ? datePaiement.hashCode() : 0);
        result = 31 * result + (montant != null ? montant.hashCode() : 0);
        result = 31 * result + (idContrat != null ? idContrat.hashCode() : 0);
        return result;
    }

    public ContratDeLocationentity getContratDeLocationByIdContrat() {
        return contratDeLocationByIdContrat;
    }

    public void setContratDeLocationByIdContrat(ContratDeLocationentity contratDeLocationByIdContrat) {
        this.contratDeLocationByIdContrat = contratDeLocationByIdContrat;
    }
}
