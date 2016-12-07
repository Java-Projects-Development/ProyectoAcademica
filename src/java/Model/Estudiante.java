
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
@Table(name="estudiante")
public class Estudiante implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_estudiante;
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
    @Column(name="correo")
    private String correo;
    @ManyToOne
    @JoinColumn(name="id_carrera", nullable=false)
    private Carrera id_carrera;
    
    public int getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Carrera getId_carrera() {
        return id_carrera;
    }

    public void setId_carrera(Carrera id_carrera) {
        this.id_carrera = id_carrera;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.id_estudiante;
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
        final Estudiante other = (Estudiante) obj;
        if (this.id_estudiante != other.id_estudiante) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "id_estudiante=" + id_estudiante + '}';
    }

}
