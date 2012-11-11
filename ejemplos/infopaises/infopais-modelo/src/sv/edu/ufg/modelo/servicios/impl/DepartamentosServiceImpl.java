/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.modelo.servicios.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.sql.DataSource;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;
import sv.edu.ufg.modelo.entidades.Departamentos;
import sv.edu.ufg.modelo.servicios.DepartamentosService;

/**
 *
 * @author xtecuan
 */
@Transactional
public class DepartamentosServiceImpl implements DepartamentosService {

    private static final Logger logger = Logger.getLogger(DepartamentosServiceImpl.class);
    private static final long serialVersionUID = 1L;
    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager em;
    private DataSource dataSource;
    private Session mailSession;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setMailSession(Session mailSession) {
        this.mailSession = mailSession;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    /**
     *
     * @param from
     * @param subject
     * @param to
     * @param bodyText
     * @param filename
     */
    @Override
    public void sendEmail(String from, String subject, String to, String bodyText, String filename) {
        try {
            MimeMessage message = new MimeMessage(mailSession);
            message.setFrom(new InternetAddress(from));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setSentDate(new Date());

            //
            // Set the email message text.
            //
            MimeBodyPart messagePart = new MimeBodyPart();
            messagePart.setText(bodyText);

            //
            // Set the email attachment file
            //
            MimeBodyPart attachmentPart = new MimeBodyPart();
            FileDataSource fileDataSource = new FileDataSource(filename) {
                @Override
                public String getContentType() {
                    return "application/octet-stream";
                }
            };
            attachmentPart.setDataHandler(new DataHandler(fileDataSource));
            attachmentPart.setFileName(FilenameUtils.getName(filename));

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messagePart);
            multipart.addBodyPart(attachmentPart);

            message.setContent(multipart);

            Transport.send(message);
        } catch (MessagingException e) {
            logger.error("Error al enviar mensaje de correo con archivo Adjunto: ", e);
        }
    }

    /**
     *
     * @param email
     * @param subject
     * @param body
     */
    @Override
    public void sendEmail(String email, String subject, String body) {

        try {
            MimeMessage message = new MimeMessage(mailSession);
            message.setSubject(subject);
            message.setRecipients(RecipientType.TO, InternetAddress.parse(email, false));
            message.setText(body);
            Transport.send(message);
        } catch (Exception ex) {
            logger.error("Error al enviar mensaje de correo: ", ex);
        }
    }

    /**
     *
     * @param from
     * @param subject
     * @param to
     * @param bodyText
     * @param data (byte[])
     * @param filename
     */
    @Override
    public void sendEmail(String from, String subject, String to, String bodyText, byte[] data, String filename) {
        try {
            MimeMessage message = new MimeMessage(mailSession);
            message.setFrom(new InternetAddress(from));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setSentDate(new Date());

            //
            // Set the email message text.
            //
            MimeBodyPart messagePart = new MimeBodyPart();
            messagePart.setText(bodyText);

            //
            // Set the email attachment file
            //
            MimeBodyPart attachmentPart = new MimeBodyPart();
            ByteArrayDataSource byteDataSource = new ByteArrayDataSource(data, "application/octet-stream");
            attachmentPart.setDataHandler(new DataHandler(byteDataSource));
            attachmentPart.setFileName(filename);

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messagePart);
            multipart.addBodyPart(attachmentPart);

            message.setContent(multipart);

            Transport.send(message);
        } catch (MessagingException e) {
            logger.error("Error al enviar mensaje de correo con archivo Adjunto (arreglo de bytes): ", e);
        }
    }

    @Override
    public Departamentos guardarDepartamento(Departamentos depto) {

        Departamentos salida = null;

        try {

            getEm().persist(depto);

            salida = depto;

        } catch (Exception e) {

            logger.error("Error al guardar la entidad de tipo Departamentos: " + depto, e);
        }

        return salida;
    }

    @Override
    public Departamentos actualizarDepartamento(Departamentos depto) {

        Departamentos salida = null;

        try {

            getEm().merge(depto);


            salida = depto;

        } catch (Exception e) {

            logger.error("Error al editar la entidad de tipo Departamentos: " + depto, e);
        }

        return salida;
    }

    @Override
    public Departamentos encontrarPorId(Integer idDepto) {
        return getEm().find(Departamentos.class, idDepto);
    }

    @Override
    public List<Departamentos> encontrarTodos() {
        List<Departamentos> deptos = new ArrayList<Departamentos>(0);

        try {
            Query query = getEm().createNamedQuery("Departamentos.findAll", Departamentos.class);

            deptos = query.getResultList();
        } catch (Exception e) {

            logger.error("Error al ejecutar el metodo :  encontrarTodos()", e);
        }

        return deptos;
    }

    @Override
    public List<Departamentos> encontrarLikeAbreviatura(String paramLike) {
        List<Departamentos> deptos = new ArrayList<Departamentos>(0);

        try {
            Query query = getEm().createNamedQuery("Departamentos.encontrarLikeAbreviatura", Departamentos.class);

            query.setParameter("paramLike", paramLike + "%");

            deptos = query.getResultList();
        } catch (Exception e) {

            logger.error("Error al ejecutar el metodo :  encontrarLikeAbreviatura(String paramLike)", e);
        }

        return deptos;
    }

    @Override
    public List<Departamentos> encontrarPorUnRango(int primerElemento, int cuantos) {
        List<Departamentos> deptos = new ArrayList<Departamentos>(0);

        try {
            Query query = getEm().createNamedQuery("Departamentos.findAll", Departamentos.class);

            query.setFirstResult(primerElemento);
            query.setMaxResults(cuantos);

            deptos = query.getResultList();
        } catch (Exception e) {

            logger.error("Error al ejecutar el metodo :  encontrarPorUnRango(int primerElemento, int cuantos)", e);
        }

        return deptos;
    }

    @Override
    public void borrarDepartamento(Departamentos depto) {
        try {

            getEm().remove(getEm().merge(depto));

        } catch (Exception e) {
            logger.error("Error al borrar la entidad de tipo Departamentos: "+depto, e);
        }
    }

    @Override
    public int contarTodos() {
        EntityManager em1 = this.getEm().getEntityManagerFactory().createEntityManager();
        CriteriaQuery cq = em1.getCriteriaBuilder().createQuery();
        Root<Object> rt = cq.from(Departamentos.class);
        cq.select(em1.getCriteriaBuilder().count(rt));
        Query q = em1.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
    
}
