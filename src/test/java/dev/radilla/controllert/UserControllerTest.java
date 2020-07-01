package dev.radilla.controllert;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import static org.hamcrest.Matchers.hasSize;

import dev.radilla.controllers.UserController;
import dev.radilla.demo.DealershipApplication;
import dev.radilla.models.User;
import dev.radilla.service.UserService;

/**
 * @author Francisco Radilla Greer
 * @version May 28, 2020
 */
@SpringBootTest
@ContextConfiguration(classes = DealershipApplication.class)
@WebAppConfiguration
class UserControllerTest {
	
	@Autowired
	private UserService us;
	
	@InjectMocks
	private UserController uc;
	
	private MockMvc mockMvc;
	
	@BeforeAll
	void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(uc).build();
	}
	
	@Test
	void getUsers() {
		List<User> expected = new ArrayList<>();
		expected.add(new User());
		expected.add(new User());
		expected.add(new User());
		
		when(us.allUsers()).thenReturn(expected);
		
		try {
			mockMvc.perform(get("/user"))
				   .andExpect(status().isOk())
				   .andExpect(view().name("user"))
				   .andExpect(model().attribute("expected", hasSize(2)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
