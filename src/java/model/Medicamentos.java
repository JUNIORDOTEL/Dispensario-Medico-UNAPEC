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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Medicamentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicamentos.findAll", query = "SELECT m FROM Medicamentos m")
    , @NamedQuery(name = "Medicamentos.findByMedicamentoID", query = "SELECT m FROM Medicamentos m WHERE m.medicamentoID = :medicamentoID")
    , @NamedQuery(name = "Medicamentos.findByDescripcion", query = "SELECT m FROM Medicamentos m WHERE m.descripcion = :descripcion")
    , @NamedQuery(name = "Medicamentos.findByDosis", query = "SELECT m FROM Medicamentos m WHERE m.dosis = :dosis")
    , @NamedQuery(name = "Medicamentos.findByEstado", query = "SELECT m FROM Medicamentos m WHERE m.estado = :estado")})
public class Medicamentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MedicamentoID")
    private Integer medicamentoID;
    @Size(max = 50)
    @Column(name = "Descripcion")
    private String descripcion;
    @Size(max = 50)
    @Column(name = "Dosis")
    private String dosis;
    @Size(max = 50)
    @Column(name = "Estado")
    private String estado;
    @JoinColumn(name = "MarcaID", referencedColumnName = "MarcaID")
    @ManyToOne(optional = false)
    private Marcas marcaID;
    @JoinColumn(name = "TipoFarmacoID", referencedColumnName = "TipoFarmacoID")
    @ManyToOne(optional = false)
    private TiposdeFarmacos tipoFarmacoID;
    @JoinColumn(name = "UbicacionID", referencedColumnName = "UbicacionID")
    @ManyToOne(optional = false)
    private Ubicaciones ubicacionID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicamentoID")
    private Collection<RegistrodeVisitas> registrodeVisitasCollection;

    public Medicamentos() {
    }

    public Medicamentos(Integer medicamentoID) {
        this.medicamentoID = medicamentoID;
    }

    public Integer getMedicamentoID() {
        return medicamentoID;
    }

    public void setMedicamentoID(Integer medicamentoID) {
        this.medicamentoID = medicamentoID;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Marcas getMarcaID() {
        return marcaID;
    }

    public void setMarcaID(Marcas marcaID) {
        this.marcaID = marcaID;
    }

    public TiposdeFarmacos getTipoFarmacoID() {
        return tipoFarmacoID;
    }

    public void setTipoFarmacoID(TiposdeFarmacos tipoFarmacoID) {
        this.tipoFarmacoID = tipoFarmacoID;
    }

    public Ubicaciones getUbicacionID() {
        return ubicacionID;
    }

    public void setUbicacionID(Ubicaciones ubicacionID) {
        this.ubicacionID = ubicacionID;
    }

    @XmlTransient
    public Collection<RegistrodeVisitas> getRegistrodeVisitasCollection() {
        return registrodeVisitasCollection;
    }

    public void setRegistrodeVisitasCollection(Collection<RegistrodeVisitas> registrodeVisitasCollection) {
        this.registrodeVisitasCollection = registrodeVisitasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (medicamentoID != null ? medicamentoID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicamentos)) {
            return false;
        }
        Medicamentos other = (Medicamentos) object;
        if ((this.medicamentoID == null && other.medicamentoID != null) || (this.medicamentoID != null && !this.medicamentoID.equals(other.medicamentoID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Medicamentos[ medicamentoID=" + medicamentoID + " ]";
    }
    
}
