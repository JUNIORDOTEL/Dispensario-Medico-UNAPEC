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
@Table(name = "Marcas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Marcas.findAll", query = "SELECT m FROM Marcas m")
    , @NamedQuery(name = "Marcas.findByMarcaID", query = "SELECT m FROM Marcas m WHERE m.marcaID = :marcaID")
    , @NamedQuery(name = "Marcas.findByDescripcion", query = "SELECT m FROM Marcas m WHERE m.descripcion = :descripcion")
    , @NamedQuery(name = "Marcas.findByEstado", query = "SELECT m FROM Marcas m WHERE m.estado = :estado")})
public class Marcas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MarcaID")
    private Integer marcaID;
    @Size(max = 50)
    @Column(name = "Descripcion")
    private String descripcion;
    @Size(max = 50)
    @Column(name = "Estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "marcaID")
    private Collection<Medicamentos> medicamentosCollection;

    public Marcas() {
    }

    public Marcas(Integer marcaID) {
        this.marcaID = marcaID;
    }

    public Integer getMarcaID() {
        return marcaID;
    }

    public void setMarcaID(Integer marcaID) {
        this.marcaID = marcaID;
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
        hash += (marcaID != null ? marcaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Marcas)) {
            return false;
        }
        Marcas other = (Marcas) object;
        if ((this.marcaID == null && other.marcaID != null) || (this.marcaID != null && !this.marcaID.equals(other.marcaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Marcas[ marcaID=" + marcaID + " ]";
    }
    
}
