package controller;

import model.Medicos;
import model.RegistrodeVisitas;
import java.util.Collection;
import facade.MedicosFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "medicosController")
@ViewScoped
public class MedicosController extends AbstractController<Medicos> {

    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isRegistrodeVisitasCollectionEmpty;

    public MedicosController() {
        // Inform the Abstract parent controller of the concrete Medicos Entity
        super(Medicos.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsRegistrodeVisitasCollectionEmpty();
    }

    public boolean getIsRegistrodeVisitasCollectionEmpty() {
        return this.isRegistrodeVisitasCollectionEmpty;
    }

    private void setIsRegistrodeVisitasCollectionEmpty() {
        Medicos selected = this.getSelected();
        if (selected != null) {
            MedicosFacade ejbFacade = (MedicosFacade) this.getFacade();
            this.isRegistrodeVisitasCollectionEmpty = ejbFacade.isRegistrodeVisitasCollectionEmpty(selected);
        } else {
            this.isRegistrodeVisitasCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of RegistrodeVisitas
     * entities that are retrieved from Medicos and returns the navigation
     * outcome.
     *
     * @return navigation outcome for RegistrodeVisitas page
     */
    public String navigateRegistrodeVisitasCollection() {
        Medicos selected = this.getSelected();
        if (selected != null) {
            MedicosFacade ejbFacade = (MedicosFacade) this.getFacade();
            Collection<RegistrodeVisitas> selectedRegistrodeVisitasCollection = ejbFacade.findRegistrodeVisitasCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("RegistrodeVisitas_items", selectedRegistrodeVisitasCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/registrodeVisitas/index";
    }

}
