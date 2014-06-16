package br.org.na.sistema.converter;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.facade.EventoFacade;
import com.model.Evento;
 
@FacesConverter(forClass = com.model.Evento.class)
public class EventoConverter implements Converter {
 
	@EJB
	private EventoFacade eventoFacade;
	
    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
        int id;
 
        try {
            id = Integer.parseInt(arg2);
        } catch (NumberFormatException exception) {
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Type the name of a Evento and select it (or use the dropdow)", "Type the name of a Evento and select it (or use the dropdow)"));
        }
 
        return eventoFacade.findById(id);
    }
 
    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
 
        if (arg2 == null) {
            return "";
        }
        Evento dog = (Evento) arg2;
        return String.valueOf(dog.getId());
    }
}