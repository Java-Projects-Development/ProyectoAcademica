package Bean;

import DAO.CarreraDao;
import Model.Carrera;
import Model.Facultad;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class CarreraBean extends CarreraDao{

    private Carrera carrera = new Carrera();
    private Facultad facultad = new Facultad();

    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }


    public void registrar() {
        CarreraDao dao;

        try {
            dao = new CarreraDao();
            this.carrera.setFacultad(facultad);
            dao.registrarCarrera(carrera);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Carrera registrada con éxito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!"));
        }
    }
    
  
}
