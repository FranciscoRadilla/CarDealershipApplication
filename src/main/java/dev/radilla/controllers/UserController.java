package dev.radilla.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import dev.radilla.models.User;
import dev.radilla.service.UserService;

/** 
 * @author Francisco Radilla Greer, ciscoradilla@yahoo.com
 * @version May 22, 2020
 */
@RestController
@CrossOrigin
@SessionAttributes("userId")
public class UserController {
	
	@Autowired
	UserService us;
	
	@PostMapping(value="/user", consumes="application/json")
	public User createUser(@Valid @RequestBody User person) {
		return us.createUser(person);
	}
	
	@GetMapping(value="/user/{id}")
	public User getUserById(@PathVariable("id") int id) {
		return us.getUserById(id);
	}
	
	@GetMapping(value="/user")
	public List<User> allUsers() {
		return us.allUsers();
	}
	
	@PutMapping(value="/user", consumes="application/json")
	public User updateUser(@RequestBody User update) {
		return us.updateUser(update);
	}
	
	@DeleteMapping(value="/user/{id}")
	public boolean deleteUser(@PathVariable("id") int id) {
		return us.deleteUser(us.getUserById(id));
	}
	
	//Custom methods
	@GetMapping(value="/user/{userName}/{password}")
	public User logIn(@PathVariable("userName") String userName, @PathVariable("password") String password) {
		return us.logIn(userName, password);
	}

}
