package domain;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Heater {

	private int temperatureMinimale;
	
	private int temperatureMaximale;
	
	private String energie;
	
	public Heater(String name, int tempMin, int tempMax) {
		this.temperatureMinimale = tempMin;
		this.temperatureMaximale = tempMax;
	}

	public int getTemperatureMinimale() {
		return temperatureMinimale;
	}

	public void setTemperatureMinimale(int temperatureMinimale) {
		this.temperatureMinimale = temperatureMinimale;
	}

	public int getTemperatureMaximale() {
		return temperatureMaximale;
	}

	public void setTemperatureMaximale(int temperatureMaximale) {
		this.temperatureMaximale = temperatureMaximale;
	}

	public String getEnergie() {
		return energie;
	}

	public void setEnergie(String energie) {
		this.energie = energie;
	}
	
}
