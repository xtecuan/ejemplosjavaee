/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.creacion.clases.enums;

/**
 *
 * @author xtecuan
 */
public enum Facultades {

    Ingenieria(Integer.valueOf("1"), "Ingenieria"),
    Economia(Integer.valueOf("2"), "Economia"),
    Humanidades(Integer.valueOf("3"), "Humanidades");
    private Integer codFacultad;
    private String desFacultad;

    private Facultades(Integer codFacultad, String desFacultad) {
        this.codFacultad = codFacultad;
        this.desFacultad = desFacultad;
    }

    public Integer getCodFacultad() {
        return codFacultad;
    }

    public void setCodFacultad(Integer codFacultad) {
        this.codFacultad = codFacultad;
    }

    public String getDesFacultad() {
        return desFacultad;
    }

    public void setDesFacultad(String desFacultad) {
        this.desFacultad = desFacultad;
    }
}
