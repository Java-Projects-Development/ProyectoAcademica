package report;

import EJB.CarreraFacadeLocal;
import Model.Carrera;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author said
 */
@Named
@ViewScoped
public class estudianteReporteBean implements Serializable {

    private int carrera;
    

    @Inject
    private Carrera carrera1;

    @EJB
    CarreraFacadeLocal carreraEJB;

    private List<Carrera> carreras;

    public int getCarrera() {
        return carrera;
    }

    public void setCarrera(int carrera) {
        this.carrera = carrera;
    }

    public Carrera getCarrera1() {
        return carrera1;
    }

    public void setCarrera1(Carrera carrera1) {
        this.carrera1 = carrera1;
    }

    public List<Carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(List<Carrera> carreras) {
        this.carreras = carreras;
    }

    @PostConstruct
    public void init() {
        carrera = carrera1.getId_carrera();
        carreras = carreraEJB.findAll();
    }

    public void verReporte() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        reporteEstudianteConParametro rEstudiante = new reporteEstudianteConParametro();

        FacesContext facesContext = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
        String ruta = servletContext.getRealPath("/reporte/reporteEstudiantes.jasper");

        rEstudiante.getReporte(ruta, this.carrera);
        FacesContext.getCurrentInstance().responseComplete();
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
