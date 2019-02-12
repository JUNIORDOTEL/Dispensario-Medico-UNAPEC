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
@Table(name = "Medicos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicos.findAll", query = "SELECT m FROM Medicos m")
    , @NamedQuery(name = "Medicos.findByMedicoID", query = "SELECT m FROM Medicos m WHERE m.medicoID = :medicoID")
    , @NamedQuery(name = "Medicos.findByNombre", query = "SELECT m FROM Medicos m WHERE m.nombre = :nombre")
    , @NamedQuery(name = "Medicos.findByCedula", query = "SELECT m FROM Medicos m WHERE m.cedula = :cedula")
    , @NamedQuery(name = "Medicos.findByTandaLabor", query = "SELECT m FROM Medicos m WHERE m.tandaLabor = :tandaLabor")
    , @NamedQuery(name = "Medicos.findByEspecialidad", query = "SELECT m FROM Medicos m WHERE m.especialidad = :especialidad")
    , @NamedQuery(name = "Medicos.findByEstado", query = "SELECT m FROM Medicos m WHERE m.estado = :estado")})
public class Medicos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MedicoID")
    private Integer medicoID;
    @Size(max = 50)
    @Column(name = "Nombre")
    private String nombre;
    @Size(max = 50)
    @Column(name = "Cedula")
    private String cedula;
    @Size(max = 50)
    @Column(name = "TandaLabor")
    private String tandaLabor;
    @Size(max = 50)
    @Column(name = "Especialidad")
    private String especialidad;
    @Size(max = 50)
    @Column(name = "Estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicoID")
    private Collection<RegistrodeVisitas> registrodeVisitasCollection;

    public Medicos() {
    }

    public Medicos(Integer medicoID) {
        this.medicoID = medicoID;
    }

    public Integer getMedicoID() {
        return medicoID;
    }

    public void setMedicoID(Integer medicoID) {
        this.medicoID = medicoID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTandaLabor() {
        return tandaLabor;
    }

    public void setTandaLabor(String tandaLabor) {
        this.tandaLabor = tandaLabor;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
        hash += (medicoID != null ? medicoID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicos)) {
            return false;
        }
        Medicos other = (Medicos) object;
        if ((this.medicoID == null && other.medicoID != null) || (this.medicoID != null && !this.medicoID.equals(other.medicoID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Medicos[ medicoID=" + medicoID + " ]";
    }
    
}
