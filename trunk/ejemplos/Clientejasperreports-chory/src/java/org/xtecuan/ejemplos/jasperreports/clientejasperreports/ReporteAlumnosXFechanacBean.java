/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.ejemplos.jasperreports.clientejasperreports;

import com.googlecode.xtecuannet.framework.model.services.ReportsService;
import com.googlecode.xtecuannet.framework.viewcontroller.beans.XBaseBean;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.faces.event.ActionEvent;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author xtecuan
 */
public class ReporteAlumnosXFechanacBean extends XBaseBean implements Serializable {

    private static final String DATE_PATTERN = "dd-MM-yyyy";
    private static final String PARAM = "p_fechanac";
    private static final String REPORTE = "reporteAlumnos_X_fechanac.jrxml";
    private String pfechanac;
    private Date fechanac;
    @Autowired
    private ReportsService service;
    private static SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);

    public ReporteAlumnosXFechanacBean() {
    }

    public void generarReporte(ActionEvent event) {


        pfechanac = sdf.format(fechanac);


        if (pfechanac != null && pfechanac.length() >= 10) {

            Map map = new HashMap();

            map.put(PARAM, pfechanac);

            byte[] reporte = service.generarReporteConParametros(REPORTE, ReportsService.PDF, map);

            if (reporte != null) {

                downloadFile(reporte, FilenameUtils.getBaseName(REPORTE) + ".pdf");
            }


        } else {

            addMessage(
                    getBundle().getMessage("reporte_x_fechanac_error_summary", null, Locale.ENGLISH),
                    getBundle().getMessage("reporte_x_fechanac_error_pfechanac", null, Locale.ENGLISH));

        }

    }

    public String getPfechanac() {
        return pfechanac;
    }

    public void setPfechanac(String pfechanac) {
        this.pfechanac = pfechanac;
    }

    public ReportsService getService() {
        return service;
    }

    public void setService(ReportsService service) {
        this.service = service;
    }

    public Date getFechanac() {
        return fechanac;
    }

    public void setFechanac(Date fechanac) {
        this.fechanac = fechanac;
    }
}
