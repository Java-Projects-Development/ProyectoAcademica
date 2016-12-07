

package Controller;

import EJB.DocenteFacadeLocal;
import EJB.FacultadFacadeLocal;
import Model.Docente;
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
public class docenteController implements Serializable{
    
    @EJB
    private DocenteFacadeLocal docenteEJB;
    @EJB
    private FacultadFacadeLocal facultadEJB;
    
    @Inject
    private Facultad facultad;
    @Inject
    private Docente docente;
    
    private List<Facultad> facultades;
    private List<Docente> docentes;

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
    
    
    @PostConstruct
    public void init(){
        facultades = facultadEJB.findAll();
        docentes = docenteEJB.findAll();
    }
    
    public void registrar(){
        try{
            this.docente.setFacultad(facultad);
            docenteEJB.create(docente);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Docente registrado con éxito"));
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso","Error"));
        }
    }
    
    public void modificar(){
        try{
            this.docente.setFacultad(facultad);
            docenteEJB.edit(docente);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Docente modificado con éxito"));
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso","Error"));
        }
    }
    
    public void eliminar(){
        try{
            docenteEJB.remove(docente);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Docente eliminado con éxito"));
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso","Error"));
        }
    }
}
