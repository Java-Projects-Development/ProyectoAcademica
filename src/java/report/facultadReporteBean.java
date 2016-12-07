package report;

import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author NERV
 */
@ManagedBean
@ViewScoped
public class facultadReporteBean {
    
    public facultadReporteBean(){
       }
    
    public void verReporte() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
    
    reporteFacultad rFacultad = new reporteFacultad();
    
   FacesContext facesContext = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
        String ruta = servletContext.getRealPath("/reporte/reporteFacultades.jasper");
       
        rFacultad.getReporte(ruta);        
        FacesContext.getCurrentInstance().responseComplete();      
    }
 
    
    
}
