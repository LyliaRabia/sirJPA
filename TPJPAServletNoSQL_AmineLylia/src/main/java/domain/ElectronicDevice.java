package domain;

import javax.persistence.*;

	@Entity
	public class ElectronicDevice {

		private String nom;

		private long id;
		private int conso;
		private Person person;


		public ElectronicDevice(String nom, int conso, Person person) {
			this.nom = nom;
			this.conso = conso;
			this.person = person;
		}

		public ElectronicDevice() {
		}

		public int getConso() {
			return conso;
		}

		public void setConso(int conso) {
			conso = conso;
		}

		@Id
		@GeneratedValue
		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}


		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="OWNER_ID")
		public Person getPerson(){
			return person;
		}

		public void setPerson(Person owner){
			this.person=owner;
		}
	}
