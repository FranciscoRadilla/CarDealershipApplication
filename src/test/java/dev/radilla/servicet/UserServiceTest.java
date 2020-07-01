package dev.radilla.servicet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import dev.radilla.demo.DealershipApplication;
import dev.radilla.models.User;
import dev.radilla.repositories.UserRepository;
import dev.radilla.service.UserService;

/**
 * @author Francisco Radilla Greer
 * @version May 22, 2020
 * Does not work without @ContextConfiguration(classes = DealershipApplication.class)
 */
@SpringBootTest
@ContextConfiguration(classes = DealershipApplication.class)
public class UserServiceTest {
	
	@Autowired
	private UserService us;
	
	@MockBean
	private UserRepository ur;

	@Test
	void createUser() {
		User expected = new User();
		when(ur.save(expected)).thenReturn(expected);
		User actual = us.createUser(expected);
		assertEquals(expected, actual);
	}	
	
	@Test
	public void getUserById() {
		Optional<User> expected = Optional.ofNullable(new User());
		when(ur.findById(1)).thenReturn(expected);
		Optional<User> actual = Optional.ofNullable(us.getUserById(1));
		assertEquals(expected, actual);
	}
	
	@Test
	public void getAllUser() {
		List<User> users = new ArrayList<>();
		users.add(new User());
		users.add(new User());
		users.add(new User());
		users.add(new User());
		
		when(ur.findAll()).thenReturn(users);
		assertEquals(4, us.allUsers().size());
	}
	
	@Test
	public void updateUser() {
		User expected = new User();
		when(ur.save(expected)).thenReturn(expected);
		User actual = us.updateUser(expected);
		assertEquals(expected, actual);
	}
	
	@Test
	public void deleteUser() {
		User expected = new User();
		when(ur.save(expected)).thenReturn(expected);	
		boolean actual = us.deleteUser(expected);
		assertTrue(actual);
	}
	
	//Custom CRUD method
	@Test
	public void getUserByUserName() {		
		User expected = new User(1, "junit", "test", "pickMe", "pass", 0, "x)", "email");
		when(ur.findByuserName("pickMe")).thenReturn(expected);
		User actual = us.getUserByUserName("pickMe");
		assertEquals(expected, actual);
	}
	
	//Custom methods
	@Test
	public void logIn() {
		User expected = new User(1, "junit", "test", "pickMe", "pass", 0, "x)", "email");
		when(ur.findByuserName("pickMe")).thenReturn(expected);
		
		//Testing if the person exists
		User actual = us.logIn("DoesNotExist", "");
		assertEquals("Person does not exist", actual.getFirstName());
		
		//Testing if the password matches
		actual = us.logIn("pickMe", "wrong");
		assertEquals("Password does not match", actual.getFirstName());
		
		//Testing if log in was successful
		actual = us.logIn("pickMe", "pass");
		assertEquals(expected, actual);
	}

}
