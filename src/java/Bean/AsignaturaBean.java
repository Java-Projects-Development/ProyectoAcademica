package Bean;

import DAO.AsignaturaDao;
import Model.Asignatura;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class AsignaturaBean {

    private Asignatura asignatura = new Asignatura();

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public void registrar() {
        AsignaturaDao dao;

        try {
            if (asignatura.getUv() == 0) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Indique la cantidad de UV"));
            } else {
                dao = new AsignaturaDao();
                dao.registrarAsignatura(asignatura);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Asignatura registrada con éxito"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!"));
        }
    }
}
