package dev.radilla.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.radilla.models.User;
import dev.radilla.repositories.UserRepository;
import dev.radilla.service.UserService;

/** 
 * @author Francisco Radilla Greer, ciscoradilla@yahoo.com
 * @version May 22, 2020
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository ur;

	@Override
	public User createUser(User person) {
		return ur.save(person);
	}

	@Override
	public User getUserById(int id) {
		return ur.findById(id).get();
	}

	@Override
	public List<User> allUsers() {
		return (List<User>) ur.findAll();
	}

	@Override
	public User updateUser(User update) {
		return ur.save(update);
	}

	@Override
	public boolean deleteUser(User delete) {
		try {
			ur.delete(delete);
			return true;
		} catch(IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
	}

	
	//Custom CRUD methods
	
	@Override
	public User getUserByUserName(String userName) {
		return ur.findByuserName(userName);
	}
	
	//Custom methods
	/**
	 * Log in method. This method will check if the person exist. If that person exist check to make sure
	 * they typed in the right password. 
	 * @param userName - User name that the person typed.
	 * @param password - Password that the person typed.
	 * @return - If successful return a visitor object if not return a empty visitor object
	 */
	@Override
	public User logIn(String userName, String password) {
		
		User person = getUserByUserName(userName);
		
		if(person == null) {
			User hold = new User();
			hold.setFirstName("Person does not exist");
			return hold;
		}
		
		if (!person.getPassword().equals(password)) {
			User hold = new User();
			hold.setFirstName("Password does not match");
			return hold;
		}
		
		return person;
	}


}
