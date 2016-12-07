package Controller;

import EJB.AsignaturaFacadeLocal;
import EJB.DocenteFacadeLocal;
import EJB.FacultadFacadeLocal;
import EJB.ImpartirFacadeLocal;
import Model.Asignatura;
import Model.Docente;
import Model.Facultad;
import Model.Impartir;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
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
public class impartirController implements Serializable {

    @EJB
    private ImpartirFacadeLocal impartirEJB;
    @EJB
    private FacultadFacadeLocal facultadEJB;
    @EJB
    private DocenteFacadeLocal docenteEJB;
    @EJB
    private AsignaturaFacadeLocal asignaturaEJB;
    @Inject
    private Facultad facultad;
    @Inject
    private Docente docente;
    @Inject
    private Asignatura asignatura;
    @Inject
    private Impartir impartir;

    private List<Facultad> facultades;
    private List<Docente> docentes;
    private List<Asignatura> asignaturas;
    private List<Impartir> impartidas;

    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public Impartir getImpartir() {
        return impartir;
    }

    public void setImpartir(Impartir impartir) {
        this.impartir = impartir;
    }

    public List<Facultad> getFacultades() {
        return facultades;
    }

    public void setFacultades(List<Facultad> facultades) {
        this.facultades = facultades;
    }

    public List<Docente> getDocentes() {
        return docentes;
    }

    public void setDocentes(List<Docente> docentes) {
        this.docentes = docentes;
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

    public List<Impartir> getImpartidas() {
        return impartidas;
    }

    public void setImpartidas(List<Impartir> impartidas) {
        this.impartidas = impartidas;
    }

    @PostConstruct
    public void init() {
        facultades = facultadEJB.findAll();
        docentes = docenteEJB.findAll();
        asignaturas = asignaturaEJB.findAll();
        impartidas = impartirEJB.findAll();
    }

    public void registrar() {
        String redireccion = null;
        try {
            if (asignatura.getId_asignatura() == 0) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Seleccione una asignatura"));
            }
            if (facultad.getId_facultad() == 0) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Seleccione una facultad"));
            }
            if (impartir.getCapacidad() == 0) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Ingrese la capacidad de alumnos de la sección"));
            } else {
                this.impartir.setAsignatura(asignatura);
                this.impartir.setDocente(docente);
                this.impartir.setFacultad(facultad);
                impartirEJB.create(impartir);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Materia a impartir registrada con éxito"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error"));
        }
    }

    public void modificar() {
        try {
            this.impartir.setAsignatura(asignatura);
            this.impartir.setDocente(docente);
            this.impartir.setFacultad(facultad);
            impartirEJB.edit(impartir);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Materia a impartir modificada con éxito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error"));
        }
    }

    public void eliminar() {
        try {
            impartirEJB.remove(impartir);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Materia a impartir eliminada con éxito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error"));
        }
    }

    
    public void asignaturaSeleccionada(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Asignatura Seleccionada", ((Asignatura) event.getObject()).getNombre_asignatura());
        FacesContext.getCurrentInstance().addMessage(null, msg);

    }

    public void asignaturaDeseleccionada(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Asignatura Deseleccionada", ((Asignatura) event.getObject()).getNombre_asignatura());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void facultadSeleccionada(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Facultad Seleccionada", ((Facultad) event.getObject()).getNombre_facultad());
        FacesContext.getCurrentInstance().addMessage(null, msg);

    }

    public void facultadDeseleccionada(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Facultad Deseleccionada", ((Facultad) event.getObject()).getNombre_facultad());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void docenteSeleccionado(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Docente Seleccionado", retornarNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);

    }

    public String retornarNombre() {
        String nombre = null;
        nombre = docente.getNombres() + " " + docente.getApellidos();
        return nombre;
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
