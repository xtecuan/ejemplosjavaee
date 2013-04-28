/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.ejemplos.spring.crud;

import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.xtecuan.ejemplos.spring.crud.modelo.entidades.Alumnos;
import org.xtecuan.ejemplos.spring.crud.modelo.services.AlumnosService;

/**
 *
 * @author xtecuan
 */
public class AlumnosTableModel extends LazyDataModel<Alumnos> {

    private AlumnosService service;

    public AlumnosService getService() {
        return service;
    }

    public void setService(AlumnosService service) {
        this.service = service;
    }

    public AlumnosTableModel(AlumnosService service) {
        this.service = service;
    }

    public AlumnosTableModel() {
    }

    @Override
    public List<Alumnos> load(int first, int pageSize, String string, SortOrder so, Map<String, String> map) {

        System.out.println("pagina: " + first);
        System.out.println("tamaño: " + pageSize);

        setRowCount(getService().count());

        return getService().findSomeRange(first, pageSize);

    }

    @Override
    public Alumnos getRowData(String rowKey) {
        return getService().find(Integer.valueOf(rowKey));
    }

    @Override
    public Object getRowKey(Alumnos object) {
        return object.getId();
    }
}
