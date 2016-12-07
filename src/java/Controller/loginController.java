
package Controller;

import EJB.UsuarioFacadeLocal;
import Model.Usuario;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class loginController implements Serializable{
    
    @EJB
    private UsuarioFacadeLocal usuarioEJB;
    
    @Inject
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String iniciarSesion(){
        String redireccion=null;
        Usuario us;

        try {
          us = usuarioEJB.iniciarSesion(usuario);
          if(us!=null){
              //Almacenar en la sesión de JSF
              FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);
              redireccion="/inicio.xhtml?faces-redirect=true";
              FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Bienvenido "));
          }else{
              FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Aviso","Credenciales incorrectas"));
          }
          
        } catch (Exception e) {
            
        }
        return redireccion;
    }
    
}
