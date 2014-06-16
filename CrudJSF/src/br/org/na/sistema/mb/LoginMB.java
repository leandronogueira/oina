package br.org.na.sistema.mb;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.servlet.ServletException;

import com.facade.UserFacade;
import com.model.User;

@RequestScoped
@ManagedBean
public class LoginMB extends AbstractMB {
	
	@ManagedProperty(value = UserMB.INJECTION_NAME)
	private UserMB userMB;
	
	@EJB
	private UserFacade userFacade;
	
//	@EJB(name="correiosWS")
//	private CorreiosClientWS correiosWS;
	
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String login() throws ServletException {
		/*
		Frete frete = correiosWS.calculaFrete();
		List<ServicoInstance> servicos = frete.getServicos();
		for (ServicoInstance instance : servicos) {
			instance.getValor();
			instance.getPrazoEntrega();
		}
		*/
		User user = userFacade.validateUser(getUsername(), getPassword());
		
		if (user == null) {
			displayWarnMessageToUser("login.validation");
			return null;
		}
		
		getRequest().login(user.getUsername(), user.getPassword());
		userMB.setUser(user);
		return "/pages/home.xhtml";
	}

	public void setUserMB(UserMB userMB) {
		this.userMB = userMB;
	}	
}