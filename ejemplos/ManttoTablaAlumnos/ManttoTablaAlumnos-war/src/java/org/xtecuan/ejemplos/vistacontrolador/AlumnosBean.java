/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.ejemplos.vistacontrolador;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import org.apache.log4j.Logger;
import org.xtecuan.ejemplos.modelo.constantes.Constantes;
import org.xtecuan.ejemplos.modelo.dto.AlumnosDTO;
import org.xtecuan.ejemplos.modelo.ejb.AlumnosFacadeLocal;
import org.xtecuan.ejemplos.modelo.excepciones.ManttoTablaAlumnosException;

/**
 *
 * @author xtecuan
 */
public class AlumnosBean implements Serializable {

    @EJB
    private AlumnosFacadeLocal alumnosFacade;
    private AlumnosDTO alumno;
    private static final Logger logger = Logger.getLogger(AlumnosBean.class);
    private List<SelectItem> itemsDias = new ArrayList<SelectItem>(0);
    private List<SelectItem> itemsMeses = new ArrayList<SelectItem>(0);
    private List<SelectItem> itemsAnnios = new ArrayList<SelectItem>(0);
    private static SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
    private static SimpleDateFormat sdfFecha = new SimpleDateFormat("dd-MM-yyyy");
    private static SimpleDateFormat sdfMonth = new SimpleDateFormat("MM");
    private final SimpleDateFormat sdfMonthSpanish = new SimpleDateFormat("MMMMM", new Locale("es", "SV"));
    private Integer dia;
    private Integer mes;
    private Integer annio;
    private ListDataModel<AlumnosDTO> model = new ListDataModel<AlumnosDTO>();
    private HtmlDataTable table = new HtmlDataTable();
    private Boolean modoInsert = Boolean.TRUE;

    /**
     * Creates a new instance of AlumnosBean
     */
    public AlumnosBean() {
    }

    @PostConstruct
    private void init() {
        initViewVariables();
        popularDias();
        popularMeses();
        popularAnnios();
        popularTableModel();
    }

    private void initViewVariables() {
        alumno = new AlumnosDTO();
        dia = 0;
        mes = 0;
        annio = 0;
    }

    private void popularDias() {
        for (int i = 1; i <= 31; i++) {
            itemsDias.add(new SelectItem(Integer.valueOf(i), Integer.valueOf(i).toString()));
        }
    }

    private void popularMeses() {
        for (int i = 1; i <= 12; i++) {
            try {
                Date d = sdfMonth.parse(String.valueOf(i));
                itemsMeses.add(new SelectItem(Integer.valueOf(i), sdfMonthSpanish.format(d).toUpperCase()));
            } catch (ParseException ex) {
                logger.error("Error al parsear los meses: mes: " + i, ex);
            }
        }
    }

    private void popularAnnios() {
        Date fa = new Date();
        String annio1 = sdfYear.format(fa);
        for (int i = 1900; i <= Integer.valueOf(annio1).intValue(); i++) {
            itemsAnnios.add(new SelectItem(Integer.valueOf(i), Integer.valueOf(i).toString()));
        }
    }

    private void popularTableModel() {
        try {
            List<AlumnosDTO> dtos = alumnosFacade.encontrarTodosLosAlumnos();

            this.model = new ListDataModel<AlumnosDTO>(dtos);

        } catch (Exception e) {
            logger.error("Error al llenar el modelo de alumnos: ", e);
        }
    }

    public AlumnosDTO getAlumno() {

        if (alumno == null) {
            alumno = new AlumnosDTO();
        }

        return alumno;
    }

    public void setAlumno(AlumnosDTO alumno) {
        this.alumno = alumno;
    }

    public String cancelar() {

        initViewVariables();
        return "alumnos?faces-redirect=true";
    }

