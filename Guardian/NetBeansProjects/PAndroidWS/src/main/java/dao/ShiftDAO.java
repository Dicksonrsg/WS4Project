
package dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import model.Shift;
import util.GenericDAO;

public class ShiftDAO extends GenericDAO<Shift>{

    @Override
    public Class<Shift> getClassType() {
        return Shift.class;
    }
    
    public Shift searchByGroup(String group){
        
        try{
            EntityManager ent = getEm();
            Query query = ent.createQuery("SELECT s FROM tb_shifts s WHERE s.group = :gr");
            query.setParameter("gr", group);
            Shift shift = (Shift) query.getSingleResult();
            return shift;
        }catch(Exception error){
            System.out.println("Erro: " + error);
        }
        return null;
    }    
    
    public Shift selectedShift(){
        EntityManager ema = getEm();
        TypedQuery<Shift> query = ema.createQuery("FROM tb_shifts s ORDER BY s.id DESC", Shift.class);
        query.setFirstResult(0);
        query.setMaxResults(1);
        return query.getSingleResult();
    }    
}
