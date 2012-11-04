/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.ejemplos.modelo.servicios;

import org.xtecuan.ejemplos.modelo.dto.AlumnosDTO;

/**
 *
 * @author ufg
 */
public interface JdbcService {
    
    public static final int FALLO_AL_BORRAR = -1000;
    public static final int EXITO_AL_BORRAR = 0;
    public static final int FALLO_AL_ACTUALIZAR = -1000;
    public static final int EXITO_AL_ACTUALIZAR = 0;

    AlumnosDTO guardarAlumnos(AlumnosDTO alumno);

    AlumnosDTO guardarAlumnosTest(String carnet, String nombres, String apellidos, String correo, String fechanac);

    java.util.List<AlumnosDTO> encontrarTodosLosAlumnos();

    Integer contarAlumnos();

    int borrarAlumno(AlumnosDTO alumno);

    int actualizarAlumno(AlumnosDTO alumno);
}
