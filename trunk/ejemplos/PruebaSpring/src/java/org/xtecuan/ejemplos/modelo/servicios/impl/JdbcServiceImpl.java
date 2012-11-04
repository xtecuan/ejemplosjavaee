/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.ejemplos.modelo.servicios.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.xtecuan.ejemplos.modelo.dto.AlumnosDTO;
import org.xtecuan.ejemplos.modelo.servicios.JdbcService;

/**
 *
 * @author ufg
 */
public class JdbcServiceImpl implements JdbcService, Serializable {

    private static final Logger logger = Logger.getLogger(JdbcServiceImpl.class);
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    private String user;
    private String pass;
    private String driver;
    private String url;

    public JdbcServiceImpl() {
    }

    public static Date getDateFromString(String dateStr) {

        Date date = null;

        try {
            date = sdf.parse(dateStr);
        } catch (Exception e) {
            logger.error("Error al convertir el String " + dateStr + " a fecha ", e);
        }

        return date;

    }

    private Connection getConnection() {

        Connection conn = null;

        try {

            Class classDriver = Class.forName(driver);

            DriverManager.registerDriver((Driver) classDriver.newInstance());

            conn = DriverManager.getConnection(url, user, pass);

            logger.info("Se establecio conexion hacia la base de datos: " + url);


        } catch (Exception e) {

            logger.error("Error al establecer la conexion hacia la url: " + url, e);
        }

        return conn;
    }

    @Override
    public AlumnosDTO guardarAlumnos(AlumnosDTO alumno) {

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

                conn = getConnection();

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

                    logger.error("Error de persistencia al guardar un registro de la clase alumno");
                }

                psta.close();


            } else {

                logger.error("El carnet, los nomnbres y apellidos son obligatorios!!!");

            }


            //psta = conn.prepareStatement(null, i)
        } catch (Exception e) {

            logger.error("Error generado: ", e);
            logger.error("Error al insertar un alumno hacia la base de datos");
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
    public AlumnosDTO guardarAlumnosTest(String carnet, String nombres, String apellidos, String correo, String fechanac) {

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

        }

        return alumno;
    }

    @Override
    public java.util.List<AlumnosDTO> encontrarTodosLosAlumnos() {

        List<AlumnosDTO> dtos = new ArrayList<AlumnosDTO>(0);
        Connection conn = null;
        Statement sta = null;
        ResultSet rset = null;
        try {

            conn = getConnection();
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
    public Integer contarAlumnos() {
        int counter = 0;

        Connection conn = null;
        Statement sta = null;
        ResultSet rset = null;
        try {

            conn = getConnection();
            sta = conn.createStatement();
            rset = sta.executeQuery(AlumnosDTO.getSELECT_ALL_COUNT());
            while (rset.next()) {

                counter = rset.getInt(1);
            }

            rset.close();
            sta.close();



        } catch (Exception e) {

            logger.error("Error al obtener el listado de todos los alumnos: ", e);

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
    public int borrarAlumno(AlumnosDTO alumno) {

        int result = FALLO_AL_BORRAR;
        Connection conn = null;
        PreparedStatement psta = null;

        try {

            conn = getConnection();
            psta = conn.prepareStatement(AlumnosDTO.getDELETE());
            psta.setInt(1, alumno.getId().intValue());

            int r = psta.executeUpdate();

            if (r == 1) {

                result = EXITO_AL_BORRAR;
            }

            psta.close();


        } catch (Exception e) {

            logger.error("Error al borrar el alumno: " + e.getCause().getMessage());
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

    @Override
    public int actualizarAlumno(AlumnosDTO alumno) {
        int result = FALLO_AL_ACTUALIZAR;
        Connection conn = null;
        PreparedStatement psta = null;

        try {
            StringBuilder nombres = new StringBuilder();
            List<Object> params = new ArrayList<Object>(0);

            boolean idBool = alumno.getId() != null && alumno.getId().intValue() > 0;
            boolean correoBool = alumno.getCorreo() != null && alumno.getCorreo().length() > 0;
            boolean fechacBool = alumno.getFechanac() != null;
            boolean carnetBool = alumno.getCarnet() != null && alumno.getCarnet().length() >= 10;
            boolean nombresBool = alumno.getNombres() != null && alumno.getNombres().length() > 0;
            boolean apellidosBool = alumno.getApellidos() != null && alumno.getApellidos().length() > 0;


            if (carnetBool && nombresBool && apellidosBool & idBool) {

                params.add(alumno.getCarnet());
                nombres.append("carnet=?,");
                params.add(alumno.getNombres());
                nombres.append("nombres=?,");
                params.add(alumno.getApellidos());
                nombres.append("apellidos=?");

                conn = getConnection();

                if (alumno.getCorreo() != null && alumno.getCorreo().length() > 0) {

                    nombres.append(",correo=?");

                    params.add(alumno.getCorreo());
                }
                if (alumno.getFechanac() != null) {
                    nombres.append(",fechanac=?");
                    params.add(alumno.getFechanac());
                }

                params.add(alumno.getId());

                String update = AlumnosDTO.getUpdate(nombres);
                logger.info("Ejecutando el update: " + update);
                psta = conn.prepareStatement(update);
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

                int r1 = psta.executeUpdate();

                if (r1 == 1) {
                    result = EXITO_AL_ACTUALIZAR;
                } else {

                    logger.error("No se ingreso ningun registro debido a un problema de persistencia!!!");
                }

                psta.close();


            } else {

                logger.error("El carnet, los nomnbres y apellidos son obligatorios!!!");

            }


            //psta = conn.prepareStatement(null, i)
        } catch (Exception e) {

            logger.error("Error generado: ", e);
            logger.error("Error al insertar un alumno hacia la base de datos");
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

    public void setUser(String user) {
        this.user = user;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
