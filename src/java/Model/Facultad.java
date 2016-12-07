
package Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="facultad")
public class Facultad implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_facultad;
    @Column(name="codigo_facultad")
    private String codigo_facultad;
    @Column(name="nombre")
    private String nombre_facultad;

    public int getId_facultad() {
        return id_facultad;
    }

    public void setId_facultad(int id_facultad) {
        this.id_facultad = id_facultad;
    }

    public String getCodigo_facultad() {
        return codigo_facultad;
    }

    public void setCodigo_facultad(String codigo_facultad) {
        this.codigo_facultad = codigo_facultad;
    }

    public String getNombre_facultad() {
        return nombre_facultad;
    }

    public void setNombre_facultad(String nombre_facultad) {
        this.nombre_facultad = nombre_facultad;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id_facultad;
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
        final Facultad other = (Facultad) obj;
        if (this.id_facultad != other.id_facultad) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Facultad{" + "id_facultad=" + id_facultad + '}';
    }
    
}
