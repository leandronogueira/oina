package com.facade;

import com.facade.template.CrudFacade;
import com.filter.EventoFilter;
import com.model.Evento;

public interface EventoFacade extends CrudFacade<Evento, Integer, EventoFilter> {

}
