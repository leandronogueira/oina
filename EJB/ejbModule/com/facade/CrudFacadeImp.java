package com.facade;

import com.dao.GenericDAO;
import com.facade.template.CrudFacade;
import com.model.template.AbstractModel;

public abstract class CrudFacadeImp<ENTITY extends AbstractModel<ID>, ID, FILTER, DAO extends GenericDAO<ENTITY, ID>>
																					implements CrudFacade<ENTITY, ID, FILTER> {

	private DAO dao;
	
	public void save(ENTITY entity) {
		dao.save(entity);
    }
	
	public void delete(ENTITY entity) {
		dao.delete(entity.getId());
    }
	
	public ENTITY findById(ID id) {
        return dao.find(id);
    }
	
	protected void setDAO(DAO dao) {
		this.dao = dao;
	}
	
	/**
	 * Anote este método com @PostConstruct e inicialize o dao pelo método {@link #setDAO(GenericDAO)}
	 */
	public abstract void initDAO();
 
}
