package com.model;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.model.template.AbstractModel;
 
@Entity
@Table(name = "users")
@NamedQueries(value = {
	@NamedQuery(name=User.FIND_BY_EMAIL, query="select u from User u where u.email = :email"),
	@NamedQuery(name=User.FIND_BY_USERNAME_AND_PASSWORD, query="select u from User u where u.username = :username and u.password = :password")
})
public class User extends AbstractModel<Integer> {
 
	public static final String FIND_BY_USERNAME_AND_PASSWORD = "User.findByUsernameAndPassword";
    public static final String FIND_BY_EMAIL = "User.findByEmail";
 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
 
    @Column(unique = true, nullable = false, length=60)
    @Email(message="{email.invalid-format}")
    @NotEmpty(message="{required}")
    private String email;
    
    @Column(nullable = false, length=64)
    @NotEmpty(message="{required}")
    private String password;
    
    @Column(nullable = false, length=100)
    @NotEmpty(message="{required}")
    private String name;
    
    @Column(unique = true, nullable = false, length=25)
    @NotEmpty(message="{required}")
    private String username;
    
    @Column(nullable = false, length=15)
    @Enumerated(EnumType.STRING)
    private Role role;
    
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public Role getRole() {
        return role;
    }
 
    public void setRole(Role role) {
        this.role = role;
    }
 
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}