package com.facade.template;

import java.util.List;

import com.model.template.AbstractModel;


public interface CrudFacade<ENTITY extends AbstractModel<ID>, ID, FILTER> {
	
	void save(ENTITY entity);
	 
	ENTITY update(ENTITY entity);
 
    void delete(ENTITY entity);
 
    ENTITY findById(ID entityID);
 
    List<ENTITY> search(FILTER filter);
}
