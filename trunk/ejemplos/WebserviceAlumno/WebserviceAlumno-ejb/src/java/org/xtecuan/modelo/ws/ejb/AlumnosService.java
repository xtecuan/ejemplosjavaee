/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.modelo.ws.ejb;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.xtecuan.modelo.ws.dto.AlumnosDTO;
import org.xtecuan.modelo.ws.entidades.Alumnos;

/**
 *
 * @author xtecuan
 */
@Stateless
@LocalBean
public class AlumnosService {

    @EJB
    private AlumnosFacade alumnosFacade;
    private static Logger logger = Logger.getLogger(AlumnosDTO.class);

    public AlumnosDTO buscarAlumnoPorId(String id) {

        AlumnosDTO salida = new AlumnosDTO();

        try {

            
            Alumnos alumno = alumnosFacade.find(Integer.valueOf(id));

            if (alumno != null) {

                logger.info("Entro busqueda por id");
                salida = fromEntity2DTO(alumno);
            }

        } catch (Exception e) {
            
            logger.error("Error al ejecutar el metodo: buscarAlumnoPorId ", e);
        }

        return salida;
    }

    private AlumnosDTO fromEntity2DTO(Alumnos ent) {

        AlumnosDTO dto = new AlumnosDTO();

        try {

            BeanUtils.copyProperties(dto, ent);

        } catch (Exception e) {
        }

        return dto;
    }

    public java.util.List<AlumnosDTO> buscarTodosLosAlumnos() {

        List<AlumnosDTO> dtos = new ArrayList<AlumnosDTO>(0);

        try {

            List<Alumnos> alumnos = alumnosFacade.findAll();

            if (!alumnos.isEmpty()) {


                for (Alumnos alum : alumnos) {

                    dtos.add(fromEntity2DTO(alum));
                }

            }


        } catch (Exception e) {
            
            logger.error("Error al ejecutar el metodo: buscarTodosLosAlumnos ", e);
        }

        return dtos;
    }
}
