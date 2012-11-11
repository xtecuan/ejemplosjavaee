/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.modelo.servicios;

import java.io.Serializable;
import java.util.List;
import sv.edu.ufg.modelo.entidades.Departamentos;

/**
 *
 * @author xtecuan
 */
public interface DepartamentosService extends Serializable {

    public void sendEmail(String email, String subject, String body);

    public void sendEmail(String from, String subject, String to, String bodyText, String filename);

    public void sendEmail(String from, String subject, String to, String bodyText, byte[] data, String filename);

    public Departamentos guardarDepartamento(Departamentos depto);

    public Departamentos actualizarDepartamento(Departamentos depto);

    public Departamentos encontrarPorId(Integer idDepto);

    public List<Departamentos> encontrarTodos();

    public List<Departamentos> encontrarLikeAbreviatura(String paramLike);

    public List<Departamentos> encontrarPorUnRango(int primerElemento, int cuantos);

    public void borrarDepartamento(Departamentos depto);

    public int contarTodos();
}
