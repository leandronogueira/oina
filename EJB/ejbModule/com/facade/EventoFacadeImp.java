package com.facade;
 
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import com.dao.EventoDAO;
import com.filter.EventoFilter;
import com.model.Evento;
 
@Stateless
@Local(value=EventoFacade.class)
public class EventoFacadeImp extends CrudFacadeImp<Evento, Integer, EventoFilter, EventoDAO> implements EventoFacade {
 
    @EJB
    private EventoDAO eventoDAO;
 
    @Override
    public Evento update(Evento transientEvento) {
        
        Evento persistentEvento = eventoDAO.find(transientEvento.getId());
        persistentEvento.setNome(transientEvento.getNome());
        persistentEvento.setDescricao(transientEvento.getDescricao());
        persistentEvento.setData(transientEvento.getData());
        
        return eventoDAO.update(persistentEvento);
    }
 
	@Override
	public List<Evento> search(EventoFilter filter) {
		return eventoDAO.findByFilter(filter);
	}

	@PostConstruct
	public void initDAO() {
		setDAO(eventoDAO);
	}
}