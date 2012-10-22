/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.ejemplos.modelo.ejb;

import javax.ejb.Local;
import org.xtecuan.ejemplos.modelo.dto.AlumnosDTO;
import org.xtecuan.ejemplos.modelo.excepciones.ManttoTablaAlumnosException;

/**
 *
 * @author xtecuan
 */
@Local
public interface AlumnosFacadeLocal {

    AlumnosDTO guardarAlumnos(AlumnosDTO alumno) throws ManttoTablaAlumnosException;

    AlumnosDTO guardarAlumnosTest(String carnet, String nombres, String apellidos, String correo, String fechanac) throws ManttoTablaAlumnosException;

    java.util.List<AlumnosDTO> encontrarTodosLosAlumnos() throws ManttoTablaAlumnosException;

    Integer contarAlumnos() throws ManttoTablaAlumnosException;

    int borrarAlumno(AlumnosDTO alumno) throws ManttoTablaAlumnosException;
}
