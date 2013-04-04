/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.creacion.clases;

/**
 *
 * @author xtecuan
 */
public class Asignatura {

    private static int generadorCodAsignatura = 0;
    private String codAsignatura;
    private String desAsignatura;
    private Integer numUniVal;
    private Integer codFacultad;
    private Boolean estadoAsignatura = Boolean.TRUE;

    public Asignatura() {
        this.codAsignatura = generarCodAsig();
    }

    public Asignatura(String desAsignatura, Integer numUniVal, Integer codFacultad) {
        this.codAsignatura = generarCodAsig();
        this.desAsignatura = desAsignatura;
        this.numUniVal = numUniVal;
        this.codFacultad = codFacultad;
    }

    private static String generarCodAsig() {

        generadorCodAsignatura++;

        return String.valueOf(getGeneradorCodAsignatura()).length() == 1
                ? "000" + getGeneradorCodAsignatura()
                : "00" + getGeneradorCodAsignatura();

    }

    public String getCodAsignatura() {
        return codAsignatura;
    }

    public void setCodAsignatura(String codAsignatura) {
        this.codAsignatura = codAsignatura;
    }

    public String getDesAsignatura() {
        return desAsignatura;
    }

    public void setDesAsignatura(String desAsignatura) {
        this.desAsignatura = desAsignatura;
    }

    public Integer getNumUniVal() {
        return numUniVal;
    }

    public void setNumUniVal(Integer numUniVal) {
        this.numUniVal = numUniVal;
    }

    public Integer getCodFacultad() {
        return codFacultad;
    }

    public void setCodFacultad(Integer codFacultad) {
        this.codFacultad = codFacultad;
    }

    public static int getGeneradorCodAsignatura() {
        return generadorCodAsignatura;
    }

    @Override
    public String toString() {
        return "Asignatura{" + "codAsignatura=" + codAsignatura + ", desAsignatura=" + desAsignatura + ", numUniVal=" + numUniVal + ", codFacultad=" + codFacultad + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (this.codAsignatura != null ? this.codAsignatura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Asignatura other = (Asignatura) obj;
        if ((this.codAsignatura == null) ? (other.codAsignatura != null) : !this.codAsignatura.equals(other.codAsignatura)) {
            return false;
        }
        return true;
    }
    
    public void fijarEstadoAsignatura(Boolean estado){
        this.estadoAsignatura = estado;
    }
    
    
}
