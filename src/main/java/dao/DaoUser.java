package dao;

import java.util.List;

import model.User;

public interface DaoUser extends DAO<User>{
	
	List<User> searchAll();
	User authenticateUser(String email, String password);
	                                      
}
