
package dao;

import model.Teacher;
import util.GenericDAO;

public class TeacherDAO extends GenericDAO<Teacher>{

    @Override
    public Class<Teacher> getClassType() {
        return Teacher.class;
    }
     
}
