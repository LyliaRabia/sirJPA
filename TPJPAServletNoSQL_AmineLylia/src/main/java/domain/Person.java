package domain;
import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.Collection;

import javax.persistence.*;

@Entity
public class Person {
	private long id;
	private String nom;
	private String prenom;
	private String mail;
	private Collection<Home> homes;
	private Collection<Person> friends;
	private Collection<ElectronicDevice> devices;

	public Person() {

	}
	
	public Person(String nom, String prenom, String mail) {
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
	}

	public Person(String nom, String prenom, String mail, Collection<ElectronicDevice> devices) {
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.devices = devices;
	}

	public Person(String nom, String prenom, String mail, Collection<Home> homes, Collection<Person> friends, Collection<ElectronicDevice> devices) {
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.homes = homes;
		this.friends = friends;
		this.devices = devices;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@JsonIgnore
	@ManyToMany(mappedBy="owners", cascade = CascadeType.PERSIST)
	public Collection<Home> getHomes() {
		return homes;
	}

	public void setHomes(Collection<Home> homes) {
		this.homes = homes;
	}

	@JsonIgnore
	@ManyToMany
	public Collection<Person> getFriends() {
		return friends;
	}

	public void setFriends(Collection<Person> friends) {
		this.friends = friends;
	}

	@JsonIgnore
	@OneToMany(mappedBy="person", cascade = CascadeType.PERSIST)
	public Collection<ElectronicDevice> getDevices() {
		return devices;
	}

	public void setDevices(Collection<ElectronicDevice> devices) {
		this.devices = devices;
	}

	@Override
	public String toString() {
		String result = "Person [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + "]";
		
		return result;
	}

}
