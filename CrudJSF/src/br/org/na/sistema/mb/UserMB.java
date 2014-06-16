package br.org.na.sistema.mb;

import java.io.Serializable;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.model.Role;
import com.model.User;

@SessionScoped
@ManagedBean(name="userMB")
public class UserMB extends AbstractMB implements Serializable {
	
	public static final String INJECTION_NAME = "#{userMB}";
	private static final long serialVersionUID = 1L;
	private Locale locale;
	private User user;
	private String logomarca = "logo-na-pt.png";

	@PostConstruct
	public void chooseLocale() {
		locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
		switchLocale(locale.getLanguage(), locale.getCountry());
	}
	
	public boolean isAdmin() {
		return getRequest().isUserInRole(Role.ADMIN.name());
	}

	public boolean isDefaultUser() {
		return getRequest().isUserInRole(Role.USER.name());
	}

	public String logOut() {
		getRequest().getSession().invalidate();
		return "/pages/login.xhtml";
	}
	
	public Locale getLocale() {
		return locale;
	}
	
    public String switchLocale(String lang, String country) {
        locale = new Locale(lang, country);
        if("en".equals(lang)) {
        	logomarca = "logo-na-us.png";
        } else if("pt".equals(lang)) {
        	logomarca = "logo-na-pt.png";
        }
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
        return FacesContext.getCurrentInstance().getViewRoot().getViewId() + "?faces-redirect=true";
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getLogomarca() {
		return logomarca;
	}
}