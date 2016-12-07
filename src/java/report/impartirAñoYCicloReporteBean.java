package report;

import EJB.FacultadFacadeLocal;
import Model.Facultad;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;
/**
 *
 * @author said
 */
@Named
@ViewScoped
public class impartirAñoYCicloReporteBean implements Serializable{
    
    private int facultad;
    private int ciclo;
    private int año;
    @Inject
    private Facultad facultad1;
    
    @EJB
    FacultadFacadeLocal facultadEJB;
    
    private List<Facultad> facultades;

    public int getCiclo() {
        return ciclo;
    }

    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }
    
    public int getFacultad() {
        return facultad;
    }

    public void setFacultad(int facultad) {
        this.facultad = facultad;
    }

    public Facultad getFacultad1() {
        return facultad1;
    }

    public void setFacultad1(Facultad facultad1) {
        this.facultad1 = facultad1;
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

    public void verReporte() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
    
    reporteImpartirAñoYCiclo rImpartir = new reporteImpartirAñoYCiclo();
    
   FacesContext facesContext = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
        String ruta = servletContext.getRealPath("/reporte/reporteImpartirPorCicloYAño.jasper");
       
        rImpartir.getReporte(ruta,this.facultad,this.ciclo,this.año);        
        FacesContext.getCurrentInstance().responseComplete();       
    }
 
    
    
}
