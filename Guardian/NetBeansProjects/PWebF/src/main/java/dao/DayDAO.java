package dao;

import model.Day;

public class DayDAO extends GenericDAO<Day> {

    @Override
    public Class<Day> getClassType() {
        return Day.class;
    }
    
}
