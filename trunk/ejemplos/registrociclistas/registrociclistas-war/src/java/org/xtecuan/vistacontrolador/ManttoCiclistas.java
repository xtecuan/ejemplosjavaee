/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.vistacontrolador;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import org.xtecuan.modelo.ejb.facade.ManttoCiclistasFacade;
import org.xtecuan.modelo.entidades.CatDepartamentos;
import org.xtecuan.modelo.entidades.CatMunicipios;
import org.xtecuan.modelo.entidades.CatPaises;
import org.xtecuan.modelo.entidades.Ciclistas;
import org.xtecuan.modelo.entidades.DetCiclistas;
import org.xtecuan.vistacontrolador.modelo.CiclistasDataModel;
import org.xtecuan.vistacontrolador.utils.ViewUtils;

/**
 *
 * @author xtecuan
 */
public class ManttoCiclistas extends XBaseBean implements Serializable {

    @EJB
    private ManttoCiclistasFacade manttoCiclistasFacade;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Ciclistas current;
    private DetCiclistas currentDet;
    private CatPaises currentPais;
    private CatDepartamentos currentDepto;
    private CatMunicipios currentMuni;
    private String clave1;
    private CiclistasDataModel modeloTabla;
    private Date minimalDate;
    private String minimalDateStr;
    private List<SelectItem> itemsPaises;
    private List<SelectItem> itemsDeptos;
    private List<SelectItem> itemsMunis;
    private List<SelectItem> itemsSexo;
    private Boolean insert = Boolean.TRUE;
    private Ciclistas selected;

    /**
     * Creates a new instance of ManttoCiclistas
     */
    public ManttoCiclistas() {
    }

    @PostConstruct
    private void init() {
        initInstance();
        initModeloTabla();
        initMinimalDate();
        initItemsPaises();
        initItemsSexo();
    }

    private void initItemsSexo() {

        itemsSexo = ViewUtils.fromSexoEnumToListSelectItem();
    }

    private void initItemsPaises() {
        itemsPaises = ViewUtils.fromListCatPaisesToListSelectItem(manttoCiclistasFacade.findAllPaises());
    }

    private void initModeloTabla() {

        modeloTabla = new CiclistasDataModel(manttoCiclistasFacade.getFacadeCiclistas());
    }

    private void initInstance() {

        current = new Ciclistas();
        currentDet = new DetCiclistas();
        currentPais = new CatPaises();
        currentDepto = new CatDepartamentos();
        currentMuni = new CatMunicipios();
        selected = new Ciclistas();


//        current.setDetCiclistas(new DetCiclistas());
//        current.getDetCiclistas().setCodpais(new CatPaises());
//        current.getDetCiclistas().setCodmuni(new CatMunicipios());
//        current.getDetCiclistas().getCodmuni().setCoddepto(new CatDepartamentos());
        clave1 = "";

    }

    private void initMinimalDate() {
        try {
            minimalDate = sdf.parse("01/01/1900");
        } catch (ParseException ex) {
            getLogger().error("Error al inicializar la fecha minima: ", ex);
        }

        minimalDateStr = "01/01/1900";

    }

    public Ciclistas getCurrent() {
        return current;
    }

    public void setCurrent(Ciclistas current) {
        this.current = current;
    }

    public String getClave1() {
        return clave1;
    }

    public void setClave1(String clave1) {
        this.clave1 = clave1;
    }

    public void manejarCambioPais() {

        itemsDeptos = new ArrayList<SelectItem>(0);

        Integer idPais = currentPais.getIdPais();

        if (idPais != null && idPais.intValue() > 0) {
            itemsDeptos = ViewUtils.fromListCatDepartamentosToListSelectItem(manttoCiclistasFacade.findDeptosByIdPais(idPais));
        }


        if (itemsDeptos.isEmpty()) {
            addMessage("No existen departamentos para: ", "Pais: " + idPais);
        }

    }

    public void manejarCambioDepto() {

        itemsMunis = new ArrayList<SelectItem>(0);

        Integer coddepto = currentDepto.getCoddepto();

        if (coddepto != null && coddepto.intValue() > 0) {

            itemsMunis = ViewUtils.fromListCatMunicipiosToListSelectItem(manttoCiclistasFacade.findMunisByCodDepto(coddepto));
        }

        if (itemsMunis.isEmpty()) {
            addMessage("No existen Municipios para: ", "Depto.: " + coddepto);
        }

    }

