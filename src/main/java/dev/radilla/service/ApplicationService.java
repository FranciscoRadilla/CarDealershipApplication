package dev.radilla.service;

import java.util.List;

import dev.radilla.models.Application;
import dev.radilla.models.User;

/** 
 * @author Francisco Radilla Greer, ciscoradilla@yahoo.com
 * @version May 22, 2020
 */
public interface ApplicationService {
	
	public Application createApp(Application app);
	public Application getAppById(int id);
	public List<Application> allApp();
	public Application updateApp(Application update);
	public boolean deleteApp(Application delete);
	
	//Custom CRUD methods
	public List<Application> appByPerson(int userId);
	
	//Custom methods
	public List<Application> appUserAndSold(int userId);
	public List<Application> appUserAndAval(int userId);

}
