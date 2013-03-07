/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.apps.cloud.regciclistas.web.viewcontroller.model;

import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.xtecuan.apps.cloud.dao.CiclistaDao;
import org.xtecuan.apps.cloud.entities.Ciclista;

/**
 *
 * @author xtecuan
 */
public class CiclistasDataModel extends LazyDataModel<Ciclista> {

    private static Logger logger = Logger.getLogger(CiclistasDataModel.class);
    private CiclistaDao service;

    public CiclistasDataModel() {
    }

    public CiclistasDataModel(CiclistaDao service) {
        this.service = service;
    }

    @Override
    public int getRowCount() {
        return service.count();
    }

    @Override
    public Ciclista getRowData(String rowKey) {
        logger.info(rowKey);
        return service.find(Integer.valueOf(rowKey));
    }

    @Override
    public Object getRowKey(Ciclista object) {
        return object.getIdCiclista();
    }

    @Override
    public void setRowIndex(int rowIndex) {
        /*
         * The following is in ancestor (LazyDataModel): this.rowIndex =
         * rowIndex == -1 ? rowIndex : (rowIndex % pageSize);
         */
        if (rowIndex == -1 || getPageSize() == 0) {
            super.setRowIndex(-1);
        } else {
            super.setRowIndex(rowIndex % getPageSize());
        }
    }
    @Override
    public List<Ciclista> load(int first, int pageSize, String string, SortOrder so, Map<String, String> map) {
        this.setRowCount(service.count());
        //this.setRowIndex(first);

        logger.debug("first: " + first);
        logger.debug("pageSize: " + pageSize);

//        int[] rango = {first * pageSize, first * pageSize + pageSize};
        int[] rango = {first, pageSize};
        return service.findSomeRange(first, pageSize);
    }

    public void setService(CiclistaDao service) {
        this.service = service;
    }

    public CiclistaDao getService() {
        return service;
    }
}
