
package Controller;

import EJB.FacultadFacadeLocal;
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
public class facultadController implements Serializable {
    
    @EJB
    private FacultadFacadeLocal facultadEJB;
    @Inject
    private Facultad facultad;
    
    private List<Facultad> facultades;

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
    
    @PostConstruct
    public void init(){
        facultades = facultadEJB.findAll();
    }
    
    public void registrar(){
        try{
            facultadEJB.create(facultad);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Facultad registrada con éxito"));
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso","Error"));
        }
    }
    
    public void modificar(){
        try{
            facultadEJB.edit(facultad);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Facultad modificada con éxito"));
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso","Error"));
        }
    }
    
    public void eliminar(){
        try{
            facultadEJB.remove(facultad);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Facultad eliminada con éxito"));
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso","Error"));
        }
    }
    
    
}