    public void guardarCiclista(ActionEvent event) {

//        if (current.getClave().equals(clave1)) {
//
//            ciclistasFacade.create(current);
//
//            getLogger().info("Se creo un ciclista con id: " + current.getIdCiclista());
//            addMessage("Se creo un ciclista: ", "Id: " + current.getIdCiclista());
//
//            initInstance();
//            initModeloTabla();
//
//        } else {
//            getLogger().error("Se requiere que las dos claves coincidan para el registro de ciclistas!!!");
//
//            addError("Error al validar las claves: ", "Las dos claves deben coincidir");
//        }

        if (current.getClave().equals(clave1)) {
            getLogger().info("current: " + current);
            getLogger().info("currentDet: " + currentDet);
            getLogger().info("currentPais: " + currentPais);
            getLogger().info("currentDepto: " + currentDepto);
            getLogger().info("currentMuni: " + currentMuni);

            if (currentPais.getIdPais() != null && currentPais.getIdPais().intValue() > 0) {

                currentDet.setCodpais(currentPais);
            }

            if (currentMuni.getCodmuni() != null && currentMuni.getCodmuni().intValue() > 0) {
                currentDet.setCodmuni(currentMuni);
            }


//        current.setClave(md5Hex(current.getClave()));

            Ciclistas c = manttoCiclistasFacade.guardarCiclista(current, currentDet);
            initInstance();
            addMessage("Se creo un ciclista: ", "Id: " + c.getIdCiclista());
        } else {
            getLogger().error("Se requiere que las dos claves coincidan para el registro de ciclistas!!!");

            addError("Error al validar las claves: ", "Las dos claves deben coincidir");
        }

    }

    public void editarCiclista(ActionEvent event) {
        
        
    }

    private void populateDeptosAndMunisForEdit(Ciclistas ciclista) {

        DetCiclistas det = ciclista.getDetCiclistasList().get(0);

        itemsDeptos = ViewUtils.fromListCatDepartamentosToListSelectItem(manttoCiclistasFacade.findDeptosByIdPais(det.getCodpais().getIdPais()));
        itemsMunis = ViewUtils.fromListCatMunicipiosToListSelectItem(manttoCiclistasFacade.findMunisByCodDepto(det.getCodmuni().getCoddepto().getCoddepto()));
        setCurrentDepto(det.getCodmuni().getCoddepto());
        setCurrentMuni(det.getCodmuni());
        setCurrentPais(det.getCodpais());
        setCurrentDet(det);
        setCurrent(ciclista);
        insert = Boolean.FALSE;
    }

    public void prepareEdit(ActionEvent event) {

        getLogger().info(selected);

        if (selected != null) {

            populateDeptosAndMunisForEdit(selected);

        }

    }

    public CiclistasDataModel getModeloTabla() {
        return modeloTabla;
    }

    public void setModeloTabla(CiclistasDataModel modeloTabla) {
        this.modeloTabla = modeloTabla;
    }

    public Date getMinimalDate() {
        return minimalDate;
    }

    public void setMinimalDate(Date minimalDate) {
        this.minimalDate = minimalDate;
    }

    public String getMinimalDateStr() {
        return minimalDateStr;
    }

    public void setMinimalDateStr(String minimalDateStr) {
        this.minimalDateStr = minimalDateStr;
    }

    public List<SelectItem> getItemsPaises() {
        return itemsPaises;
    }

    public void setItemsPaises(List<SelectItem> itemsPaises) {
        this.itemsPaises = itemsPaises;
    }

    public List<SelectItem> getItemsDeptos() {
        return itemsDeptos;
    }

    public void setItemsDeptos(List<SelectItem> itemsDeptos) {
        this.itemsDeptos = itemsDeptos;
    }

    public List<SelectItem> getItemsMunis() {
        return itemsMunis;
    }

    public void setItemsMunis(List<SelectItem> itemsMunis) {
        this.itemsMunis = itemsMunis;
    }

    public DetCiclistas getCurrentDet() {
        return currentDet;
    }

    public void setCurrentDet(DetCiclistas currentDet) {
        this.currentDet = currentDet;
    }

    public CatPaises getCurrentPais() {
        return currentPais;
    }

    public void setCurrentPais(CatPaises currentPais) {
        this.currentPais = currentPais;
    }

    public CatDepartamentos getCurrentDepto() {
        return currentDepto;
    }

    public void setCurrentDepto(CatDepartamentos currentDepto) {
        this.currentDepto = currentDepto;
    }

    public CatMunicipios getCurrentMuni() {
        return currentMuni;
    }

    public void setCurrentMuni(CatMunicipios currentMuni) {
        this.currentMuni = currentMuni;
    }

    public List<SelectItem> getItemsSexo() {
        return itemsSexo;
    }

    public void setItemsSexo(List<SelectItem> itemsSexo) {
        this.itemsSexo = itemsSexo;
    }

    public Boolean getInsert() {
        return insert;
    }

    public void setInsert(Boolean insert) {
        this.insert = insert;
    }

    public Ciclistas getSelected() {
        return selected;
    }

    public void setSelected(Ciclistas selected) {
        this.selected = selected;
    }
}
