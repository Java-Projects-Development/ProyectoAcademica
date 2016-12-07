package DAO;

import java.sql.DriverManager;
import java.sql.Connection;


public class DAO {

    private Connection cn;

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }

    public void Conectar() throws Exception {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            cn = (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "C##academica", "admin");
        } catch (Exception e) {
            throw e;
        }
    }

    public void Cerrar() throws Exception {
        try {
            if (cn != null) {
                if (cn.isClosed() == false) {
                    cn.close();
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    

}
