/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.modelo.ejb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import org.apache.log4j.Logger;
import org.xtecuan.modelo.dto.AlumnosDTO;

/**
 *
 * @author xtecuan
 */
@Stateless
public class BuquedaBean {

    @Resource(name = "dataSource")
    private DataSource dataSource;
    private static final Logger logger = Logger.getLogger(BuquedaBean.class);

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public java.util.List<org.xtecuan.modelo.dto.AlumnosDTO> buscarAlumnoPorNombresLike(String nombreLike) {

        Connection conn = null;
        PreparedStatement psta = null;
        List<AlumnosDTO> respuesta = new ArrayList<AlumnosDTO>(0);



        try {

            conn = dataSource.getConnection();

            psta = conn.prepareStatement(AlumnosDTO.getSELECT_LIKE_NOMBRES());

            psta.setString(1, "%" + nombreLike + "%");

            ResultSet rset = psta.executeQuery();


            while (rset.next()) {

                AlumnosDTO dto = new AlumnosDTO();

                Integer id = rset.getInt("id");
                dto.setId(id);
                String carnet = rset.getString("carnet");
                dto.setCarnet(carnet);
                String nombres = rset.getString("nombres");
                dto.setNombres(nombres);
                String apellidos = rset.getString("apellidos");
                dto.setApellidos(apellidos);
                String correo = rset.getString("correo");

                if (correo != null && correo.length() > 0) {
                    dto.setCorreo(correo);
                }

                java.sql.Date fechaSQL = rset.getDate("fechanac");
                if (fechaSQL != null) {

                    dto.setFechanac(new Date(fechaSQL.getTime()));
                }

                respuesta.add(dto);


            }

            rset.close();
            psta.close();


        } catch (Exception e) {

            logger.error("Error al buscar alumnos por nombre like: ", e);
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                logger.error("Error al cerrar la conexion !!!", ex);
            }
        }


        return respuesta;
    }
}
