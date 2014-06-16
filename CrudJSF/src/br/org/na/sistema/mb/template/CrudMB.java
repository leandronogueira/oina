package br.org.na.sistema.mb.template;

import java.util.List;

import br.org.na.sistema.mb.AbstractMB;

import com.facade.template.CrudFacade;
import com.model.template.AbstractModel;

public abstract class CrudMB<ENTITY extends AbstractModel<ID>,ID,FILTER,FACADE extends CrudFacade<ENTITY,ID,FILTER>>
																			   extends AbstractMB {
	
	private FACADE facade;
	private ENTITY entity;
	private FILTER filter;
	private List<ENTITY> list;
	
	private Class<ENTITY> entityClass;
	private Class<FILTER> filterClass;
	 
	public CrudMB(Class<ENTITY> entityClass, Class<FILTER> filterClass) {
		this.entityClass = entityClass;
		this.filterClass = filterClass;
	}
	
	public ENTITY getEntity() throws InstantiationException, IllegalAccessException {
		return entity == null ? entity = entityClass.newInstance() : entity;
	}

	public void setEntity(ENTITY entity) {
		this.entity = entity;
	}
	
	public void create() {
		try {
			facade.save(getEntity());
			closeDialog();
			displayInfoMessageToUser("createdSuccess");
			search();
			resetEntity();
		} catch (Exception e) {
			keepDialogOpen();
			displayErrorMessageToUser("createdFail");
			e.printStackTrace();
		}
	}
	
	public void update() {
		try {
			facade.update(getEntity());
			closeDialog();
			displayInfoMessageToUser("updatedSuccess");
			search();
			resetEntity();
		} catch (Exception e) {
			keepDialogOpen();
			displayErrorMessageToUser("updatedFail");
			e.printStackTrace();
		}
	}
	
	public void delete() {
		try {
			facade.delete(getEntity());
			closeDialog();
			displayInfoMessageToUser("deletedSuccess");
			search();
			resetEntity();
		} catch (Exception e) {
			keepDialogOpen();
			displayErrorMessageToUser("deletedFail");
			e.printStackTrace();
		}
	}

	public void resetEntity() throws InstantiationException, IllegalAccessException {
		setEntity(entityClass.newInstance());
	}

	public List<ENTITY> getList() {
		return list;
	}

	public void search() {
		list = facade.search(filter);
	}

	public FILTER getFilter() throws InstantiationException, IllegalAccessException {
		return filter == null ? filter = filterClass.newInstance() : filter;
	}

	public FACADE getFacade() {
		return facade;
	}

	public void setFilter(FILTER filter) {
		this.filter = filter;
	}

	public void setList(List<ENTITY> list) {
		this.list = list;
	}

	protected void setFacade(FACADE facade) {
		this.facade = facade;
	}
	
	/**
	 * Anote este método com @PostConstruct e inicialize o facade pelo método {@link #setFacade(CrudFacade)}
	 */
	protected abstract void initFacade();

}
