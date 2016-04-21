package Models;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.avaje.ebean.Model;


@Entity
public class User extends Model{
	
	private static final long serialVersionUID = 1L;

	@Id	
	public Integer id;	
	
    public String name; 
    public String lastName;
    public int age;

    
    public User(){}
    
    
    public User(String name) {
    	this.name = name;
    }
    
    public User(String name, String lastName){
    	this.name = name;
    	this.lastName = lastName;
    }
    
    	
    
}
