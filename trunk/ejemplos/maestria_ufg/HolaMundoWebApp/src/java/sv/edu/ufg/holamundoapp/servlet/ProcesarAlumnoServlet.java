/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.holamundoapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.xtecuan.mir.facade.AlumnosFacade;
import sv.edu.ufg.ejemplos.obtenerentrada.teclado.Alumno;

/**
 *
 * @author xtecuan
 */
public class ProcesarAlumnoServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Información del Alumno</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Información Alumno</h1>");

            if (request.getParameter("guardar") != null) {

                int guardar = Integer.parseInt(request.getParameter("guardar"));

                if (guardar == 0) {

                    String carnet = request.getParameter("carnet");
                    String nombres = request.getParameter("nombres");
                    String apellidos = request.getParameter("apellidos");
                    String correo = request.getParameter("correo");
                    String fechanac = request.getParameter("fechanac");

                    Alumno alumno = new Alumno();

                    if (carnet != null && carnet.length() >= 10) {
                        alumno.setCarnet(carnet);
                    }

                    if (nombres != null && nombres.length() > 0) {
                        alumno.setNombres(nombres);
                    }

                    if (apellidos != null && apellidos.length() > 0) {
                        alumno.setApellidos(apellidos);
                    }

                    if (correo != null && correo.length() > 1) {
                        alumno.setCorreo(correo);
                    }


                    if (fechanac != null && fechanac.length() == 10) {



                        alumno.setFechanac(AlumnosFacade.fromStringToDate(fechanac));
                    }

                    out.println(alumno.toWebString());



                    session.setAttribute("alumno", alumno);

                    out.println("<a href=\"" + this.getServletContext().getContextPath() + "/procesar.ufg?guardar=1\">Guardar</a>");
                }

                if (guardar == 1) {

                    Alumno al = (Alumno) session.getAttribute("alumno");

                    Alumno al1 = AlumnosFacade.guardarAlumno(al);
                    
                    if(al1!=null){
                        
                        out.println("<h1 style='color:green'>Se guardo el siguiente alumno:</h1>"+al1.toWebString());
                    }
                }
            }
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
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
