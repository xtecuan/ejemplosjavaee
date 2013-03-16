/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.samples.archivos;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author javaee
 */
public class CreadorArchivosCommonsIO {

    public static void main(String[] args) throws IOException {

        String archStr = System.getProperty("user.home") + File.separator + "textoEjemplo.txt";

        FileUtils.writeStringToFile(new File(archStr), CreadorArchivos.generarTexto().toString());

    }
}
