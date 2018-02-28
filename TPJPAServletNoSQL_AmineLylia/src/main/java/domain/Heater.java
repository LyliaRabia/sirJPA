package domain;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Heater {

	private int consoMoyenne;
	
	private String name;
	
	public Heater(String nom, int conso) {
		this.name = nom;
		this.consoMoyenne = conso;
	}

	public int getConsoMoyenne() {
		return consoMoyenne;
	}

	public void setConsoMoyenne(int consoMoyenne1) {
		this.consoMoyenne = consoMoyenne1;
	}

}
