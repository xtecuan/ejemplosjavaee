/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.ejemplos.jasperreports.clientejasperreports;

import com.xtesoft.xtecuannet.framework.model.services.ReportsService;
import com.xtesoft.xtecuannet.framework.viewcontroller.beans.XBaseBean;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author xtecuan
 */
public class ReporteAlumnosXCorreoBean extends XBaseBean {

    private static final String PARAM = "pcorreo";
    private static final String REPORTE = "ReporteAlumnosXCorreo.jrxml";
    @Autowired
    private ReportsService service;
    private String pcorreo;

    /**
     * Creates a new instance of ReporteAlumnosXCorreoBean
     */
    public ReporteAlumnosXCorreoBean() {
    }

    public void setService(ReportsService service) {
        this.service = service;
    }

    public String getPcorreo() {
        return pcorreo;
    }

    public void setPcorreo(String pcorreo) {
        this.pcorreo = pcorreo;
    }

    public void generarReporte(ActionEvent event) {

        if (pcorreo != null && pcorreo.length() > 0) {

            Map params = new HashMap();
            params.put(PARAM, pcorreo);
            byte[] reporte = this.service.generarReporteConParametros(REPORTE, ReportsService.PDF, params);

            if (reporte != null) {

                this.downloadFile(reporte, FilenameUtils.getBaseName(REPORTE) + ".pdf");
            } else {
                addMessage(
                        getBundle().getMessage("index_error_summary", null, Locale.ENGLISH),
                        getBundle().getMessage("index_error_nopages", null, Locale.ENGLISH));
            }

        } else {

            addMessage(
                    getBundle().getMessage("index_error_summary", null, Locale.ENGLISH),
                    getBundle().getMessage("index_error_pcorreo", null, Locale.ENGLISH));
        }

        FacesContext.getCurrentInstance().renderResponse();

    }
}
