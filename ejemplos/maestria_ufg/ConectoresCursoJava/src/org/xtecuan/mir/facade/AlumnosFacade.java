/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.mir.facade;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.xtecuan.mir.conectores.mysql.MySQLConn;
import sv.edu.ufg.ejemplos.obtenerentrada.teclado.Alumno;

/**
 *
 * @author xtecuan
 */
public class AlumnosFacade {

    private static final Logger logger = Logger.getLogger(AlumnosFacade.class);

    public static void guardarAlumnos(Alumno[] alumnos) {

        for (int i = 0; i < alumnos.length; i++) {
            guardarAlumno(alumnos[i]);

        }
    }

    public static Alumno guardarAlumno(Alumno alumno) {

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

                conn = MySQLConn.obtenerConexion();

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

                String insert = Alumno.getInsert(nombres, marcas);

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

        return alumno;
    }
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static Date fromStringToDate(String fecha) {

        Date salida = null;

        try {
            salida = sdf.parse(fecha);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return salida;
    }

    public static void main(String[] args) {

        Alumno al = new Alumno("RP95533002", "Julian Tadeo", "Rivera Pineda", "xtecuan@gmail.com", fromStringToDate("05/11/1976"));
        Alumno al1 = guardarAlumno(al);
    }
}
