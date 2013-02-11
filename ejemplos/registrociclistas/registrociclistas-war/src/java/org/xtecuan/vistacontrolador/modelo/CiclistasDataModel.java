/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.vistacontrolador.modelo;

import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.xtecuan.modelo.ejb.facade.CiclistasFacade;
import org.xtecuan.modelo.entidades.Ciclistas;

/**
 *
 * @author xtecuan
 */
public class CiclistasDataModel extends LazyDataModel<Ciclistas> {

    private CiclistasFacade service;

    public CiclistasDataModel() {
    }

    public CiclistasDataModel(CiclistasFacade service) {
        this.service = service;
    }

    @Override
    public int getRowCount() {
        return service.count();
    }

    @Override
    public Ciclistas getRowData(String rowKey) {
        return service.find(Integer.valueOf(rowKey));
    }

    @Override
    public Object getRowKey(Ciclistas object) {
        return object.getIdCiclista();
    }

    @Override
    public List<Ciclistas> load(int first, int pageSize, String string, SortOrder so, Map<String, String> map) {
        this.setRowCount(service.count());

        int[] rango = {first * pageSize, first * pageSize + pageSize};

        return service.findRange(rango);
    }

    public void setService(CiclistasFacade service) {
        this.service = service;
    }

    public CiclistasFacade getService() {
        return service;
    }
}
