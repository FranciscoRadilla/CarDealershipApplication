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

import dev.radilla.models.Vehicle;
import dev.radilla.service.VehicleService;

/** 
 * @author Francisco Radilla Greer, ciscoradilla@yahoo.com
 * @version May 22, 2020
 */
@RestController
@CrossOrigin
@SessionAttributes("carId")
public class VehicleController {

	@Autowired
	VehicleService vs;
	
	@PostMapping(value="/car", consumes="application/json")
	public Vehicle createCar(@RequestBody Vehicle car) {
		return vs.createVehicle(car);
	}
	
	@GetMapping(value="/car/{id}")
	public Vehicle getCarById(@PathVariable("id") int id) {
		return vs.getVehicleById(id);
	}
	
	@GetMapping(value="/car")
	public List<Vehicle> getAllCars() {
		return vs.allVehicle();
	}
	
	@PutMapping(value="/car", consumes="application/json")
	public Vehicle updateUser(@RequestBody Vehicle change) { 
		return vs.updateVehicle(change);
	}
	
	@DeleteMapping(value="/car/{id}")
	public boolean deleteCar(@PathVariable("id") int id) {
		return vs.deleteVehicle(vs.getVehicleById(id));
	}
	
	//Custom methods
	@GetMapping(value="/car/status/{status}")
	public List<Vehicle> getCarsByStatus(@PathVariable("status") String status) {
		return vs.vehiclesByStatus(status);
	}
	
}
