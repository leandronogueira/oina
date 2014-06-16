package br.org.na.sistema.mb;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.context.RequestContext;

import br.org.na.sistema.util.JSFMessageUtil;

public abstract class AbstractMB {
	private static final String KEEP_DIALOG_OPENED = "KEEP_DIALOG_OPENED";

	protected void displayWarnMessageToUser(String key, Object... params) {
		JSFMessageUtil.sendWarnMessageToUser(key, params);
	}
	
	protected void displayErrorMessageToUser(String key, Object... params) {
		JSFMessageUtil.sendErrorMessageToUser(key, params);
	}
	
	protected void displayInfoMessageToUser(String key, Object... params) {
		JSFMessageUtil.sendInfoMessageToUser(key, params);
	}
	
	protected String getMessage(String key, Object... params) {
		return JSFMessageUtil.getMessage(key, params);
	}
	
	protected void closeDialog(){
		getRequestContext().addCallbackParam(KEEP_DIALOG_OPENED, false);
	}
	
	protected void keepDialogOpen(){
		getRequestContext().addCallbackParam(KEEP_DIALOG_OPENED, true);
	}
	
	protected RequestContext getRequestContext(){
		return RequestContext.getCurrentInstance();
	}
	
	protected HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}
}