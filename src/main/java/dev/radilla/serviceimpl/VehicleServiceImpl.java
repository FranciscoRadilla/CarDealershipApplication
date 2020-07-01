package dev.radilla.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.radilla.models.Vehicle;
import dev.radilla.repositories.VehicleRepository;
import dev.radilla.service.VehicleService;

/** 
 * @author Francisco Radilla Greer, ciscoradilla@yahoo.com
 * @version May 22, 2020
 */
@Service
public class VehicleServiceImpl implements VehicleService {
	
	@Autowired
	VehicleRepository vr;

	@Override
	public Vehicle createVehicle(Vehicle car) {
		return vr.save(car);
	}

	@Override
	public Vehicle getVehicleById(int id) {
		return vr.findById(id).get();
	}

	@Override
	public List<Vehicle> allVehicle() {
		return (List<Vehicle>) vr.findAll();
	}

	@Override
	public Vehicle updateVehicle(Vehicle change) {
		return vr.save(change);
	}

	@Override
	public boolean deleteVehicle(Vehicle delete) {
		
		try {
			vr.delete(delete);
			return true;
		} catch(IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	//Custom CRUD method
	@Override
	public List<Vehicle> vehiclesByStatus(String status) {
		return vr.findByStatus(status);
	}

}
