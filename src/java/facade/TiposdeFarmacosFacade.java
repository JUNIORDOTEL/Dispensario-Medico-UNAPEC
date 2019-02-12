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
import model.TiposdeFarmacos;
import model.TiposdeFarmacos_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Medicamentos;

/**
 *
 * @author Junior Dotel
 */
@Stateless
public class TiposdeFarmacosFacade extends AbstractFacade<TiposdeFarmacos> {

    @PersistenceContext(unitName = "Dispensario_Medico_UNAPECPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TiposdeFarmacosFacade() {
        super(TiposdeFarmacos.class);
    }

    public boolean isMedicamentosCollectionEmpty(TiposdeFarmacos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<TiposdeFarmacos> tiposdeFarmacos = cq.from(TiposdeFarmacos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tiposdeFarmacos, entity), cb.isNotEmpty(tiposdeFarmacos.get(TiposdeFarmacos_.medicamentosCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Medicamentos> findMedicamentosCollection(TiposdeFarmacos entity) {
        TiposdeFarmacos mergedEntity = this.getMergedEntity(entity);
        Collection<Medicamentos> medicamentosCollection = mergedEntity.getMedicamentosCollection();
        medicamentosCollection.size();
        return medicamentosCollection;
    }
    
}
