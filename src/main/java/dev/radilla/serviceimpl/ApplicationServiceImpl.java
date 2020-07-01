package dev.radilla.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.radilla.models.Application;
import dev.radilla.models.User;
import dev.radilla.repositories.ApplicationRepository;
import dev.radilla.service.ApplicationService;
import dev.radilla.service.UserService;

/** 
 * @author Francisco Radilla Greer, ciscoradilla@yahoo.com
 * @version May 22, 2020
 */
@Service
public class ApplicationServiceImpl implements ApplicationService {
	
	@Autowired
	ApplicationRepository ar;
	
	@Autowired
	UserService us;

	@Override
	public Application createApp(Application app) {
		return ar.save(app);
	}

	@Override
	public Application getAppById(int id) {
		return ar.findById(id).get();
	}

	@Override
	public List<Application> allApp() {
		return (List<Application>) ar.findAll();
	}

	@Override
	public Application updateApp(Application update) {
		return ar.save(update);
	}

	@Override
	public boolean deleteApp(Application delete) {
		
		try {
			ar.delete(delete);
			return true;
		} catch(IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
	}

	//Custom CRUD methods
	@Override
	public List<Application> appByPerson(int userId) {
		User person = us.getUserById(userId);
		return ar.findByperson(person);
	}

	//Custom methods
	@Override
	public List<Application> appUserAndSold(int userId) {
		User person = us.getUserById(userId);
		List<Application> hold = ar.findByperson(person);
		List<Application> temp = new ArrayList<Application>();
		
		for(Application i : hold) {
			if(i.getCar().getStatus().equals("sold")) 
				temp.add(i);
		}
		
		return temp;
	}

	@Override
	public List<Application> appUserAndAval(int userId) {
		User person = us.getUserById(userId);
		List<Application> hold = ar.findByperson(person);
		List<Application> temp = new ArrayList<Application>();
		
		for(Application i : hold) {
			if(i.getCar().getStatus().equals("avaliable")) 
				temp.add(i);
		}
		
		return temp;
	}

}
