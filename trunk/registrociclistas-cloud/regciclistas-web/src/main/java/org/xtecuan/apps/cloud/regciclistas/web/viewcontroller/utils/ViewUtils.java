/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.apps.cloud.regciclistas.web.viewcontroller.utils;

import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import org.xtecuan.apps.cloud.entities.Departamento;
import org.xtecuan.apps.cloud.entities.Municipio;
import org.xtecuan.apps.cloud.entities.Pais;
import org.xtecuan.apps.cloud.enums.SexoEnum;

/**
 *
 * @author xtecuan
 */
public final class ViewUtils {

    public static List<SelectItem> fromListCatPaisesToListSelectItem(List<Pais> paises) {

        List<SelectItem> items = new ArrayList<SelectItem>(0);

        for (Pais pais : paises) {
            items.add(new SelectItem(pais.getIdPais(), pais.getDesPais()));
        }

        return items;

    }

    public static List<SelectItem> fromListCatDepartamentosToListSelectItem(List<Departamento> deptos) {

        List<SelectItem> items = new ArrayList<SelectItem>(0);

        for (Departamento depto : deptos) {
            items.add(new SelectItem(depto.getCoddepto(), depto.getDesdepto()));
        }

        return items;

    }

    public static List<SelectItem> fromListCatMunicipiosToListSelectItem(List<Municipio> munis) {

        List<SelectItem> items = new ArrayList<SelectItem>(0);

        for (Municipio muni : munis) {
            items.add(new SelectItem(muni.getCodmuni(), muni.getDesmuni()));
        }

        return items;

    }

    public static List<SelectItem> fromSexoEnumToListSelectItem() {

        List<SelectItem> items = new ArrayList<SelectItem>(0);

        for (SexoEnum c : SexoEnum.values()) {
            items.add(new SelectItem(c.getCod(), c.getDes()));
        }

        return items;
    }
}
