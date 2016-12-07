
package Model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable{
    @Id
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Persona id_usuario;
    @Column(name="usuario")
    private String usuario;
    @Column(name="clave")
    private String clave;
    @Column(name="tipo")
    private String tipo_usuario;
    @Column(name="estado")
    private int estado = 1;

    public Persona getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Persona id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id_usuario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.id_usuario, other.id_usuario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id_usuario=" + id_usuario + '}';
    }

    

}
