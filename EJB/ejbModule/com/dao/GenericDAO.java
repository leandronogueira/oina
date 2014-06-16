package com.dao;
 
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
 
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import com.model.template.AbstractModel;
 
public abstract class GenericDAO<T extends AbstractModel<ID>, ID> {
    private final static String UNIT_NAME = "CrudPU";
 
    @PersistenceContext(unitName = UNIT_NAME)
    private EntityManager em;
 
    private Class<T> entityClass;
 
    public GenericDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
 
    public void save(T entity) {
        em.persist(entity);
    }
 
    public void delete(ID id) {
        T entityToBeRemoved = em.getReference(entityClass, id);
 
        em.remove(entityToBeRemoved);
    }
 
    public T update(T entity) {
        return em.merge(entity);
    }
 
    public T find(ID entityID) {
        return em.find(entityClass, entityID);
    }
 
    // Using the unchecked because JPA does not have a
    // em.getCriteriaBuilder().createQuery()<T> method
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<T> findAll() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return em.createQuery(cq).getResultList();
    }
 
    // Using the unchecked because JPA does not have a
    // ery.getSingleResult()<T> method
    @SuppressWarnings("unchecked")
    protected T findOneResult(String namedQuery, Map<String, Object> parameters) {
        T result = null;
 
        try {
            Query query = em.createNamedQuery(namedQuery);
 
            if (parameters != null && !parameters.isEmpty()) {
                populateQueryParameters(query, parameters);
            }
 
            result = (T) query.getSingleResult();
 
        } catch (NoResultException e) {
        	return null;
        } catch (Exception e) {
            System.out.println("Error while running query: " + e.getMessage());
            e.printStackTrace();
        }
 
        return result;
    }
 
    private void populateQueryParameters(Query query, Map<String, Object> parameters) {
 
        for (Entry<String, Object> entry : parameters.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
    }

	protected EntityManager getEntityManager() {
		return em;
	}

	protected Class<T> getEntityClass() {
		return entityClass;
	}
}