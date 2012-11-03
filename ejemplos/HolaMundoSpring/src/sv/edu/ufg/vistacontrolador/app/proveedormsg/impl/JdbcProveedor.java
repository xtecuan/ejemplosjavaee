/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.vistacontrolador.app.proveedormsg.impl;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import sv.edu.ufg.vistacontrolador.app.proveedormsg.ProveedorMensajes;

/**
 *
 * @author ufg
 */
public class JdbcProveedor implements ProveedorMensajes {

    private Integer idMensaje;
//    private static final String user = "alumnos";
//    private static final String pass = "welcome1";
//    private static final String url = "jdbc:mysql://localhost:3306/alumnos?zeroDateTimeBehavior=convertToNull";
//    private static final String query = "select mensaje from mensajes where id=?";
    
    private  String user ;
    private  String pass;
    private  String url;
    private  String query;
    private  String driver;

    private String obtenerTextoDesdeBase(Integer id) {

        String salida = "N/A";

        Connection conn = null;
        PreparedStatement psta = null;
        ResultSet rset = null;

        try {
//            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            
            Class f = Class.forName(driver);
            
            DriverManager.registerDriver((Driver)f.newInstance());
            
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Se obtuvo la conexion");

            psta = conn.prepareStatement(query);
            psta.setInt(1, id);

            rset = psta.executeQuery();

            while (rset.next()) {

                salida = rset.getString(1);

            }
            rset.close();
            psta.close();



        } catch (Exception e) {

            e.printStackTrace();
        } finally {

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return salida;

    }

    @Override
    public String obtenerMensaje() {
        return obtenerTextoDesdeBase(1);
    }

    public void setIdMensaje(Integer idMensaje) {
        this.idMensaje = idMensaje;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
    
    
}
