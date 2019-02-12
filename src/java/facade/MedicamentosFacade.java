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
import model.Medicamentos;
import model.Medicamentos_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Marcas;
import model.TiposdeFarmacos;
import model.Ubicaciones;
import model.RegistrodeVisitas;

/**
 *
 * @author Junior Dotel
 */
@Stateless
public class MedicamentosFacade extends AbstractFacade<Medicamentos> {

    @PersistenceContext(unitName = "Dispensario_Medico_UNAPECPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MedicamentosFacade() {
        super(Medicamentos.class);
    }

    public boolean isMarcaIDEmpty(Medicamentos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Medicamentos> medicamentos = cq.from(Medicamentos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(medicamentos, entity), cb.isNotNull(medicamentos.get(Medicamentos_.marcaID)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Marcas findMarcaID(Medicamentos entity) {
        return this.getMergedEntity(entity).getMarcaID();
    }

    public boolean isTipoFarmacoIDEmpty(Medicamentos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Medicamentos> medicamentos = cq.from(Medicamentos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(medicamentos, entity), cb.isNotNull(medicamentos.get(Medicamentos_.tipoFarmacoID)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public TiposdeFarmacos findTipoFarmacoID(Medicamentos entity) {
        return this.getMergedEntity(entity).getTipoFarmacoID();
    }

    public boolean isUbicacionIDEmpty(Medicamentos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Medicamentos> medicamentos = cq.from(Medicamentos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(medicamentos, entity), cb.isNotNull(medicamentos.get(Medicamentos_.ubicacionID)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Ubicaciones findUbicacionID(Medicamentos entity) {
        return this.getMergedEntity(entity).getUbicacionID();
    }

    public boolean isRegistrodeVisitasCollectionEmpty(Medicamentos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Medicamentos> medicamentos = cq.from(Medicamentos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(medicamentos, entity), cb.isNotEmpty(medicamentos.get(Medicamentos_.registrodeVisitasCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<RegistrodeVisitas> findRegistrodeVisitasCollection(Medicamentos entity) {
        Medicamentos mergedEntity = this.getMergedEntity(entity);
        Collection<RegistrodeVisitas> registrodeVisitasCollection = mergedEntity.getRegistrodeVisitasCollection();
        registrodeVisitasCollection.size();
        return registrodeVisitasCollection;
    }
    
}
