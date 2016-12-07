
package Model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="carrera")
public class Carrera implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_carrera;
    @Column(name="codigo_carrera")
    private String codigo_carrera;
    @Column(name="nombre_carrera")
    private String nombre_carrera;
    @ManyToOne
    @JoinColumn(name="id_facultad",nullable = false)
    private Facultad facultad;

    public int getId_carrera() {
        return id_carrera;
    }

    public void setId_carrera(int id_carrera) {
        this.id_carrera = id_carrera;
    }

    public String getCodigo_carrera() {
        return codigo_carrera;
    }

    public void setCodigo_carrera(String codigo_carrera) {
        this.codigo_carrera = codigo_carrera;
    }

    public String getNombre_carrera() {
        return nombre_carrera;
    }

    public void setNombre_carrera(String nombre_carrera) {
        this.nombre_carrera = nombre_carrera;
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.id_carrera;
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
        final Carrera other = (Carrera) obj;
        if (this.id_carrera != other.id_carrera) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Carrera{" + "id_carrera=" + id_carrera + '}';
    }
    
}

