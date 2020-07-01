package dev.radilla.controllers;

import java.util.List;

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

import dev.radilla.models.Application;
import dev.radilla.models.User;
import dev.radilla.service.ApplicationService;

/** 
 * @author Francisco Radilla Greer, ciscoradilla@yahoo.com
 * @version May 22, 2020
 */
@RestController
@CrossOrigin
@SessionAttributes("appId")
public class ApplicationController {
	
	@Autowired
	ApplicationService as;
	
	@PostMapping(value="/app", consumes="application/json")
	public Application createApp(@RequestBody Application app) {
		return as.createApp(app);
	}
	
	@GetMapping(value="/app/{id}")
	public Application getAppById(@PathVariable("id") int id) {
		return as.getAppById(id);
	}
	
	@GetMapping(value="/app") 
	public List<Application> getAllApp() {
		return as.allApp();
	}
	
	@PutMapping(value="/app", consumes="application/json")
	public Application updateApp(@RequestBody Application change) {
		return as.updateApp(change);
	}
	
	@DeleteMapping(value="/app/{id}")
	public boolean deleteApp(@PathVariable("id") int id) {
		return as.deleteApp(as.getAppById(id));
	}
	
	//Custom methods
	/**
	 * Use the status of the car to provide a certain list. So a list where the user owns the car.
	 * A list where the car is not sold but they have an application for it and a list with boths.
	 * @param vis - The user we want the applications from.
	 * @param st - The status of the car 1 = available, 2 = sold, 3 = both.
	 * @return - Returns a list off applications depends on the status.
	 */
	@GetMapping(value="/app/user/{st}/{userid}")
	public List<Application> AppByUserAndStatus(@PathVariable("st") int st, @PathVariable("userid") int userId) {

		switch (st) {
			case 1:
				return as.appUserAndAval(userId);
			
			case 2:
				return as.appUserAndSold(userId);
				
			default:
				return as.appByPerson(userId);
		}
		
	}

}
