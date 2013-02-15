/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.vistacontrolador.utils;

import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import org.xtecuan.modelo.entidades.CatDepartamentos;
import org.xtecuan.modelo.entidades.CatMunicipios;
import org.xtecuan.modelo.entidades.CatPaises;
import org.xtecuan.modelo.enums.SexoEnum;

/**
 *
 * @author xtecuan
 */
public final class ViewUtils {

    public static List<SelectItem> fromListCatPaisesToListSelectItem(List<CatPaises> paises) {

        List<SelectItem> items = new ArrayList<SelectItem>(0);

        for (CatPaises pais : paises) {
            items.add(new SelectItem(pais.getIdPais(), pais.getDesPais()));
        }

        return items;

    }

    public static List<SelectItem> fromListCatDepartamentosToListSelectItem(List<CatDepartamentos> deptos) {

        List<SelectItem> items = new ArrayList<SelectItem>(0);

        for (CatDepartamentos depto : deptos) {
            items.add(new SelectItem(depto.getCoddepto(), depto.getDesdepto()));
        }

        return items;

    }

    public static List<SelectItem> fromListCatMunicipiosToListSelectItem(List<CatMunicipios> munis) {

        List<SelectItem> items = new ArrayList<SelectItem>(0);

        for (CatMunicipios muni : munis) {
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
