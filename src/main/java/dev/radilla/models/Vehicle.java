package dev.radilla.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Francisco Radilla Greer
 * @version May 22, 2020
 */
@Entity
@Table(name="vehicle")
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="carid")
	private int carId;
	private String company;
	private String brand;
	private int year;
	@Column(name="mpgcity")
	private double mpgCity;
	@Column(name="mpghwy")
	private double mpgHWY;
	private String description;
	private double price;
	private int seats;
	private String status;
	
	public Vehicle() {
		super();
	}

	public Vehicle(String company, String brand, int year, double mpgCity, double mpgHWY, String description,
			double price, int seats, String status) {
		super();
		this.company = company;
		this.brand = brand;
		this.year = year;
		this.mpgCity = mpgCity;
		this.mpgHWY = mpgHWY;
		this.description = description;
		this.price = price;
		this.seats = seats;
		this.status = status;
	}

	public Vehicle(int carId, String company, String brand, int year, double mpgCity, double mpgHWY, String description,
			double price, int seats, String status) {
		super();
		this.carId = carId;
		this.company = company;
		this.brand = brand;
		this.year = year;
		this.mpgCity = mpgCity;
		this.mpgHWY = mpgHWY;
		this.description = description;
		this.price = price;
		this.seats = seats;
		this.status = status;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getMpgCity() {
		return mpgCity;
	}

	public void setMpgCity(double mpgCity) {
		this.mpgCity = mpgCity;
	}

	public double getMpgHWY() {
		return mpgHWY;
	}

	public void setMpgHWY(double mpgHWY) {
		this.mpgHWY = mpgHWY;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + carId;
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		long temp;
		temp = Double.doubleToLongBits(mpgCity);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(mpgHWY);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + seats;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (carId != other.carId)
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (Double.doubleToLongBits(mpgCity) != Double.doubleToLongBits(other.mpgCity))
			return false;
		if (Double.doubleToLongBits(mpgHWY) != Double.doubleToLongBits(other.mpgHWY))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (seats != other.seats)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vehicle [carId=" + carId + ", company=" + company + ", brand=" + brand + ", year=" + year + ", mpgCity="
				+ mpgCity + ", mpgHWY=" + mpgHWY + ", description=" + description + ", price=" + price + ", seats="
				+ seats + ", status=" + status + "]";
	}

}
