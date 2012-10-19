/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.ejemplos.vistacontrolador.modelo;

import java.util.ArrayList;
import java.util.List;
import javax.faces.model.DataModel;
import org.apache.log4j.Logger;
import org.xtecuan.ejemplos.modelo.dto.AlumnosDTO;
import org.xtecuan.ejemplos.modelo.ejb.AlumnosFacadeLocal;

/**
 *
 * @author xtecuan
 */
public class AlumnosBeanModel extends DataModel<AlumnosDTO> {

    private static final Logger logger = Logger.getLogger(AlumnosBeanModel.class);
    private AlumnosFacadeLocal facade;
    private List<AlumnosDTO> list = new ArrayList<AlumnosDTO>(0);

    public AlumnosBeanModel(AlumnosFacadeLocal facade) {
        this.facade = facade;

    }

    private void init() {

        try {

            list = facade.encontrarTodosLosAlumnos();

        } catch (Exception e) {
            logger.error("Error al inicializar el DataModel", e);
        }
    }

    public AlumnosBeanModel() {
    }

    public void setFacade(AlumnosFacadeLocal facade) {
        this.facade = facade;
    }

    @Override
    public boolean isRowAvailable() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getRowCount() {

        int count = 0;

        try {
            count = facade.contarAlumnos();
        } catch (Exception e) {
            logger.error("Error al contar los alumnos en el DataModel", e);
        }

        return count;
    }

    @Override
    public AlumnosDTO getRowData() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getRowIndex() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setRowIndex(int rowIndex) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object getWrappedData() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setWrappedData(Object data) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
