package dev.radilla.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * @author Francisco Radilla Greer
 * @version May 22, 2020
 */
@Entity
@Table(name="application")
public class Application {

	@Id
	@Column(name="appid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int appId;
	@Column(name="offer")
	private double offer;
	@Column(name="month")
	private int month;
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name="visid")
	private User person;
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name="carid")
	private Vehicle car;

	public Application() {
		super();
	}

	public Application(double offer, int month, User person, Vehicle car) {
		super();
		this.offer = offer;
		this.month = month;
		this.person = person;
		this.car = car;
	}

	public Application(int appId, double offer, int month, User person, Vehicle car) {
		super();
		this.appId = appId;
		this.offer = offer;
		this.month = month;
		this.person = person;
		this.car = car;
	}

	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}

	public double getOffer() {
		return offer;
	}

	public void setOffer(double offer) {
		this.offer = offer;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public User getPerson() {
		return person;
	}

	public void setPerson(User person) {
		this.person = person;
	}

	public Vehicle getCar() {
		return car;
	}

	public void setCar(Vehicle car) {
		this.car = car;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + appId;
		result = prime * result + ((car == null) ? 0 : car.hashCode());
		result = prime * result + month;
		long temp;
		temp = Double.doubleToLongBits(offer);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((person == null) ? 0 : person.hashCode());
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
		Application other = (Application) obj;
		if (appId != other.appId)
			return false;
		if (car == null) {
			if (other.car != null)
				return false;
		} else if (!car.equals(other.car))
			return false;
		if (month != other.month)
			return false;
		if (Double.doubleToLongBits(offer) != Double.doubleToLongBits(other.offer))
			return false;
		if (person == null) {
			if (other.person != null)
				return false;
		} else if (!person.equals(other.person))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Application [appId=" + appId + ", offer=" + offer + ", month=" + month + ", person=" + person + ", car="
				+ car + "]";
	}	
	
}
