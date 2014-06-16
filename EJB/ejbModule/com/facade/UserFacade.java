package com.facade;
 
import com.facade.template.CrudFacade;
import com.model.User;
 
public interface UserFacade extends CrudFacade<User,Integer,User>{
    
	User findUserByEmail(String email);
    
    /**
	 * Retorna o usuário validado ou <code>null</code> caso a validação tenha falhado.
	 */
	User validateUser(String username, String password);
	
}