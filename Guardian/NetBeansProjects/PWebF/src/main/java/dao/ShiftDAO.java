package dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import model.Shift;

public class ShiftDAO extends GenericDAO<Shift>{

    @Override
    public Class<Shift> getClassType() {
        return Shift.class;
    }
    public Shift selectById(int id1){
        
        try{
            EntityManager gemg = getEm();
            Query query = gemg.createQuery("SELECT s FROM tb_shifts s WHERE s.id = :id");
            query.setParameter("id", id1);
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