    public void actualizarInformacion(ActionEvent event) {
        int salida = Constantes.FALLO_AL_ACTUALIZAR;

        if (alumno != null) {

            if (dia.intValue() > 0 && mes.intValue() > 0 && annio.intValue() > 0) {

                String fechaStr = dia.intValue() + "-" + mes.intValue() + "-" + annio.intValue();

                Date fechaObj = null;

                try {

                    fechaObj = sdfFecha.parse(fechaStr);

                    if (fechaObj != null) {
                        alumno.setFechanac(fechaObj);
                    }

                } catch (Exception e) {

                    logger.error("Error al parsear la fecha desde los combos!!!", e);
                }

            }

            try {
                salida = alumnosFacade.actualizarAlumno(alumno);

                if (salida == Constantes.EXITO_AL_ACTUALIZAR) {

                    adicionarMensaje("Se actualizo un alumno con id: " + getAlumno().getId());
                    setModoInsert(Boolean.TRUE);
                    initViewVariables();
                    popularTableModel();
                }

            } catch (ManttoTablaAlumnosException ex) {

                logger.error("Error al actualizar el alumno!!!", ex);

                adicionarError("Error al actualizar el alumno en la base de datos!!!");
            }
        }

    }

    public void guardarInformacion(ActionEvent event) {
        AlumnosDTO salida = null;

        if (alumno != null) {

            if (dia.intValue() > 0 && mes.intValue() > 0 && annio.intValue() > 0) {

                String fechaStr = dia.intValue() + "-" + mes.intValue() + "-" + annio.intValue();

                Date fechaObj = null;

                try {

                    fechaObj = sdfFecha.parse(fechaStr);

                    if (fechaObj != null) {
                        alumno.setFechanac(fechaObj);
                    }

                } catch (Exception e) {

                    logger.error("Error al parsear la fecha desde los combos!!!", e);
                }

            }

            try {
                salida = alumnosFacade.guardarAlumnos(alumno);

                if (salida != null) {

                    adicionarMensaje("Se ingreso un alumno con id: " + salida.getId());
                    initViewVariables();
                    popularTableModel();
                }

            } catch (ManttoTablaAlumnosException ex) {

                logger.error("Error al guardar el alumno!!!", ex);

                adicionarError("Error al guardar el alumno en la base de datos!!!");
            }
        }

    }

    public void prepararEdicion(ActionEvent event) {

        AlumnosDTO dto = (AlumnosDTO) table.getRowData();

        setAlumno(dto);

        setModoInsert(Boolean.FALSE);

        logger.info("Se selecciono el alumno: " + dto + " para edicion");

    }

    public void borrarInformacion(ActionEvent event) {

        AlumnosDTO dto = (AlumnosDTO) table.getRowData();
        try {
            int r = alumnosFacade.borrarAlumno(dto);
            if (r == Constantes.EXITO_AL_BORRAR) {
                adicionarMensaje("Se borro el alumno con id: " + dto.getId());
                popularTableModel();
            }
        } catch (ManttoTablaAlumnosException ex) {
            logger.error("Error al borrar el alumno", ex);
            adicionarError("Error al borrar el alumno!!!");
        }

        logger.info("Se selecciono el alumno: " + dto + " para borrar");

    }

    private void adicionarMensaje(String mensaje) {

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(mensaje));
    }

    private void adicionarError(String error) {

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error:", error));
    }

    public List<SelectItem> getItemsDias() {
        return itemsDias;
    }

    public void setItemsDias(List<SelectItem> itemsDias) {
        this.itemsDias = itemsDias;
    }

    public List<SelectItem> getItemsMeses() {
        return itemsMeses;
    }

    public void setItemsMeses(List<SelectItem> itemsMeses) {
        this.itemsMeses = itemsMeses;
    }

    public List<SelectItem> getItemsAnnios() {
        return itemsAnnios;
    }

    public void setItemsAnnios(List<SelectItem> itemsAnnios) {
        this.itemsAnnios = itemsAnnios;
    }

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Integer getAnnio() {
        return annio;
    }

    public void setAnnio(Integer annio) {
        this.annio = annio;
    }

    public ListDataModel<AlumnosDTO> getModel() {
        return model;
    }

    public void setModel(ListDataModel<AlumnosDTO> model) {
        this.model = model;
    }

    public HtmlDataTable getTable() {
        return table;
    }

    public void setTable(HtmlDataTable table) {
        this.table = table;
    }

    public Boolean getModoInsert() {
        return modoInsert;
    }

    public void setModoInsert(Boolean modoInsert) {
        this.modoInsert = modoInsert;
    }
}
