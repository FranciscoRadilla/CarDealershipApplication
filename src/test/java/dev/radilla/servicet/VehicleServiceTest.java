package dev.radilla.servicet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import dev.radilla.demo.DealershipApplication;
import dev.radilla.models.Vehicle;
import dev.radilla.repositories.VehicleRepository;
import dev.radilla.serviceimpl.VehicleServiceImpl;
/**
 * @author Francisco Radilla Greer
 * @version May 22, 2020
 * Does not work without @ContextConfiguration(classes = DealershipApplication.class)
 */
@SpringBootTest
@ContextConfiguration(classes = DealershipApplication.class)
public class VehicleServiceTest {

	@Autowired
	private VehicleServiceImpl vsi;
	
	@MockBean
	private VehicleRepository vr;

	@Test
	public void createVehicle() {
		Vehicle expected = new Vehicle();
		when(vr.save(expected)).thenReturn(expected);
		Vehicle actual = vsi.createVehicle(expected);
		assertEquals(expected, actual);
	}
	
	@Test
	public void getAllVehicles() {
		List<Vehicle> expected = new ArrayList<>();
		expected.add(new Vehicle(1, "c", "b", 1, 1, 1, "d", 20, 1, "sold"));
		expected.add(new Vehicle(2, "c", "b", 1, 1, 1, "d", 20, 1, "sold"));
		expected.add(new Vehicle(3, "c", "b", 1, 1, 1, "d", 20, 1, "avaliable"));
		expected.add(new Vehicle(4, "c", "b", 1, 1, 1, "d", 20, 1, "sold"));
		
		when(vr.findAll()).thenReturn(expected);
		assertEquals(4, vsi.allVehicle().size());
	}
	
	@Test
	public void getVehicleById() {
		Optional<Vehicle> expected = Optional.ofNullable(new Vehicle());
		when(vr.findById(1)).thenReturn(expected);
		Optional<Vehicle> actual = Optional.ofNullable(vsi.getVehicleById(1));
		assertEquals(expected, actual);
	}
	
	@Test
	public void updateVehicle() {
		Vehicle expected = new Vehicle();
		when(vr.save(expected)).thenReturn(expected);
		Vehicle actual = vsi.updateVehicle(expected);
		assertEquals(expected, actual);
	}
	
	@Test
	public void deleteVehicle() {
		Vehicle expected = new Vehicle();
		when(vr.save(expected)).thenReturn(expected);
		boolean actual = vsi.deleteVehicle(expected);
		assertTrue(actual);
	}
	
	//Custom CRUD methods
	@Test
	public void vehicleStatus() {
		List<Vehicle> expected = new ArrayList<>();
		expected.add(new Vehicle(1, "c", "b", 1, 1, 1, "d", 20, 1, "sold"));
		expected.add(new Vehicle(2, "c", "b", 1, 1, 1, "d", 20, 1, "sold"));
		expected.add(new Vehicle(4, "c", "b", 1, 1, 1, "d", 20, 1, "sold"));
		
		when(vr.findByStatus("sold")).thenReturn(expected);
		List<Vehicle> actual = vsi.vehiclesByStatus("sold");
		assertEquals(expected, actual);

	}

}
