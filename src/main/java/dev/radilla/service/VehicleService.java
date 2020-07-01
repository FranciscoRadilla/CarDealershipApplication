package dev.radilla.service;

import java.util.List;

import dev.radilla.models.Vehicle;

/** 
 * @author Francisco Radilla Greer, ciscoradilla@yahoo.com
 * @version May 22, 2020
 */
public interface VehicleService {
	
	public Vehicle createVehicle(Vehicle car);
	public Vehicle getVehicleById(int id);
	public List<Vehicle> allVehicle();
	public Vehicle updateVehicle(Vehicle change);
	public boolean deleteVehicle(Vehicle delete);
	
	//Custom CRUD methods
	public List<Vehicle> vehiclesByStatus(String status);
	
}
