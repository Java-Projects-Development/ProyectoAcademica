/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Model.Impartir;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author said
 */
@Local
public interface ImpartirFacadeLocal {

    void create(Impartir impartir);

    void edit(Impartir impartir);

    void remove(Impartir impartir);

    Impartir find(Object id);

    List<Impartir> findAll();

    List<Impartir> findRange(int[] range);

    int count();
    
}
