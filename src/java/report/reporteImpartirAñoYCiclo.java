/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package report;

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author said
 */
public class reporteImpartirAñoYCiclo {

    public void getReporte(String ruta, int facultad, int ciclo, int año) throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException {

        Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
        Connection cn;
        cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "C##testacademica", "admin");

        Map parameter = new HashMap();
        parameter.put("facultad", facultad);
        parameter.put("ciclo", ciclo);
        parameter.put("año", año);
        

        try {
            File file = new File(ruta);
            HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();

            httpServletResponse.setContentType("application/pdf");
            httpServletResponse.addHeader("Content-type", "application/pdf");

            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(file.getPath());
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, cn);

            JRExporter jrExporter = null;
            jrExporter = new JRPdfExporter();
            jrExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            jrExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, httpServletResponse.getOutputStream());

            if (jrExporter != null) {
                try {
                    jrExporter.exportReport();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}