/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xtecuan.vistacontrolador.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import org.apache.log4j.Logger;
import org.xtecuan.modelo.dto.AlumnosDTO;
import org.xtecuan.modelo.ejb.BuquedaBean;

/**
 *
 * @author xtecuan
 */
public class BusquedaServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(BusquedaServlet.class);
    @EJB
    private BuquedaBean buquedaBean;

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        try {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet BusquedaServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet BusquedaServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        } finally {            
//            out.close();
//        }

        HttpSession session = request.getSession();

        List<AlumnosDTO> dtos = new ArrayList<AlumnosDTO>(0);

        try {
            String nombresLike = request.getParameter("nombresLike");

            if (nombresLike != null && nombresLike.length() > 0) {

                dtos = buquedaBean.buscarAlumnoPorNombresLike(nombresLike);

                if (!dtos.isEmpty()) {

                    session.setAttribute("respuesta", dtos);
                } else {

                    session.setAttribute("error", "No se encontraron alumnos para : " + nombresLike);
                }

            } else {

                session.setAttribute("error", "No se envio el parametro de busqueda!!!"
                        + "");
            }

        } catch (Exception e) {

            logger.error("Error en ejecucion del Servlet: ", e);
        }

        String url = response.encodeRedirectURL("busquedaAlumnos.jsp");

        response.sendRedirect(url);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
