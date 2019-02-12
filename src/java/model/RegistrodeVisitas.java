/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Junior Dotel
 */
@Entity
@Table(name = "RegistrodeVisitas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegistrodeVisitas.findAll", query = "SELECT r FROM RegistrodeVisitas r")
    , @NamedQuery(name = "RegistrodeVisitas.findByRegistrodeVisitaID", query = "SELECT r FROM RegistrodeVisitas r WHERE r.registrodeVisitaID = :registrodeVisitaID")
    , @NamedQuery(name = "RegistrodeVisitas.findByFechaVisita", query = "SELECT r FROM RegistrodeVisitas r WHERE r.fechaVisita = :fechaVisita")
    , @NamedQuery(name = "RegistrodeVisitas.findByHoraVisita", query = "SELECT r FROM RegistrodeVisitas r WHERE r.horaVisita = :horaVisita")
    , @NamedQuery(name = "RegistrodeVisitas.findByRecomendacion", query = "SELECT r FROM RegistrodeVisitas r WHERE r.recomendacion = :recomendacion")
    , @NamedQuery(name = "RegistrodeVisitas.findByEstado", query = "SELECT r FROM RegistrodeVisitas r WHERE r.estado = :estado")})
public class RegistrodeVisitas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RegistrodeVisitaID")
    private Integer registrodeVisitaID;
    @Size(max = 50)
    @Column(name = "FechaVisita")
    private String fechaVisita;
    @Size(max = 50)
    @Column(name = "HoraVisita")
    private String horaVisita;
    @Size(max = 50)
    @Column(name = "Recomendacion")
    private String recomendacion;
    @Size(max = 50)
    @Column(name = "Estado")
    private String estado;
    @JoinColumn(name = "MedicamentoID", referencedColumnName = "MedicamentoID")
    @ManyToOne(optional = false)
    private Medicamentos medicamentoID;
    @JoinColumn(name = "MedicoID", referencedColumnName = "MedicoID")
    @ManyToOne(optional = false)
    private Medicos medicoID;
    @JoinColumn(name = "PacienteID", referencedColumnName = "PacienteID")
    @ManyToOne(optional = false)
    private Pacientes pacienteID;

    public RegistrodeVisitas() {
    }

    public RegistrodeVisitas(Integer registrodeVisitaID) {
        this.registrodeVisitaID = registrodeVisitaID;
    }

    public Integer getRegistrodeVisitaID() {
        return registrodeVisitaID;
    }

    public void setRegistrodeVisitaID(Integer registrodeVisitaID) {
        this.registrodeVisitaID = registrodeVisitaID;
    }

    public String getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(String fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    public String getHoraVisita() {
        return horaVisita;
    }

    public void setHoraVisita(String horaVisita) {
        this.horaVisita = horaVisita;
    }

    public String getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Medicamentos getMedicamentoID() {
        return medicamentoID;
    }

    public void setMedicamentoID(Medicamentos medicamentoID) {
        this.medicamentoID = medicamentoID;
    }

    public Medicos getMedicoID() {
        return medicoID;
    }

    public void setMedicoID(Medicos medicoID) {
        this.medicoID = medicoID;
    }

    public Pacientes getPacienteID() {
        return pacienteID;
    }

    public void setPacienteID(Pacientes pacienteID) {
        this.pacienteID = pacienteID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (registrodeVisitaID != null ? registrodeVisitaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistrodeVisitas)) {
            return false;
        }
        RegistrodeVisitas other = (RegistrodeVisitas) object;
        if ((this.registrodeVisitaID == null && other.registrodeVisitaID != null) || (this.registrodeVisitaID != null && !this.registrodeVisitaID.equals(other.registrodeVisitaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.RegistrodeVisitas[ registrodeVisitaID=" + registrodeVisitaID + " ]";
    }
    
}
