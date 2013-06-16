/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.examples.primefaces.primefaces.download;

import java.io.InputStream;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author xtecuan
 */
public class DownloadBean implements Serializable {

    private static final String IMAGES_PATH = "/images";
    private static final String RESOURCE_NAME = "sun.jpg";
    private static final String CONTENT_TYPE = "image/jpg";
    private StreamedContent file;

    public StreamedContent getFile() {
        return file;
    }

    public void setFile(StreamedContent file) {
        this.file = file;
    }

    @PostConstruct
    private void init() {

        file = new DefaultStreamedContent(getFileStreamFor(IMAGES_PATH, RESOURCE_NAME), CONTENT_TYPE, RESOURCE_NAME);
    }

    private InputStream getFileStreamFor(String path, String resourceName) {
        return ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream(path + "/" + resourceName);
    }
}
