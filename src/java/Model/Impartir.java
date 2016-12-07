package Model;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "impartir")
public class Impartir implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_impartir;
    @ManyToOne
    @JoinColumn(name = "id_facultad", nullable = false)
    private Facultad facultad;
    @ManyToOne
    @JoinColumn(name = "id_asignatura", nullable = false)
    private Asignatura asignatura;
    @Column(name = "seccion")
    private String seccion;
    @ManyToOne
    @JoinColumn(name = "id_docente", nullable = false)
    private Docente docente;
    @Column(name = "capacidad")
    private int capacidad;
    @Column(name = "ciclo")
    private int ciclo;
    @Column(name = "año")
    private int año = getYear() ;

    public int getYear(){
    Calendar now = Calendar.getInstance();   // Gets the current date and time
    int año1 = now.get(Calendar.YEAR);
    return año1;
    }

    public int getId_impartir() {
        return id_impartir;
    }

    public void setId_impartir(int id_impartir) {
        this.id_impartir = id_impartir;
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getCiclo() {
        return ciclo;
    }

    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.id_impartir;
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
        final Impartir other = (Impartir) obj;
        if (this.id_impartir != other.id_impartir) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Impartir{" + "id_impartir=" + id_impartir + '}';
    }
}
