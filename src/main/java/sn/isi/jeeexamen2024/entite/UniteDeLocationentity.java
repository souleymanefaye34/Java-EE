package sn.isi.jeeexamen2024.entite;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;

@jakarta.persistence.Entity
@Entity
@Table(name = "unite_de_location", schema = "jee-exam")
@jakarta.persistence.Table(name = "unite_de_location", schema = "jee-exam", catalog = "")
public class UniteDeLocationentity {
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @jakarta.persistence.Column(name = "ID")
    private int id;

    @jakarta.persistence.Basic
    @Basic
    @Column(name = "Numero")
    @jakarta.persistence.Column(name = "Numero")
    private String numero;

    @jakarta.persistence.Basic
    @Basic
    @Column(name = "Surface")
    @jakarta.persistence.Column(name = "Surface")
    private BigDecimal surface;

    @jakarta.persistence.Basic
    @jakarta.persistence.Column(name = "nbr_piece")
    private String nbrPiece;
    @jakarta.persistence.Basic
    @jakarta.persistence.Column(name = "loyer")
    private String loyer;

    @jakarta.persistence.Basic
    @Basic
    @Column(name = "ID_Immeuble", insertable = false, updatable = false)
    @jakarta.persistence.Column(name = "ID_Immeuble")
    private Integer idImmeuble;

    @jakarta.persistence.OneToMany(mappedBy = "uniteDeLocationByIdUnite")
    @OneToMany(mappedBy = "uniteDeLocationByIdUnite", cascade = CascadeType.ALL)
    private Collection<ContratDeLocationentity> contratDeLocationsById;

    @jakarta.persistence.ManyToOne
    @ManyToOne
    @JoinColumn(name = "ID_Immeuble", referencedColumnName = "ID")
    @jakarta.persistence.JoinColumn(name = "ID_Immeuble", referencedColumnName = "ID")
    private Immeubleentity immeubleByIdImmeuble;


    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public BigDecimal getSurface() {
        return surface;
    }

    public void setSurface(BigDecimal surface) {
        this.surface = surface;
    }


    public Integer getIdImmeuble() {
        return idImmeuble;
    }

    public void setIdImmeuble(Integer idImmeuble) {
        this.idImmeuble = idImmeuble;
    }

    public Collection<ContratDeLocationentity> getContratDeLocationsById() {
        return contratDeLocationsById;
    }

    public void setContratDeLocationsById(Collection<ContratDeLocationentity> contratDeLocationsById) {
        this.contratDeLocationsById = contratDeLocationsById;
    }

    public Immeubleentity getImmeubleByIdImmeuble() {
        return immeubleByIdImmeuble;
    }

    public void setImmeubleByIdImmeuble(Immeubleentity immeubleByIdImmeuble) {
        this.immeubleByIdImmeuble = immeubleByIdImmeuble;
    }

    public String getNbrPiece() {
        return nbrPiece;
    }

    public void setNbrPiece(String nbrPiece) {
        this.nbrPiece = nbrPiece;
    }

    public String getLoyer() {
        return loyer;
    }

    public void setLoyer(String loyer) {
        this.loyer = loyer;
    }

}
