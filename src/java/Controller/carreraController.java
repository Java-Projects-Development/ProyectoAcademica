
package Controller;

import EJB.CarreraFacadeLocal;
import EJB.FacultadFacadeLocal;
import Model.Carrera;
import Model.Facultad;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class carreraController implements Serializable{
    
    @EJB
    private CarreraFacadeLocal carreraEJB;
    @EJB
    private FacultadFacadeLocal facultadEJB;
    @Inject
    private Carrera carrera;
    @Inject 
    private Facultad facultad;
    
    private List<Facultad> facultades;
    private List<Carrera> carreras;

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }

    public List<Facultad> getFacultades() {
        return facultades;
    }

    public void setFacultades(List<Facultad> facultades) {
        this.facultades = facultades;
    }

    public List<Carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(List<Carrera> carreras) {
        this.carreras = carreras;
    }
    
    @PostConstruct
    public void init(){
        carreras = carreraEJB.findAll();
        facultades = facultadEJB.findAll();
    }
    
    public void registrar(){
        try{
            this.carrera.setFacultad(facultad);
            carreraEJB.create(carrera);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Carrera registrada con éxito"));
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso","Error"));
        }
    }
    
    public void modificar(){
        try{
            this.carrera.setFacultad(facultad);
            carreraEJB.edit(carrera);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Carrera modificada con éxito"));
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso","Error"));
        }
    }
    
    public void eliminar(){
        try{
            carreraEJB.remove(carrera);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Carrera eliminada con éxito"));
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso","Error"));
        }
    }
}
