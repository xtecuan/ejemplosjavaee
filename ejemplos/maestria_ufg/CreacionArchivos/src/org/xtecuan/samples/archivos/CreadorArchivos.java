/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.samples.archivos;

import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author javaee
 */
public class CreadorArchivos {

    private static final int TAMANA_TEXT = 100;

    public static void crearArchivoDeTexto(String path, String nombreArchivo, StringBuilder contenido) {

        File pathObj = new File(path);
        File archivo = new File(pathObj, nombreArchivo);

        FileWriter fw = null;

        try {
            fw = new FileWriter(archivo);

            System.out.println("Se creo el archivo : " + archivo.getPath());
            fw.write(contenido.toString());

            fw.flush();

            fw.close();

        } catch (Exception e) {
            System.err.println("Error creando el archivo: " + archivo.getPath());
            e.printStackTrace();
        }
    }

    public static StringBuilder generarTexto() {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= TAMANA_TEXT; i++) {

            sb.append("TEXTO_").append(i).append("\n");

        }

        return sb;
    }

    public static void main(String[] args) {

//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 1; i <= TAMANA_TEXT; i++) {
//
//            sb.append("TEXTO_").append(i).append("\n");
//
//        }


        crearArchivoDeTexto(System.getProperty("user.home"), "ejemploArchivo.txt", generarTexto());

    }
}
