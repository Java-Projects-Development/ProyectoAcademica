package Controller;

import EJB.MenuFacadeLocal;
import Model.Usuario;
import Model.Menu;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

@Named
@SessionScoped
public class menuController implements Serializable {

    private List<Menu> lista;
    private MenuModel model;
    private FacesContext context = FacesContext.getCurrentInstance();

    @EJB
    private MenuFacadeLocal menuEJB;

    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }

    @PostConstruct
    public void init() {
        this.listarMenus();
        model = new DefaultMenuModel();
        this.establecerPermisos();
    }

    public void listarMenus() {
        try {
            lista = menuEJB.findAll();
        } catch (Exception e) {
            //mensaje JSF
        }
    }

    public void establecerPermisos() {
        Usuario us = (Usuario) context.getExternalContext().getSessionMap().get("usuario");

        for (Menu m : lista) {
             if (m.getSubmenu() == null && m.getTipoUsuario().equals(us.getTipo_usuario())) {
                    DefaultMenuItem item = new DefaultMenuItem(m.getNombre());
                    item.setUrl(m.getUrl());
                    model.addElement(item);
                    
                } 
            }
        }
    

    public void cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
}
