package br.org.na.sistema.mb;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.org.na.sistema.mb.template.CrudMB;
import br.org.na.sistema.util.JSFMessageUtil;

import com.facade.EventoFacade;
import com.filter.EventoFilter;
import com.model.Evento;

@ViewScoped
@ManagedBean
public class EventoMB extends CrudMB<Evento,Integer,EventoFilter,EventoFacade> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value = UserMB.INJECTION_NAME)
	private UserMB userMB;
	
	@EJB
	private EventoFacade eventoFacade;
	
	public EventoMB() {
		super(Evento.class, EventoFilter.class);
	}

	@PostConstruct
	public void initFacade() {
		setFacade(eventoFacade);
	}
	
	@Override
	public void create() {
		if (userMB.isAdmin()) {
			super.create();
		} else {
			keepDialogOpen();
			displayErrorMessageToUser("permissionDenied",JSFMessageUtil.getMessage("create"));
		}
	}
	
	@Override
	public void delete() {
		if (userMB.isAdmin()) {
			super.delete();
		} else {
			keepDialogOpen();
			displayErrorMessageToUser("permissionDenied",JSFMessageUtil.getMessage("delete"));
		}
	}
	
	@Override
	public void update() {
		if (userMB.isAdmin()) {
			super.update();
		} else {
			keepDialogOpen();
			displayErrorMessageToUser("permissionDenied",JSFMessageUtil.getMessage("update"));
		}
	}
	
	public void setUserMB(UserMB userMB) {
		this.userMB = userMB;
	}

}