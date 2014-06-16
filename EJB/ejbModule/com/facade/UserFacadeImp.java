package com.facade;
 
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.dao.UserDAO;
import com.model.User;
 
@Stateless
@Local(UserFacade.class)
public class UserFacadeImp extends CrudFacadeImp<User, Integer, User, UserDAO> implements UserFacade {
 
    @EJB
    private UserDAO userDAO;
    
    @Override
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public User findUserByEmail(String email) {
        return userDAO.findByEmail(email);
    }

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public User validateUser(String username, String password) {
		return userDAO.findByUsernameAndPassword(username, encryptPassword(password));
	}
	
	@Override
	public User update(User transientUser) {
        
        User persistentUser = userDAO.find(transientUser.getId());
        persistentUser.setName(transientUser.getName());
        persistentUser.setEmail(transientUser.getEmail());
        persistentUser.setPassword(encryptPassword(transientUser.getPassword()));
        
        return userDAO.update(persistentUser);
	}

	@Override
	public List<User> search(User filter) {
//		TODO return userDAO.findByFilter(filter);
		return null;
	}
	
	private String encryptPassword(String password) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		md.update(password.getBytes());
		
		StringBuffer result = new StringBuffer();
		byte[] bytes = md.digest();
		for (byte byt : bytes) {
			result.append(Integer.toString((byt & 0xff) + 0x100, 16).substring(1));
		}
		return result.toString();
		
		/*
		BigInteger hash = new BigInteger(1, md.digest());
		String encryptedPassword = hash.toString(16);
		
		while (encryptedPassword.length() < 32) { // 40 for SHA -1
			encryptedPassword = "0" + encryptedPassword;
		}
		return encryptedPassword;
		 */
	}

	@Override
	@PostConstruct
	public void initDAO() {
		setDAO(userDAO);
	}

}