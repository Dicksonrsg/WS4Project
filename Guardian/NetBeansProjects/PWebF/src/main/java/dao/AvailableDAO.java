package dao;

import model.Available;

public class AvailableDAO extends GenericDAO<Available> {

    @Override
    public Class<Available> getClassType() {
        return Available.class;
    }
    
}
