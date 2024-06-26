package sn.isi.jeeexamen2024.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;

@Entity
public class Unitedelocation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "nombreUnite", nullable = false)
    private int nombreUnite;
    @Basic
    @Column(name = "nombre_pieces", nullable = true)
    private Integer nombrePieces;
    @Basic
    @Column(name = "superficie", nullable = true, precision = 0)
    private Double superficie;
    @Basic
    @Column(name = "loyer", nullable = true, precision = 2)
    private BigDecimal loyer;
    @OneToMany(mappedBy = "unitedelocationByUniteId")
    private Collection<Contratdelocation> contratdelocationsById;
    @ManyToOne
    @JoinColumn(name = "immeuble_id", referencedColumnName = "id", nullable = false)
    private Immeuble immeuble;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNombreUnite() {
        return nombreUnite;
    }

    public void setNombreUnite(int nombreUnite) {
        this.nombreUnite = nombreUnite;
    }

    public Integer getNombrePieces() {
        return nombrePieces;
    }

    public void setNombrePieces(Integer nombrePieces) {
        this.nombrePieces = nombrePieces;
    }

    public Double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(Double superficie) {
        this.superficie = superficie;
    }

    public BigDecimal getLoyer() {
        return loyer;
    }

    public void setLoyer(BigDecimal loyer) {
        this.loyer = loyer;
    }
    public Immeuble getImmeuble() {
        return immeuble;
    }

    public void setImmeuble(Immeuble immeuble) {
        this.immeuble = immeuble;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Unitedelocation that = (Unitedelocation) o;

        if (id != that.id) return false;
        if (nombreUnite != that.nombreUnite) return false;
        if (nombrePieces != null ? !nombrePieces.equals(that.nombrePieces) : that.nombrePieces != null) return false;
        if (superficie != null ? !superficie.equals(that.superficie) : that.superficie != null) return false;
        if (loyer != null ? !loyer.equals(that.loyer) : that.loyer != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + nombreUnite;
        result = 31 * result + (nombrePieces != null ? nombrePieces.hashCode() : 0);
        result = 31 * result + (superficie != null ? superficie.hashCode() : 0);
        result = 31 * result + (loyer != null ? loyer.hashCode() : 0);
        return result;
    }

    public Collection<Contratdelocation> getContratdelocationsById() {
        return contratdelocationsById;
    }

    public void setContratdelocationsById(Collection<Contratdelocation> contratdelocationsById) {
        this.contratdelocationsById = contratdelocationsById;
    }


}
