
package dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import model.Day;
import util.GenericDAO;

public class DayDAO extends GenericDAO<Day>{

    @Override
    public Class<Day> getClassType() {
        return Day.class;
    }

    public Day selectById(int id1){
        
        try{
            EntityManager emn = getEm();
            Query query = emn.createQuery("SELECT d FROM tb_days d WHERE d.id = :id");
            query.setParameter("id", id1);
            Day day = (Day) query.getSingleResult();
            return day;
        }catch(Exception error){
            System.out.println("Erro: " + error);
        }
        return null;
    }

    public Day searchByName(String name){
        
        try{
            EntityManager enti = getEm();
            Query query = enti.createQuery("SELECT d FROM tb_days d WHERE d.name = :na");
            query.setParameter("na", name);
            Day day = (Day) query.getSingleResult();
            return day;
        }catch(Exception error){
            System.out.println("Erro: " + error);
        }
        return null;
    }   
    
    public Day selectedDay(){
        EntityManager ema = getEm();
        TypedQuery<Day> query = ema.createQuery("FROM tb_days d ORDER BY d.id DESC", Day.class);
        query.setFirstResult(0);
        query.setMaxResults(1);
        return query.getSingleResult();
    }    
}
