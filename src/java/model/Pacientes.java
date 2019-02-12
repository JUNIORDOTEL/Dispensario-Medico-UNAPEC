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
@Table(name = "Pacientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pacientes.findAll", query = "SELECT p FROM Pacientes p")
    , @NamedQuery(name = "Pacientes.findByPacienteID", query = "SELECT p FROM Pacientes p WHERE p.pacienteID = :pacienteID")
    , @NamedQuery(name = "Pacientes.findByNombre", query = "SELECT p FROM Pacientes p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Pacientes.findByCedula", query = "SELECT p FROM Pacientes p WHERE p.cedula = :cedula")
    , @NamedQuery(name = "Pacientes.findByCarnet", query = "SELECT p FROM Pacientes p WHERE p.carnet = :carnet")
    , @NamedQuery(name = "Pacientes.findByTipoPaciente", query = "SELECT p FROM Pacientes p WHERE p.tipoPaciente = :tipoPaciente")
    , @NamedQuery(name = "Pacientes.findByEstado", query = "SELECT p FROM Pacientes p WHERE p.estado = :estado")})
public class Pacientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PacienteID")
    private Integer pacienteID;
    @Size(max = 50)
    @Column(name = "Nombre")
    private String nombre;
    @Size(max = 50)
    @Column(name = "Cedula")
    private String cedula;
    @Size(max = 50)
    @Column(name = "Carnet")
    private String carnet;
    @Size(max = 50)
    @Column(name = "TipoPaciente")
    private String tipoPaciente;
    @Size(max = 50)
    @Column(name = "Estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pacienteID")
    private Collection<RegistrodeVisitas> registrodeVisitasCollection;

    public Pacientes() {
    }

    public Pacientes(Integer pacienteID) {
        this.pacienteID = pacienteID;
    }

    public Integer getPacienteID() {
        return pacienteID;
    }

    public void setPacienteID(Integer pacienteID) {
        this.pacienteID = pacienteID;
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

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getTipoPaciente() {
        return tipoPaciente;
    }

    public void setTipoPaciente(String tipoPaciente) {
        this.tipoPaciente = tipoPaciente;
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
        hash += (pacienteID != null ? pacienteID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pacientes)) {
            return false;
        }
        Pacientes other = (Pacientes) object;
        if ((this.pacienteID == null && other.pacienteID != null) || (this.pacienteID != null && !this.pacienteID.equals(other.pacienteID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Pacientes[ pacienteID=" + pacienteID + " ]";
    }
    
}
