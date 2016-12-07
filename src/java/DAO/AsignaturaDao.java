
package DAO;

import Model.Asignatura;
import java.sql.CallableStatement;


public class AsignaturaDao extends DAO{
     
    public void registrarAsignatura(Asignatura asi) throws Exception {
        try {
            this.Conectar();
            CallableStatement cs = this.getCn().prepareCall("{call insertar_asignatura(?,?,?)}");
            cs.setString(1, asi.getCodigo_asignatura());
            cs.setString(2, asi.getNombre_asignatura());
            cs.setInt(3, asi.getUv());
            cs.executeQuery();

        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
}
