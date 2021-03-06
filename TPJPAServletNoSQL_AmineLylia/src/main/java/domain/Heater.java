package domain;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Heater {

	private long id;
	private String nom;

	public int getConsoMoyenne() {
		return consoMoyenne;
	}

	public void setConsoMoyenne(int consoMoyenne) {
		this.consoMoyenne = consoMoyenne;
	}

	private int consoMoyenne;
	private Home home;

	public Heater() {}

	public Heater(String nom, int conso) {
		this.nom = nom;
		this.consoMoyenne = conso;
	}

	public Heater(String nom, int conso, Home home) {
		this.nom = nom;
		this.consoMoyenne = conso;
		this.home = home;
	}

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}



	@ManyToOne
	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}

	@Override
	public String toString() {
		return "Heater [nom=" + nom + ", consoMoyenne =" + consoMoyenne + "]";
	}

}
