
package DAO;

import Model.Carrera;
import Model.Facultad;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;


public class CarreraDao extends DAO{
    Carrera carrera;
    Facultad facultad;
    public void registrarCarrera(Carrera car) throws Exception{
        try {
            this.Conectar();
            CallableStatement cs = this.getCn().prepareCall("{call insertar_carrera(?,?,?,?)}");
            cs.setString(1, car.getCodigo_carrera());
            cs.setString(2, car.getNombre_carrera());
            cs.setInt(3, car.getFacultad().getId_facultad());
            cs.registerOutParameter(4, Types.INTEGER);
            cs.executeQuery();

        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
    
    public void llenarCmb(){
        try {
            this.Conectar();
            Statement sent= getCn().createStatement();
            ResultSet rs = sent.executeQuery("SELECT * from facultad");
            
        } catch (Exception e) {
        }
    }
}
