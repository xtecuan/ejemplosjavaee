/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ugb.preespecializacion.proyectos.holamundospring_webapp.servicios.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import org.apache.log4j.Logger;
import org.xtecuan.modelo.ws.dto.AlumnosDTO;
import sv.edu.ugb.preespecializacion.proyectos.holamundospring_webapp.servicios.AlumnosDao;

/**
 *
 * @author xtecuan
 */
public class AlumnosDaoImpl implements Serializable, AlumnosDao {

    private static Logger logger = Logger.getLogger(AlumnosDaoImpl.class);
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public AlumnosDaoImpl() {
    }

    private Connection obtenerConexion() {

        Connection conn = null;

        try {

            conn = dataSource.getConnection();

        } catch (Exception e) {
            logger.error("Error al obtener la conexion: ", e);
        }

        return conn;
    }

    @Override
    public List<AlumnosDTO> listarAlumnos() {

        List<AlumnosDTO> listado = new ArrayList<AlumnosDTO>(0);

        Connection conn = null;

        try {

            conn = obtenerConexion();
            PreparedStatement psta = conn.prepareStatement(AlumnosDTO.SELECT_ALL);

            ResultSet rset = psta.executeQuery();

            while (rset.next()) {

                AlumnosDTO dto = new AlumnosDTO();

                dto.setId(rset.getInt("id"));
                dto.setCarnet(rset.getString("carnet"));
                dto.setNombres(rset.getString("nombres"));
                dto.setApellidos(rset.getString("apellidos"));

                String correo = rset.getString("correo");

                if (correo != null && correo.length() > 0) {
                    dto.setCorreo(correo);
                }

                java.sql.Date fecha = rset.getDate("fechanac");

                if (fecha != null) {

                    dto.setFechanac(new Date(fecha.getTime()));
                }

                listado.add(dto);



            }

            rset.close();
            psta.close();



        } catch (Exception e) {

            logger.error("Error llenando el listado de alumnos: ", e);
        } finally {

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                logger.error("Error al cerrar la conexion: ", e);
            }
        }

        return listado;

    }
}
