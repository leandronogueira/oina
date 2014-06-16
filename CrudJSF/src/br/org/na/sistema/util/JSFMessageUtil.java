package br.org.na.sistema.util;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class JSFMessageUtil {
	
	private static final String BUNDLE_NAME = "messages";
    
	public static void sendInfoMessageToUser(String key, Object... params) {
		FacesMessage facesMessage = createMessage(FacesMessage.SEVERITY_INFO, getMessage(key, params));
		addMessageToJsfContext(facesMessage);
	}

	public static void sendErrorMessageToUser(String key, Object... params) {
		FacesMessage facesMessage = createMessage(FacesMessage.SEVERITY_ERROR, getMessage(key, params));
		addMessageToJsfContext(facesMessage);
	}
	
	public static void sendWarnMessageToUser(String key, Object... params) {
		FacesMessage facesMessage = createMessage(FacesMessage.SEVERITY_WARN, getMessage(key, params));
		addMessageToJsfContext(facesMessage);
	}

	private static FacesMessage createMessage(Severity severity, String message) {
		return new FacesMessage(severity, message, message);
	}

	private static void addMessageToJsfContext(FacesMessage facesMessage) {
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}
	
	public static String getMessage(String key, Object... params) {
		ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_NAME, getFacesContext().getViewRoot().getLocale());
		if (params != null && params.length > 0) {
			return MessageFormat.format(bundle.getString(key), params);
		} else {
			return bundle.getString(key);
		}
	}
	
	private static FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}
}