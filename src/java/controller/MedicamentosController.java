package controller;

import model.Medicamentos;
import model.RegistrodeVisitas;
import java.util.Collection;
import facade.MedicamentosFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "medicamentosController")
@ViewScoped
public class MedicamentosController extends AbstractController<Medicamentos> {

    @Inject
    private MarcasController marcaIDController;
    @Inject
    private TiposdeFarmacosController tipoFarmacoIDController;
    @Inject
    private UbicacionesController ubicacionIDController;
    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isRegistrodeVisitasCollectionEmpty;

    public MedicamentosController() {
        // Inform the Abstract parent controller of the concrete Medicamentos Entity
        super(Medicamentos.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        marcaIDController.setSelected(null);
        tipoFarmacoIDController.setSelected(null);
        ubicacionIDController.setSelected(null);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsRegistrodeVisitasCollectionEmpty();
    }

    /**
     * Sets the "selected" attribute of the Marcas controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareMarcaID(ActionEvent event) {
        Medicamentos selected = this.getSelected();
        if (selected != null && marcaIDController.getSelected() == null) {
            marcaIDController.setSelected(selected.getMarcaID());
        }
    }

    /**
     * Sets the "selected" attribute of the TiposdeFarmacos controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareTipoFarmacoID(ActionEvent event) {
        Medicamentos selected = this.getSelected();
        if (selected != null && tipoFarmacoIDController.getSelected() == null) {
            tipoFarmacoIDController.setSelected(selected.getTipoFarmacoID());
        }
    }

    /**
     * Sets the "selected" attribute of the Ubicaciones controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareUbicacionID(ActionEvent event) {
        Medicamentos selected = this.getSelected();
        if (selected != null && ubicacionIDController.getSelected() == null) {
            ubicacionIDController.setSelected(selected.getUbicacionID());
        }
    }

    public boolean getIsRegistrodeVisitasCollectionEmpty() {
        return this.isRegistrodeVisitasCollectionEmpty;
    }

    private void setIsRegistrodeVisitasCollectionEmpty() {
        Medicamentos selected = this.getSelected();
        if (selected != null) {
            MedicamentosFacade ejbFacade = (MedicamentosFacade) this.getFacade();
            this.isRegistrodeVisitasCollectionEmpty = ejbFacade.isRegistrodeVisitasCollectionEmpty(selected);
        } else {
            this.isRegistrodeVisitasCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of RegistrodeVisitas
     * entities that are retrieved from Medicamentos and returns the navigation
     * outcome.
     *
     * @return navigation outcome for RegistrodeVisitas page
     */
    public String navigateRegistrodeVisitasCollection() {
        Medicamentos selected = this.getSelected();
        if (selected != null) {
            MedicamentosFacade ejbFacade = (MedicamentosFacade) this.getFacade();
            Collection<RegistrodeVisitas> selectedRegistrodeVisitasCollection = ejbFacade.findRegistrodeVisitasCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("RegistrodeVisitas_items", selectedRegistrodeVisitasCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/registrodeVisitas/index";
    }

}
