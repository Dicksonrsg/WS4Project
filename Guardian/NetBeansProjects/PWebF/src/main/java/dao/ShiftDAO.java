package dao;

import model.Shift;

public class ShiftDAO extends GenericDAO<Shift>{

    @Override
    public Class<Shift> getClassType() {
        return Shift.class;
    }
    
}
