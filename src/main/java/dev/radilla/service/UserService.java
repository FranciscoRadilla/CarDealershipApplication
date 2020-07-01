package dev.radilla.service;

import java.util.List;

import dev.radilla.models.User;

/** 
 * @author Francisco Radilla Greer, ciscoradilla@yahoo.com
 * @version May 22, 2020
 */
public interface UserService {
	
	public User createUser(User person);
	public User getUserById(int id);
	public List<User> allUsers();
	public User updateUser(User update);
	public boolean deleteUser(User delete);
	
	//Custom CRUD method
	public User getUserByUserName(String userName);
	
	//Custom methods
	public User logIn(String userName, String password);

}
