package dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import java.util.List;


public abstract class GenericDAO <T extends PersistDB>{
	protected static EntityManager em;
	
	public EntityManager getEm(){
		if(em == null){
			em = DB.getInstance().getEntityManager();			
		}else if(!em.isOpen()){
			em = DB.getInstance().getEntityManager();
		}
		return em;
	}
	
	enum OperacaoDatabase{
		INSERIR, ALTERAR, REMOVER;
	}	
	

	private void change(T c, OperacaoDatabase op){
		EntityManager em = getEm();
		em.getTransaction().begin();
		switch(op){
			case INSERIR:
				em.persist(c);
				break;
			case ALTERAR:
				em.merge(c);
				break;
			case REMOVER:
				em.remove(c);
				break;
		}
		em.getTransaction().commit();
	}
	
	public void close(){}
	
	public void create(T c){
		change(c, OperacaoDatabase.INSERIR);
	}
	
	public void update(T c){
		change(c, OperacaoDatabase.ALTERAR);
	}
	
	public void delete(T c){
		change(c, OperacaoDatabase.REMOVER);
	}
	
	public T findByPK(int id){
		EntityManager em = getEm();
		T c = em.find(getClassType(), id);
		return c;
	}
	
	public abstract Class<T> getClassType();
	
	@SuppressWarnings("unchecked")
	public List<T> findAllLike(String collumn, String value){
		String table = getClassType().getSimpleName();
		String jpql = "from "+table+ " where "+collumn+" like :value";
		EntityManager em = getEm();
		Query q = em.createNativeQuery(jpql);
		q.setParameter("value", "%"+value+"%");
		List<T> fd = q.getResultList();
		return fd;
	}
	
    public List<T> findAll() {
        EntityManager em = getEm();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(getClassType());
        TypedQuery<T> typedQuery = em.createQuery(query.select(query.from(getClassType())));
        List<T> c = typedQuery.getResultList();
        return c;
    }	
	
}