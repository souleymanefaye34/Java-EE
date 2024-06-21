package sn.isi.jeeexamen2024.entite;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "contrat_de_location", schema = "jee-exam")
public class ContratDeLocationentity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Basic
    @Column(name = "Date_debut")
    private Date dateDebut;

    @Basic
    @Column(name = "Date_fin")
    private Date dateFin;

    @Basic
    @Column(name = "Loyer_mensuel")
    private BigDecimal loyerMensuel;

    @Basic
    @Column(name = "ID_Unite", insertable = false, updatable = false)
    private Integer idUnite;

    @Basic
    @Column(name = "ID_Locataire", insertable = false, updatable = false)
    private Integer idLocataire;

    @ManyToOne
    @JoinColumn(name = "ID_Unite", referencedColumnName = "ID")
    private UniteDeLocationentity uniteDeLocationByIdUnite;

    @ManyToOne
    @JoinColumn(name = "ID_Locataire", referencedColumnName = "ID")
    private Locataireentity locataireByIdLocataire;

    @OneToMany(mappedBy = "contratDeLocationByIdContrat", cascade = CascadeType.ALL)
    private Collection<Paiemententity> paiementsById;

    // Getters and Setters
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

    public BigDecimal getLoyerMensuel() {
        return loyerMensuel;
    }

    public void setLoyerMensuel(BigDecimal loyerMensuel) {
        this.loyerMensuel = loyerMensuel;
    }

    public Integer getIdUnite() {
        return idUnite;
    }

    public void setIdUnite(Integer idUnite) {
        this.idUnite = idUnite;
    }

    public Integer getIdLocataire() {
        return idLocataire;
    }

    public void setIdLocataire(Integer idLocataire) {
        this.idLocataire = idLocataire;
    }

    public UniteDeLocationentity getUniteDeLocationByIdUnite() {
        return uniteDeLocationByIdUnite;
    }

    public void setUniteDeLocationByIdUnite(UniteDeLocationentity uniteDeLocationByIdUnite) {
        this.uniteDeLocationByIdUnite = uniteDeLocationByIdUnite;
    }

    public Locataireentity getLocataireByIdLocataire() {
        return locataireByIdLocataire;
    }

    public void setLocataireByIdLocataire(Locataireentity locataireByIdLocataire) {
        this.locataireByIdLocataire = locataireByIdLocataire;
    }

    public Collection<Paiemententity> getPaiementsById() {
        return paiementsById;
    }

    public void setPaiementsById(Collection<Paiemententity> paiementsById) {
        this.paiementsById = paiementsById;
    }

}
