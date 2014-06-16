package com.dao;
 
import java.util.HashMap;
import java.util.Map;
 
import javax.ejb.Stateless;
 
import com.model.User;
 
@Stateless
public class UserDAO extends GenericDAO<User, Integer> {
 
    public UserDAO() {
        super(User.class);
    }
 
    public User findByUsernameAndPassword(String username, String password){
    	Map<String, Object> parameters = new HashMap<String, Object>();
    	parameters.put("username", username);    
    	parameters.put("password", password);    
    	
    	return super.findOneResult(User.FIND_BY_USERNAME_AND_PASSWORD, parameters);
    }
    
    public User findByEmail(String email){
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("email", email);    
 
        return super.findOneResult(User.FIND_BY_EMAIL, parameters);
    }
}