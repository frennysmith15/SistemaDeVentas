/*
 * Frenny Smith De La Cruz All Rights Reserved <Propiedad Intelectual> *Solo personal autorizado*.
 * Matricula -> 100510483
 * UNIVERSIDAD AUTONOMA DE SANTO DOMINGO RECINTO UASD SAN FRANCISCO DE MACORIS (CURNE).
 */
package prjsistemaventas.interfaces;

import java.util.ArrayList;
import prjsistemaventas.dao.Usuario;

/**
 *
 * @author Frensth
 */
public interface ICRUD {
    public Boolean insertar();
    public Boolean eliminar();
    public ArrayList mostrar(int codigo);
    public ArrayList mostrarTodos();
    public Boolean actualizar();
}
