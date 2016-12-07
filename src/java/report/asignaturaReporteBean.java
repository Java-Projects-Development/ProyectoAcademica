package report;

import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author said
 */
@ManagedBean
@ViewScoped
public class asignaturaReporteBean {
    
    public asignaturaReporteBean(){
       }
    
    public void verReporte() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
    
    reporteAsignatura rAsignatura = new reporteAsignatura();
    
   FacesContext facesContext = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
        String ruta = servletContext.getRealPath("/reporte/reporteAsignaturas.jasper");
       
        rAsignatura.getReporte(ruta);        
        FacesContext.getCurrentInstance().responseComplete();      
    }
 
    
    
}
