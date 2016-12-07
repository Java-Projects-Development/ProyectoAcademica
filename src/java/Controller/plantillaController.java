
package Controller;

import Model.Usuario;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class plantillaController implements Serializable{
    
    public void verificarSesion(){
        try {
            Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario"); 
        
            if(us==null){
                FacesContext.getCurrentInstance().getExternalContext().redirect("permisos.xhtml");
            }
        
        } catch (Exception e) {
        }
    }
}
