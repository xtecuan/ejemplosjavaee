/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.ejemplos.modelo.ejb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import org.apache.log4j.Logger;
import org.xtecuan.ejemplos.modelo.constantes.Constantes;
import org.xtecuan.ejemplos.modelo.dto.AlumnosDTO;
import org.xtecuan.ejemplos.modelo.excepciones.ManttoTablaAlumnosException;

/**
 *
 * @author xtecuan
 */
//@WebService
@Stateless
public class AlumnosFacade implements AlumnosFacadeLocal {

    @Resource(name = "dataSource")
    private DataSource dataSource;
    private static Logger logger = Logger.getLogger(AlumnosFacade.class);
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    private Connection obtenerConexion() {

        Connection conn = null;

        try {

            conn = dataSource.getConnection();
            logger.info("Se establecio la conexion hacia la base de datos!!!");

        } catch (Exception e) {
            logger.error("Error al establecer la conexion: ", e);
        }

        return conn;
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public AlumnosDTO guardarAlumnos(AlumnosDTO alumno) throws ManttoTablaAlumnosException {

        Connection conn = null;
        PreparedStatement psta = null;
        ResultSet rset = null;

        try {


            StringBuilder nombres = new StringBuilder();
            StringBuilder marcas = new StringBuilder();

            List<Object> params = new ArrayList<Object>(0);

            boolean correoBool = alumno.getCorreo() != null && alumno.getCorreo().length() > 0;
            boolean fechacBool = alumno.getFechanac() != null;
            boolean carnetBool = alumno.getCarnet() != null && alumno.getCarnet().length() >= 10;
            boolean nombresBool = alumno.getNombres() != null && alumno.getNombres().length() > 0;
            boolean apellidosBool = alumno.getApellidos() != null && alumno.getApellidos().length() > 0;


            if (carnetBool && nombresBool && apellidosBool) {

                params.add(alumno.getCarnet());
                params.add(alumno.getNombres());
                params.add(alumno.getApellidos());

                conn = obtenerConexion();

                if (alumno.getCorreo() != null && alumno.getCorreo().length() > 0) {

                    nombres.append("correo");
                    marcas.append("?");
                    params.add(alumno.getCorreo());
                }
                if (alumno.getFechanac() != null) {
                    if (params.size() > 3) {
                        nombres.append(",");
                        marcas.append(",");
                    }
                    nombres.append("fechanac");
                    marcas.append("?");
                    params.add(alumno.getFechanac());
                }

                String insert = AlumnosDTO.getInsert(nombres, marcas);

                psta = conn.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);

                logger.info("Ejecutando el insert: " + insert);

                int i = 1;
                for (Object param : params) {

                    if (param instanceof Integer) {

                        psta.setInt(i, (Integer) param);
                    }

                    if (param instanceof String) {
                        psta.setString(i, (String) param);
                    }

                    if (param instanceof java.util.Date) {
                        Date fecha = (Date) param;
                        psta.setDate(i, new java.sql.Date(fecha.getTime()));
                    }

                    if (param instanceof Long) {
                        psta.setLong(i, (Long) param);
                    }

                    i++;
                }

                int result = psta.executeUpdate();

                if (result == 1) {
                    rset = psta.getGeneratedKeys();

                    while (rset.next()) {

                        int id = rset.getInt(1);

                        alumno.setId(id);
                    }

                    rset.close();
                } else {

                    throw new ManttoTablaAlumnosException("No se ingreso ningun registro debido a un problema de persistencia!!!");
                }

                psta.close();


            } else {

                throw new ManttoTablaAlumnosException("El carnet, los nomnbres y apellidos son obligatorios!!!");

            }


            //psta = conn.prepareStatement(null, i)
        } catch (Exception e) {

            logger.error("Error generado: ", e);
            throw new ManttoTablaAlumnosException("Error al insertar un alumno hacia la base de datos");
        } finally {

            try {
                if (conn != null) {

                    conn.close();
                }
            } catch (Exception e) {
                logger.error("Error al cerrar la conexion hacia la base de datos", e);
            }

        }

        return alumno;
    }

//    @WebMethod
    @Override
    public AlumnosDTO guardarAlumnosTest(String carnet, String nombres, String apellidos, String correo, String fechanac) throws ManttoTablaAlumnosException {

        AlumnosDTO alumno = null;
        boolean correoBool = correo != null && correo.length() > 0;
        boolean fechacBool = fechanac != null & fechanac.length() >= 10;
        boolean carnetBool = carnet != null && carnet.length() >= 10;
        boolean nombresBool = nombres != null && nombres.length() > 0;
        boolean apellidosBool = apellidos != null && apellidos.length() > 0;

        try {

            if (carnetBool && nombresBool && apellidosBool) {

                alumno = new AlumnosDTO();

                alumno.setCarnet(carnet);
                alumno.setNombres(nombres);
                alumno.setApellidos(apellidos);

                if (correoBool) {
                    alumno.setCorreo(correo);
                }


                if (fechacBool) {

                    Date fechanacObj = sdf.parse(fechanac);
                    alumno.setFechanac(fechanacObj);
                }

                alumno = guardarAlumnos(alumno);

            }

        } catch (Exception e) {

            logger.error("Error generado: ", e);
            throw new ManttoTablaAlumnosException(e.getMessage());
        }

        return alumno;
    }

