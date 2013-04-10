/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class ListHelper implements Serializable {

    private static final String[] nombresArray = {"Amelia", "Jaime Rojas", "Jimmy", "Liliana Serrano", "Manuel"};
    private List<String> nombres;

    public List<String> getNombres() {
        return nombres;
    }

    public void setNombres(List<String> nombres) {
        this.nombres = nombres;
    }

    public ListHelper() {
        populateList();
    }

    private void populateList() {

        nombres = new ArrayList<String>(0);

        for (int i = 0; i < nombresArray.length; i++) {
            String string = nombresArray[i];

            nombres.add(string);
        }
    }
}
