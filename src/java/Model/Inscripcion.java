
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
@Table(name="inscripcion")
public class Inscripcion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_inscripcion;
    @ManyToOne
    @JoinColumn(name="id_impartir",nullable = false)
    private Impartir id_impartir;
    @ManyToOne
    @JoinColumn(name="id_estudiante",nullable = false)
    private Estudiante id_estudiante;
    @Column(name="matricula")
    private int matricula;

    public int getId_inscripcion() {
        return id_inscripcion;
    }

    public void setId_inscripcion(int id_inscripcion) {
        this.id_inscripcion = id_inscripcion;
    }

    public Estudiante getId_estudiante() {
        return id_estudiante;
    }

    public Impartir getId_impartir() {
        return id_impartir;
    }

    public void setId_impartir(Impartir id_impartir) {
        this.id_impartir = id_impartir;
    }

    public void setId_estudiante(Estudiante id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id_inscripcion;
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
        final Inscripcion other = (Inscripcion) obj;
        if (this.id_inscripcion != other.id_inscripcion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "id_inscripcion=" + id_inscripcion + '}';
    }
    
}
