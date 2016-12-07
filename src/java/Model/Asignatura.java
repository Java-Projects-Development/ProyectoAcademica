
package Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="asignatura")
public class Asignatura implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_asignatura;
    @Column(name="codigo_asignatura")
    private String codigo_asignatura;
    @Column(name="nombreAsignatura")
    private String nombre_asignatura;
    @Column(name="UV")
    private int uv;
    @ManyToOne
    @JoinColumn(name="id_carrera",nullable=false)
    private Carrera carrera;

    public int getUv() {
        return uv;
    }

    public void setUv(int uv) {
        this.uv = uv;
    }
    
    public int getId_asignatura() {
        return id_asignatura;
    }

    public void setId_asignatura(int id_asignatura) {
        this.id_asignatura = id_asignatura;
    }

    public String getCodigo_asignatura() {
        return codigo_asignatura;
    }

    public void setCodigo_asignatura(String codigo_asignatura) {
        this.codigo_asignatura = codigo_asignatura;
    }

    public String getNombre_asignatura() {
        return nombre_asignatura;
    }

    public void setNombre_asignatura(String nombre_asignatura) {
        this.nombre_asignatura = nombre_asignatura;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.id_asignatura;
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
        final Asignatura other = (Asignatura) obj;
        if (this.id_asignatura != other.id_asignatura) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Asignatura{" + "id_asignatura=" + id_asignatura + '}';
    }

}
