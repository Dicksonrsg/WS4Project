
package dao;

import model.Available;
import util.GenericDAO;

public class AvailableDAO extends GenericDAO<Available>{

    @Override
    public Class<Available> getClassType() {
        return Available.class;
    }
    
}
