
package Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="docente")
public class Docente implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_docente;
    @Column(name="nombres")
    private String nombres;
    @Column(name="apellidos")
    private String apellidos;
    @Column(name="dui")
    private String dui;
    @Column(name="nit")
    private String nit;
    @Temporal(TemporalType.DATE)
    @Column(name="fechaNacimiento")
    private Date fechaNacimiento;
    @Column(name="sexo")
    private String sexo;
    @Column(name="telefono")
    private String telefono;
    @Column(name="direccion")
    private String direccion;
    @ManyToOne
    @JoinColumn(name="id_facultad", nullable=false)
    private Facultad facultad;

    public int getId_docente() {
        return id_docente;
    }

    public void setId_docente(int id_docente) {
        this.id_docente = id_docente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id_docente;
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
        final Docente other = (Docente) obj;
        if (this.id_docente != other.id_docente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Docente{" + "id_docente=" + id_docente + '}';
    }
}
