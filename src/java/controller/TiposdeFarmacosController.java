package controller;

import model.TiposdeFarmacos;
import model.Medicamentos;
import java.util.Collection;
import facade.TiposdeFarmacosFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tiposdeFarmacosController")
@ViewScoped
public class TiposdeFarmacosController extends AbstractController<TiposdeFarmacos> {

    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isMedicamentosCollectionEmpty;

    public TiposdeFarmacosController() {
        // Inform the Abstract parent controller of the concrete TiposdeFarmacos Entity
        super(TiposdeFarmacos.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsMedicamentosCollectionEmpty();
    }

    public boolean getIsMedicamentosCollectionEmpty() {
        return this.isMedicamentosCollectionEmpty;
    }

    private void setIsMedicamentosCollectionEmpty() {
        TiposdeFarmacos selected = this.getSelected();
        if (selected != null) {
            TiposdeFarmacosFacade ejbFacade = (TiposdeFarmacosFacade) this.getFacade();
            this.isMedicamentosCollectionEmpty = ejbFacade.isMedicamentosCollectionEmpty(selected);
        } else {
            this.isMedicamentosCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Medicamentos entities
     * that are retrieved from TiposdeFarmacos and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Medicamentos page
     */
    public String navigateMedicamentosCollection() {
        TiposdeFarmacos selected = this.getSelected();
        if (selected != null) {
            TiposdeFarmacosFacade ejbFacade = (TiposdeFarmacosFacade) this.getFacade();
            Collection<Medicamentos> selectedMedicamentosCollection = ejbFacade.findMedicamentosCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Medicamentos_items", selectedMedicamentosCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/medicamentos/index";
    }

}
