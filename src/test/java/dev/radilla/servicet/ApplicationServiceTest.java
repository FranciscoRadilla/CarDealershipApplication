package dev.radilla.servicet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//import org.junit.Test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import dev.radilla.demo.DealershipApplication;
import dev.radilla.models.Application;
import dev.radilla.models.User;
import dev.radilla.repositories.ApplicationRepository;
import dev.radilla.repositories.UserRepository;
import dev.radilla.service.ApplicationService;

/**
 * @author Francisco Radilla Greer
 * @version May 22, 2020
 * Does not work without @ContextConfiguration(classes = DealershipApplication.class)
 */
@SpringBootTest
@ContextConfiguration(classes = DealershipApplication.class)
public class ApplicationServiceTest {

	@Autowired
	private ApplicationService as;
	
	@MockBean
	private ApplicationRepository ar;
	
	@MockBean
	private UserRepository ur;

	@Test
	void createUser() {
		Application expected = new Application();
		when(ar.save(expected)).thenReturn(expected);
		Application actual = as.createApp(expected);
		assertEquals(expected, actual);
	}	
	
	@Test
	public void getAppById() {
		Optional<Application> expected = Optional.ofNullable(new Application());
		when(ar.findById(1)).thenReturn(expected);
		Optional<Application> actual = Optional.ofNullable(as.getAppById(1));
		assertEquals(expected, actual);
	}
	
	@Test
	public void getAllApp() {
		List<Application> list = new ArrayList<>();
		list.add(new Application());
		list.add(new Application());
		list.add(new Application());
		list.add(new Application());
		
		when(ar.findAll()).thenReturn(list);
		assertEquals(4, as.allApp().size());
	}
	
	@Test
	public void updateApp() {
		Application expected = new Application();
		when(ar.save(expected)).thenReturn(expected);
		Application actual = as.updateApp(expected);
		assertEquals(expected, actual);
	}
	
	@Test
	public void deleteApp() {
		Application expected = new Application();
		when(ar.save(expected)).thenReturn(expected);
		boolean actual = as.deleteApp(expected);
		assertTrue(actual);
	}
	
	//Custom CRUD methods 
	@Test
	public void appByPerson() {
		List<Application> list = new ArrayList<>();
		list.add(new Application());
		list.add(new Application());
		list.add(new Application());
		list.add(new Application());
		
		User hold = new User();
		
		when(ar.findByperson(hold)).thenReturn(list);
		assertEquals(4, as.appByPerson(1).size());
	}

}
