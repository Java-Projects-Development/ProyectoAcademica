
package Controller;

import EJB.PersonaFacadeLocal;
import EJB.UsuarioFacadeLocal;
import Model.Persona;
import Model.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@ViewScoped

public class usuarioController implements Serializable{
    
    @EJB
    private UsuarioFacadeLocal usuarioEJB;
    @EJB
    private PersonaFacadeLocal personaEJB;
    @Inject
    private Usuario usuario;
    
    @Inject
    private Persona persona;
    
    private List <Usuario> usuarios;
    private List <Persona> personas;
    
    
    @PostConstruct
    public void init(){
        usuarios = usuarioEJB.findAll();
        personas = personaEJB.findAll();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public void registrar(){
        try{
            this.usuario.setId_usuario(persona);
            usuarioEJB.create(usuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Se registró"));
            
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso","Error!"));
        }
    }
    
    public void modificar(){
        try{
            this.usuario.setId_usuario(persona);
            usuarioEJB.edit(usuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Se modificó con éxito"));
            
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso","Error!"));
        }
    }
    
    public void eliminar(){
        try{
            usuarioEJB.remove(usuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Se eliminó con éxito"));
            
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso","Error!"));
        }
    }
}
