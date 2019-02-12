/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Pacientes;
import model.Pacientes_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.RegistrodeVisitas;

/**
 *
 * @author Junior Dotel
 */
@Stateless
public class PacientesFacade extends AbstractFacade<Pacientes> {

    @PersistenceContext(unitName = "Dispensario_Medico_UNAPECPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PacientesFacade() {
        super(Pacientes.class);
    }

    public boolean isRegistrodeVisitasCollectionEmpty(Pacientes entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Pacientes> pacientes = cq.from(Pacientes.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(pacientes, entity), cb.isNotEmpty(pacientes.get(Pacientes_.registrodeVisitasCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<RegistrodeVisitas> findRegistrodeVisitasCollection(Pacientes entity) {
        Pacientes mergedEntity = this.getMergedEntity(entity);
        Collection<RegistrodeVisitas> registrodeVisitasCollection = mergedEntity.getRegistrodeVisitasCollection();
        registrodeVisitasCollection.size();
        return registrodeVisitasCollection;
    }
    
}
