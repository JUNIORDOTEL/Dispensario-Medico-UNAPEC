package controller;

import model.RegistrodeVisitas;
import facade.RegistrodeVisitasFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "registrodeVisitasController")
@ViewScoped
public class RegistrodeVisitasController extends AbstractController<RegistrodeVisitas> {

    @Inject
    private MedicamentosController medicamentoIDController;
    @Inject
    private MedicosController medicoIDController;
    @Inject
    private PacientesController pacienteIDController;
    @Inject
    private MobilePageController mobilePageController;

    public RegistrodeVisitasController() {
        // Inform the Abstract parent controller of the concrete RegistrodeVisitas Entity
        super(RegistrodeVisitas.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        medicamentoIDController.setSelected(null);
        medicoIDController.setSelected(null);
        pacienteIDController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Medicamentos controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareMedicamentoID(ActionEvent event) {
        RegistrodeVisitas selected = this.getSelected();
        if (selected != null && medicamentoIDController.getSelected() == null) {
            medicamentoIDController.setSelected(selected.getMedicamentoID());
        }
    }

    /**
     * Sets the "selected" attribute of the Medicos controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareMedicoID(ActionEvent event) {
        RegistrodeVisitas selected = this.getSelected();
        if (selected != null && medicoIDController.getSelected() == null) {
            medicoIDController.setSelected(selected.getMedicoID());
        }
    }

    /**
     * Sets the "selected" attribute of the Pacientes controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void preparePacienteID(ActionEvent event) {
        RegistrodeVisitas selected = this.getSelected();
        if (selected != null && pacienteIDController.getSelected() == null) {
            pacienteIDController.setSelected(selected.getPacienteID());
        }
    }

}
