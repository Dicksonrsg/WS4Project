package dao;

import javax.persistence.EntityManager;
import model.Teacher;

public class TeacherDAO extends GenericDAO<Teacher>{
	
    @Override
    public Class<Teacher> getClassType() {
        return Teacher.class;
    }
    
    public Teacher findByRG(int rg){
    	Teacher teac = new Teacher();
    	String jpql = "from tb_teachers where tea_rg =" + rg;
    	EntityManager em = getEm();
    	javax.persistence.Query que = em.createQuery(jpql);
    	return teac = (Teacher) que.getSingleResult();
    }

}