    @Override
    public java.util.List<AlumnosDTO> encontrarTodosLosAlumnos() throws ManttoTablaAlumnosException {

        List<AlumnosDTO> dtos = new ArrayList<AlumnosDTO>(0);
        Connection conn = null;
        Statement sta = null;
        ResultSet rset = null;
        try {

            conn = obtenerConexion();
            sta = conn.createStatement();
            rset = sta.executeQuery(AlumnosDTO.getSELECT_ALL());
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

                java.sql.Date fechanac = rset.getDate("fechanac");

                if (fechanac != null) {
                    dto.setFechanac(new java.util.Date(fechanac.getTime()));
                }

                dtos.add(dto);

            }

            rset.close();
            sta.close();



        } catch (Exception e) {

            logger.error("Error al obtener el listado de todos los alumnos: ", e);
            throw new ManttoTablaAlumnosException(e.getMessage());
        } finally {

            try {
                if (conn != null) {

                    conn.close();
                }
            } catch (Exception e) {
                logger.error("Error al cerrar la conexion hacia la base de datos", e);
            }

        }

        return dtos;
    }

    @Override
    public Integer contarAlumnos() throws ManttoTablaAlumnosException {
        int counter = 0;

        Connection conn = null;
        Statement sta = null;
        ResultSet rset = null;
        try {

            conn = obtenerConexion();
            sta = conn.createStatement();
            rset = sta.executeQuery(AlumnosDTO.getSELECT_ALL_COUNT());
            while (rset.next()) {

                counter = rset.getInt(1);
            }

            rset.close();
            sta.close();



        } catch (Exception e) {

            logger.error("Error al obtener el listado de todos los alumnos: ", e);
            throw new ManttoTablaAlumnosException(e.getMessage());
        } finally {

            try {
                if (conn != null) {

                    conn.close();
                }
            } catch (Exception e) {
                logger.error("Error al cerrar la conexion hacia la base de datos", e);
            }

        }


        return counter;
    }

    @Override
    public int borrarAlumno(AlumnosDTO alumno) throws ManttoTablaAlumnosException {

        int result = Constantes.FALLO_AL_BORRAR;
        Connection conn = null;
        PreparedStatement psta = null;

        try {

            conn = obtenerConexion();
            psta = conn.prepareStatement(AlumnosDTO.getDELETE());
            psta.setInt(1, alumno.getId().intValue());

            int r = psta.executeUpdate();

            if (r == 1) {

                result = Constantes.EXITO_AL_BORRAR;
            }

            psta.close();


        } catch (Exception e) {

            throw new ManttoTablaAlumnosException("Error al borrar el alumno: " + e.getCause().getMessage());
        } finally {

            try {
                if (conn != null) {

                    conn.close();
                }
            } catch (Exception e) {
                logger.error("Error al cerrar la conexion hacia la base de datos", e);
            }

        }

        return result;
    }
}
