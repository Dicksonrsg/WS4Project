package dao;

import model.Days;

public class DayDAO extends GenericDAO<Days> {

    @Override
    public Class<Days> getClassType() {
        return Days.class;
    }
    
}
