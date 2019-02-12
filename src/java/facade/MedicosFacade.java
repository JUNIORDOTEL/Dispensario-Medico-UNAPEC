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
import model.Medicos;
import model.Medicos_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.RegistrodeVisitas;

/**
 *
 * @author Junior Dotel
 */
@Stateless
public class MedicosFacade extends AbstractFacade<Medicos> {

    @PersistenceContext(unitName = "Dispensario_Medico_UNAPECPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MedicosFacade() {
        super(Medicos.class);
    }

    public boolean isRegistrodeVisitasCollectionEmpty(Medicos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Medicos> medicos = cq.from(Medicos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(medicos, entity), cb.isNotEmpty(medicos.get(Medicos_.registrodeVisitasCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<RegistrodeVisitas> findRegistrodeVisitasCollection(Medicos entity) {
        Medicos mergedEntity = this.getMergedEntity(entity);
        Collection<RegistrodeVisitas> registrodeVisitasCollection = mergedEntity.getRegistrodeVisitasCollection();
        registrodeVisitasCollection.size();
        return registrodeVisitasCollection;
    }
    
}
