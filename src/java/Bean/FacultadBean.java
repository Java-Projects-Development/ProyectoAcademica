
package Bean;

import DAO.FacultadDao;
import Model.Facultad;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class FacultadBean {
    
    private Facultad facultad = new Facultad();

    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }
    
    public void registrar(){
        FacultadDao dao;
        
        try {
            dao = new FacultadDao();
            dao.registrarFacultad(facultad);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Facultad registrada con éxito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso","Error!"));
        }
    }
}
