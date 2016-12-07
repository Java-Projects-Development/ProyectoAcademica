package Controller;

import EJB.EstudianteFacadeLocal;
import EJB.FacultadFacadeLocal;
import EJB.ImpartirFacadeLocal;
import EJB.InscripcionFacadeLocal;
import Model.Asignatura;
import Model.Estudiante;
import Model.Facultad;
import Model.Impartir;
import Model.Inscripcion;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

@Named
@ViewScoped
public class inscripcionController implements Serializable {

    @EJB
    private InscripcionFacadeLocal inscripcionEJB;
    @EJB
    private ImpartirFacadeLocal impartirEJB;
    @EJB
    private EstudianteFacadeLocal estudianteEJB;

    private List<Estudiante> estudiantes;
    private List<Impartir> impartidas;
    private List<Inscripcion> inscripciones;

    @Inject
    private Impartir impartir;
    @Inject
    private Estudiante estudiante;
    @Inject
    private Inscripcion inscripcion;

    public List<Impartir> getImpartidas() {
        return impartidas;
    }

    public void setImpartidas(List<Impartir> impartidas) {
        this.impartidas = impartidas;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(List<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }

    public Impartir getImpartir() {
        return impartir;
    }

    public void setImpartir(Impartir impartir) {
        this.impartir = impartir;
    }

    public Inscripcion getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    @PostConstruct
    public void init() {
        impartidas = impartirEJB.findAll();
        inscripciones = inscripcionEJB.findAll();
        estudiantes = estudianteEJB.findAll();
    }

    public void registrar() {
        try {
            if (estudiante.getId_estudiante() == 0) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Elija un estudiante"));
            }
            if (impartir.getId_impartir() == 0) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Elija una asignatura"));
            } 
                this.inscripcion.setId_impartir(impartir);
                this.inscripcion.setId_estudiante(estudiante);
                inscripcionEJB.create(inscripcion);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Inscripción realizada con éxito"));
            
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error"));
        }
    }

    public void modificar() {
        try {
            this.inscripcion.setId_impartir(impartir);
            this.inscripcion.setId_estudiante(estudiante);
            inscripcionEJB.edit(inscripcion);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Inscripción modificada con éxito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error"));
        }
    }

    public void eliminar() {
        try {
            inscripcionEJB.remove(inscripcion);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Inscripción eliminada con éxito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error"));
        }
    }

    public void facultadSeleccionada(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Facultad Seleccionada", ((Facultad) event.getObject()).getNombre_facultad());
        FacesContext.getCurrentInstance().addMessage(null, msg);

    }

    public void facultadDeseleccionada(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Facultad Deseleccionada", ((Facultad) event.getObject()).getNombre_facultad());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void asignaturaSeleccionada(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Asignatura Seleccionada", ((Asignatura) event.getObject()).getNombre_asignatura());
        FacesContext.getCurrentInstance().addMessage(null, msg);

    }

    public void asignaturaDeseleccionada(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Asignatura Deseleccionada", ((Asignatura) event.getObject()).getNombre_asignatura());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void impartirSeleccionada(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Asignatura Seleccionada", ((Impartir) event.getObject()).getAsignatura().getNombre_asignatura());
        FacesContext.getCurrentInstance().addMessage(null, msg);

    }

    public void impartirDeseleccionada(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Asignatura Deseleccionada", ((Impartir) event.getObject()).getAsignatura().getNombre_asignatura());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void estudianteSeleccionado(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Alumno Seleccionado", retornarNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);

    }

    public String retornarNombre() {
        String nombre = null;
        nombre = estudiante.getNombres() + " " + estudiante.getApellidos();
        return nombre;
    }

    public void estudianteDeseleccionado(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Alumno Deseleccionado", ((Estudiante) event.getObject()).getNombres());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    private String selectedColumn;
    private String unselectedColumn;

    public String getSelectedColumn() {
        return selectedColumn;
    }

    public void setSelectedColumn(String selectedColumn) {
        this.selectedColumn = selectedColumn;
    }

    public String getUnselectedColumn() {
        return unselectedColumn;
    }

    public void setUnselectedColumn(String unselectedColumn) {
        this.unselectedColumn = unselectedColumn;
    }

    public void alElegirFila(AjaxBehaviorEvent event) {
        String value = getSelectedColumn();
        System.out.println(value);
    }

}
