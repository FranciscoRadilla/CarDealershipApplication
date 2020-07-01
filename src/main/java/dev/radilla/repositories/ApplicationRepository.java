package dev.radilla.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.radilla.models.Application;
import dev.radilla.models.User;

/** 
 * @author Francisco Radilla Greer, ciscoradilla@yahoo.com
 * @version May 22, 2020
 */
@Repository
public interface ApplicationRepository extends CrudRepository<Application, Integer> {
	
	List<Application> findByperson(User person);

}
