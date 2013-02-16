/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.vistacontrolador.modelo;

import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.xtecuan.modelo.ejb.facade.CiclistasFacade;
import org.xtecuan.modelo.entidades.Ciclistas;

/**
 *
 * @author xtecuan
 */
public class CiclistasDataModel extends LazyDataModel<Ciclistas> {

    private static Logger logger = Logger.getLogger(CiclistasDataModel.class);
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

//    @Override
//    public void setRowIndex(int rowIndex) {
//        /*
//         * The following is in ancestor (LazyDataModel): this.rowIndex =
//         * rowIndex == -1 ? rowIndex : (rowIndex % pageSize);
//         */
//        if (rowIndex == -1 || getPageSize() == 0) {
//            super.setRowIndex(-1);
//        } else {
//            super.setRowIndex(rowIndex % getPageSize());
//        }
//    }
    @Override
    public List<Ciclistas> load(int first, int pageSize, String string, SortOrder so, Map<String, String> map) {
//        this.setRowCount(service.count());
        //this.setRowIndex(first);

        logger.debug("first: " + first);
        logger.debug("pageSize: " + pageSize);

//        int[] rango = {first * pageSize, first * pageSize + pageSize};
        int[] rango = {first, pageSize};
        return service.findRange(rango);
    }

    public void setService(CiclistasFacade service) {
        this.service = service;
    }

    public CiclistasFacade getService() {
        return service;
    }
}
