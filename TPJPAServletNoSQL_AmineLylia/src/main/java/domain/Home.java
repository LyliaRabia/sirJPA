package domain;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.security.acl.Owner;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class Home {
	private long id;
	private long taille;
	private int nbPiece;
	private Collection<Heater> heaters;
	private Collection<Person> owners;

	public Home() {

	}
	
	public Home(long taille, int nbPiece, Collection<Heater> heaters, Collection<Person> owners) {
		this.taille = taille;
		this.nbPiece = nbPiece;
		this.heaters = heaters;
		this.owners = owners;
	}
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getTaille() {
		return taille;
	}
	
	public void setTaille(long taille) {
		this.taille = taille;
	}
	
	public int getNbPiece() {
		return nbPiece;
	}

	public void setNbPiece(int nbPiece) {
		this.nbPiece = nbPiece;
	}

	@JsonIgnore
	@OneToMany(mappedBy="home", cascade = CascadeType.PERSIST)
	public Collection<Heater> getHeaters() {
		return heaters;
	}
	
	public void setHeaters(Collection<Heater> heaters) {
		this.heaters = heaters;
	}

	@JsonIgnore
	@ManyToMany
	public Collection<Person> getOwners() {
		return owners;
	}

	public void setOwners(Collection<Person> owners) {
		this.owners = owners;
	}

    @Override
	public String toString() {
		String result = "Home [taille=" + taille + ", nbPiece=" + nbPiece + "]";
		
		for(Heater heater : this.heaters) {
			result += heater.toString();
		}
		
		return result;
	}
}
