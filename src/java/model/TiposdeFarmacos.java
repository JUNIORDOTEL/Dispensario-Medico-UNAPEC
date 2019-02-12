/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Junior Dotel
 */
@Entity
@Table(name = "TiposdeFarmacos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposdeFarmacos.findAll", query = "SELECT t FROM TiposdeFarmacos t")
    , @NamedQuery(name = "TiposdeFarmacos.findByTipoFarmacoID", query = "SELECT t FROM TiposdeFarmacos t WHERE t.tipoFarmacoID = :tipoFarmacoID")
    , @NamedQuery(name = "TiposdeFarmacos.findByDescripcion", query = "SELECT t FROM TiposdeFarmacos t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "TiposdeFarmacos.findByEstado", query = "SELECT t FROM TiposdeFarmacos t WHERE t.estado = :estado")})
public class TiposdeFarmacos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TipoFarmacoID")
    private Integer tipoFarmacoID;
    @Size(max = 50)
    @Column(name = "Descripcion")
    private String descripcion;
    @Size(max = 50)
    @Column(name = "Estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoFarmacoID")
    private Collection<Medicamentos> medicamentosCollection;

    public TiposdeFarmacos() {
    }

    public TiposdeFarmacos(Integer tipoFarmacoID) {
        this.tipoFarmacoID = tipoFarmacoID;
    }

    public Integer getTipoFarmacoID() {
        return tipoFarmacoID;
    }

    public void setTipoFarmacoID(Integer tipoFarmacoID) {
        this.tipoFarmacoID = tipoFarmacoID;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<Medicamentos> getMedicamentosCollection() {
        return medicamentosCollection;
    }

    public void setMedicamentosCollection(Collection<Medicamentos> medicamentosCollection) {
        this.medicamentosCollection = medicamentosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoFarmacoID != null ? tipoFarmacoID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposdeFarmacos)) {
            return false;
        }
        TiposdeFarmacos other = (TiposdeFarmacos) object;
        if ((this.tipoFarmacoID == null && other.tipoFarmacoID != null) || (this.tipoFarmacoID != null && !this.tipoFarmacoID.equals(other.tipoFarmacoID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TiposdeFarmacos[ tipoFarmacoID=" + tipoFarmacoID + " ]";
    }
    
}
