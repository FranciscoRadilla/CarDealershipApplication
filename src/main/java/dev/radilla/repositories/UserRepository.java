package dev.radilla.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.radilla.models.User;

/** 
 * @author Francisco Radilla Greer, ciscoradilla@yahoo.com
 * @version May 22, 2020
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	User findByuserName(String userName);
	
}
