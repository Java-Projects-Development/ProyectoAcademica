
package Controller;

import EJB.CarreraFacadeLocal;
import EJB.EstudianteFacadeLocal;
import Model.Asignatura;
import Model.Carrera;
import Model.Estudiante;
import Model.Facultad;
import Model.Impartir;
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
public class estudianteController implements Serializable{
    
    @EJB
    private EstudianteFacadeLocal estudiateEJB;
    @EJB
    private CarreraFacadeLocal carreraEJB;
    @Inject
    private Estudiante estudiante;
    @Inject 
    private Carrera carrera;
    
    private List<Carrera> carreras;
    
    private List<Estudiante> estudiantes;

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public List<Carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(List<Carrera> carreras) {
        this.carreras = carreras;
    }


    
    @PostConstruct
    public void init(){
        estudiantes = estudiateEJB.findAll();
        carreras = carreraEJB.findAll();
    }
   
    public void registrar(){
        try{
            this.estudiante.setId_carrera(carrera);
            estudiateEJB.create(estudiante);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Estudiante registrado con éxito"));
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso","Error"));
        }
    }
    
    public void modificar(){
        try{
            this.estudiante.setId_carrera(carrera);
            estudiateEJB.edit(estudiante);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Estudiante modificado con éxito"));
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso","Error"));
        }
    }
    
    public void eliminar(){
        try{
            estudiateEJB.remove(estudiante);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Estudiante eliminado con éxito"));
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso","Error"));
        }
    }
    
    public void carreraSeleccionada(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Carrera Seleccionada", ((Carrera) event.getObject()).getNombre_carrera());
        FacesContext.getCurrentInstance().addMessage(null, msg);

    }

    public void carreraDeseleccionada(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Carrera Deseleccionada", ((Carrera) event.getObject()).getNombre_carrera());
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
