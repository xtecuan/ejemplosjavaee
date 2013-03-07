/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.apps.cloud.regciclistas.web.viewcontroller;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.xtecuan.apps.cloud.entities.Ciclista;
import org.xtecuan.apps.cloud.entities.Departamento;
import org.xtecuan.apps.cloud.entities.DetalleCiclista;
import org.xtecuan.apps.cloud.entities.Municipio;
import org.xtecuan.apps.cloud.entities.Pais;
import org.xtecuan.apps.cloud.regciclistas.web.viewcontroller.model.CiclistasDataModel;
import org.xtecuan.apps.cloud.regciclistas.web.viewcontroller.utils.ViewUtils;
import org.xtecuan.apps.cloud.services.ManttoCiclistasService;

/**
 *
 * @author xtecuan
 */
@Component("manttoCiclistas")
@Scope("view")
public class ManttoCiclistas extends XBaseBean implements Serializable {

    @Autowired
    private ManttoCiclistasService manttoCiclistasService;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Ciclista current;
    private DetalleCiclista currentDet;
    private Pais currentPais;
    private Departamento currentDepto;
    private Municipio currentMuni;
    private String clave1;
    private CiclistasDataModel modeloTabla;
    private Date minimalDate;
    private String minimalDateStr;
    private List<SelectItem> itemsPaises;
    private List<SelectItem> itemsDeptos;
    private List<SelectItem> itemsMunis;
    private List<SelectItem> itemsSexo;
    private Boolean insert = Boolean.TRUE;
    private Ciclista selected;

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
        itemsPaises = ViewUtils.fromListCatPaisesToListSelectItem(manttoCiclistasService.findAllPaises());
    }

    private void initModeloTabla() {

        modeloTabla = new CiclistasDataModel(manttoCiclistasService.getServiceCiclista());
    }

    private void initInstance() {

        current = new Ciclista();
        currentDet = new DetalleCiclista();
        currentPais = new Pais();
        currentDepto = new Departamento();
        currentMuni = new Municipio();
        selected = new Ciclista();


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

    public Ciclista getCurrent() {
        return current;
    }

    public void setCurrent(Ciclista current) {
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
            itemsDeptos = ViewUtils.fromListCatDepartamentosToListSelectItem(manttoCiclistasService.findDeptosByIdPais(idPais));
        }


        if (itemsDeptos.isEmpty()) {
            addMessage("No existen departamentos para: ", "Pais: " + idPais);
        }

    }

    public void manejarCambioDepto() {

        itemsMunis = new ArrayList<SelectItem>(0);

        Integer coddepto = currentDepto.getCoddepto();

        if (coddepto != null && coddepto.intValue() > 0) {

            itemsMunis = ViewUtils.fromListCatMunicipiosToListSelectItem(manttoCiclistasService.findMunisByCodDepto(coddepto));
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

            Ciclista c = manttoCiclistasService.guardarCiclista(current, currentDet);
            initInstance();
            addMessage("Se creo un ciclista: ", "Id: " + c.getIdCiclista());
        } else {
            getLogger().error("Se requiere que las dos claves coincidan para el registro de ciclistas!!!");

            addError("Error al validar las claves: ", "Las dos claves deben coincidir");
        }

    }

    public void delete(ActionEvent event) {


        if (selected != null && selected.getIdCiclista() > 0) {

            Integer id = selected.getIdCiclista();

            manttoCiclistasService.borrarCiclista(selected);

            addMessage("Se borro un registro", "con Id: " + id);

        } else {

            addMessage("Seleccione un ciclista: ", "Para Borrar");
        }

    }

    public void editarCiclista(ActionEvent event) {

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


            Ciclista c = manttoCiclistasService.actualizarCiclista(current, currentDet);
            initInstance();
            insert = Boolean.TRUE;
            addMessage("Se actualizo un ciclista: ", "Id: " + c.getIdCiclista());
        } else {
            getLogger().error("Se requiere que las dos claves coincidan para el registro de ciclistas!!!");

            addError("Error al validar las claves: ", "Las dos claves deben coincidir");
        }
    }

    private void populateDeptosAndMunisForEdit(Ciclista ciclista) {

        Ciclista ciclistaAttached = manttoCiclistasService.getServiceCiclista().find(ciclista.getIdCiclista());
        
        DetalleCiclista det = ciclistaAttached.getDetalleCiclistaList().get(0);

        itemsDeptos = ViewUtils.fromListCatDepartamentosToListSelectItem(manttoCiclistasService.findDeptosByIdPais(det.getCodpais().getIdPais()));
        itemsMunis = ViewUtils.fromListCatMunicipiosToListSelectItem(manttoCiclistasService.findMunisByCodDepto(det.getCodmuni().getCoddepto().getCoddepto()));
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

    public DetalleCiclista getCurrentDet() {
        return currentDet;
    }

    public void setCurrentDet(DetalleCiclista currentDet) {
        this.currentDet = currentDet;
    }

    public Pais getCurrentPais() {
        return currentPais;
    }

    public void setCurrentPais(Pais currentPais) {
        this.currentPais = currentPais;
    }

    public Departamento getCurrentDepto() {
        return currentDepto;
    }

    public void setCurrentDepto(Departamento currentDepto) {
        this.currentDepto = currentDepto;
    }

    public Municipio getCurrentMuni() {
        return currentMuni;
    }

    public void setCurrentMuni(Municipio currentMuni) {
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

    public Ciclista getSelected() {
        return selected;
    }

    public void setSelected(Ciclista selected) {
        this.selected = selected;
    }
}
