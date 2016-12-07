
package Controller;

import EJB.AsignaturaFacadeLocal;
import EJB.CarreraFacadeLocal;
import Model.Asignatura;
import Model.Carrera;
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
public class asignaturaController implements Serializable{
    
    @EJB
    private AsignaturaFacadeLocal asignaturaEJB;
    @EJB
    private CarreraFacadeLocal carreraEJB;
    @Inject
    private Asignatura asignatura;
    @Inject 
    private Carrera carrera;
    
    private List<Carrera> carreras;
    private List<Asignatura> asignaturas;

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
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
        asignaturas = asignaturaEJB.findAll();
        carreras = carreraEJB.findAll();
    }
    
    public void registrar(){
        try{
            this.asignatura.setCarrera(carrera);
            asignaturaEJB.create(asignatura);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Asignatura registrada con éxito"));
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso","Error"));
        }
    }
    
    public void modificar(){
        try{
            this.asignatura.setCarrera(carrera);
            asignaturaEJB.edit(asignatura);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Asignatura modificada con éxito"));
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso","Error"));
        }
    }
    
    public void eliminar(){
        try{
            asignaturaEJB.remove(asignatura);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Asignatura eliminada con éxito"));
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
