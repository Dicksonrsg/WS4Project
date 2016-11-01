
package dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Soldier;


public class SoldierDAO extends GenericDAO<Soldier>{

    @Override
    public Class<Soldier> getClassType() {
        return Soldier.class;
    }
   
    public Soldier login(String user, String pw){
        try{
            EntityManager gemg = getEm();
            Query query = gemg.createQuery("SELECT s FROM tb_soldiers s WHERE s.user = :user AND s.password = :pass");
            query.setParameter("user", user);
            query.setParameter("pass", pw);
            Soldier soldier = (Soldier) query.getSingleResult();
            return soldier;
        }catch(Exception error){
            System.out.println("Erro: " + error);
        }
        return null;
    }    
}
