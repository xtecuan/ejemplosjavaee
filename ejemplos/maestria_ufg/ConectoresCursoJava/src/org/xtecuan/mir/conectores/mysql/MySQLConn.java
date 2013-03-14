/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.mir.conectores.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import org.apache.log4j.Logger;

/**
 *
 * @author xtecuan
 */
public final class MySQLConn {

    private static final Logger logger = Logger.getLogger(MySQLConn.class);
    private static final String USER = "alumnos";
    private static final String PASS = "welcome1";
    private static final String URL = "jdbc:mysql://localhost:3306/alumnos?zeroDateTimeBehavior=convertToNull";

    public static Connection obtenerConexion() {
        Connection conn = null;

        try {

            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn = DriverManager.getConnection(URL, USER, PASS);

        } catch (Exception e) {
            logger.error("Error al obtener la conexion desde: " + URL, e);
        }


        return conn;
    }
}
