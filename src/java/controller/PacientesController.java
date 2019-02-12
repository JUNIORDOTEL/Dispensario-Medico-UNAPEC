package controller;

import model.Pacientes;
import model.RegistrodeVisitas;
import java.util.Collection;
import facade.PacientesFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "pacientesController")
@ViewScoped
public class PacientesController extends AbstractController<Pacientes> {

    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isRegistrodeVisitasCollectionEmpty;

    public PacientesController() {
        // Inform the Abstract parent controller of the concrete Pacientes Entity
        super(Pacientes.class);
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
        Pacientes selected = this.getSelected();
        if (selected != null) {
            PacientesFacade ejbFacade = (PacientesFacade) this.getFacade();
            this.isRegistrodeVisitasCollectionEmpty = ejbFacade.isRegistrodeVisitasCollectionEmpty(selected);
        } else {
            this.isRegistrodeVisitasCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of RegistrodeVisitas
     * entities that are retrieved from Pacientes and returns the navigation
     * outcome.
     *
     * @return navigation outcome for RegistrodeVisitas page
     */
    public String navigateRegistrodeVisitasCollection() {
        Pacientes selected = this.getSelected();
        if (selected != null) {
            PacientesFacade ejbFacade = (PacientesFacade) this.getFacade();
            Collection<RegistrodeVisitas> selectedRegistrodeVisitasCollection = ejbFacade.findRegistrodeVisitasCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("RegistrodeVisitas_items", selectedRegistrodeVisitasCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/registrodeVisitas/index";
    }

}
