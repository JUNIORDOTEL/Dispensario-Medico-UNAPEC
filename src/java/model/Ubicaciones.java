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
@Table(name = "Ubicaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ubicaciones.findAll", query = "SELECT u FROM Ubicaciones u")
    , @NamedQuery(name = "Ubicaciones.findByUbicacionID", query = "SELECT u FROM Ubicaciones u WHERE u.ubicacionID = :ubicacionID")
    , @NamedQuery(name = "Ubicaciones.findByDescripcion", query = "SELECT u FROM Ubicaciones u WHERE u.descripcion = :descripcion")
    , @NamedQuery(name = "Ubicaciones.findByEstante", query = "SELECT u FROM Ubicaciones u WHERE u.estante = :estante")
    , @NamedQuery(name = "Ubicaciones.findByTramo", query = "SELECT u FROM Ubicaciones u WHERE u.tramo = :tramo")
    , @NamedQuery(name = "Ubicaciones.findByCelda", query = "SELECT u FROM Ubicaciones u WHERE u.celda = :celda")
    , @NamedQuery(name = "Ubicaciones.findByEstado", query = "SELECT u FROM Ubicaciones u WHERE u.estado = :estado")})
public class Ubicaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "UbicacionID")
    private Integer ubicacionID;
    @Size(max = 50)
    @Column(name = "Descripcion")
    private String descripcion;
    @Size(max = 50)
    @Column(name = "Estante")
    private String estante;
    @Size(max = 50)
    @Column(name = "Tramo")
    private String tramo;
    @Size(max = 50)
    @Column(name = "Celda")
    private String celda;
    @Size(max = 50)
    @Column(name = "Estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ubicacionID")
    private Collection<Medicamentos> medicamentosCollection;

    public Ubicaciones() {
    }

    public Ubicaciones(Integer ubicacionID) {
        this.ubicacionID = ubicacionID;
    }

    public Integer getUbicacionID() {
        return ubicacionID;
    }

    public void setUbicacionID(Integer ubicacionID) {
        this.ubicacionID = ubicacionID;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstante() {
        return estante;
    }

    public void setEstante(String estante) {
        this.estante = estante;
    }

    public String getTramo() {
        return tramo;
    }

    public void setTramo(String tramo) {
        this.tramo = tramo;
    }

    public String getCelda() {
        return celda;
    }

    public void setCelda(String celda) {
        this.celda = celda;
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
        hash += (ubicacionID != null ? ubicacionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ubicaciones)) {
            return false;
        }
        Ubicaciones other = (Ubicaciones) object;
        if ((this.ubicacionID == null && other.ubicacionID != null) || (this.ubicacionID != null && !this.ubicacionID.equals(other.ubicacionID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Ubicaciones[ ubicacionID=" + ubicacionID + " ]";
    }
    
}
