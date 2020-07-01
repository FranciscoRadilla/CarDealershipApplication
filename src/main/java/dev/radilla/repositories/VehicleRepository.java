package dev.radilla.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.radilla.models.Vehicle;

/** 
 * @author Francisco Radilla Greer, ciscoradilla@yahoo.com
 * @version May 22, 2020
 */
@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {
	
	List<Vehicle> findByStatus(String status);

}
