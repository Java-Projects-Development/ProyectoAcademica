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
public class carreraReporteGeneralBean {
    
    public carreraReporteGeneralBean(){
       }
    
    public void verReporte() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
    
    reporteCarreraGeneral rCarreraGeneral = new reporteCarreraGeneral();
    
   FacesContext facesContext = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
        String ruta = servletContext.getRealPath("/reporte/reporteGeneralCarreras.jasper");
       
        rCarreraGeneral.getReporte(ruta);        
        FacesContext.getCurrentInstance().responseComplete();      
    }
 
    
    
}
