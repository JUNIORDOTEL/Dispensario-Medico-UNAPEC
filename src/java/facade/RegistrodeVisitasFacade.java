/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.RegistrodeVisitas;
import model.RegistrodeVisitas_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Medicamentos;
import model.Medicos;
import model.Pacientes;

/**
 *
 * @author Junior Dotel
 */
@Stateless
public class RegistrodeVisitasFacade extends AbstractFacade<RegistrodeVisitas> {

    @PersistenceContext(unitName = "Dispensario_Medico_UNAPECPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RegistrodeVisitasFacade() {
        super(RegistrodeVisitas.class);
    }

    public boolean isMedicamentoIDEmpty(RegistrodeVisitas entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<RegistrodeVisitas> registrodeVisitas = cq.from(RegistrodeVisitas.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(registrodeVisitas, entity), cb.isNotNull(registrodeVisitas.get(RegistrodeVisitas_.medicamentoID)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Medicamentos findMedicamentoID(RegistrodeVisitas entity) {
        return this.getMergedEntity(entity).getMedicamentoID();
    }

    public boolean isMedicoIDEmpty(RegistrodeVisitas entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<RegistrodeVisitas> registrodeVisitas = cq.from(RegistrodeVisitas.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(registrodeVisitas, entity), cb.isNotNull(registrodeVisitas.get(RegistrodeVisitas_.medicoID)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Medicos findMedicoID(RegistrodeVisitas entity) {
        return this.getMergedEntity(entity).getMedicoID();
    }

    public boolean isPacienteIDEmpty(RegistrodeVisitas entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<RegistrodeVisitas> registrodeVisitas = cq.from(RegistrodeVisitas.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(registrodeVisitas, entity), cb.isNotNull(registrodeVisitas.get(RegistrodeVisitas_.pacienteID)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Pacientes findPacienteID(RegistrodeVisitas entity) {
        return this.getMergedEntity(entity).getPacienteID();
    }
    
}
