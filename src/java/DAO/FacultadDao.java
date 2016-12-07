package DAO;

import Model.Facultad;
import java.sql.CallableStatement;



public class FacultadDao extends DAO {
    
    public void registrarFacultad(Facultad fac) throws Exception {
        try {
            this.Conectar();
            CallableStatement cs = this.getCn().prepareCall("{call insertar_facultad(?,?)}");
            cs.setString(1, fac.getCodigo_facultad());
            cs.setString(2, fac.getNombre_facultad());
            cs.executeQuery();

        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

}
