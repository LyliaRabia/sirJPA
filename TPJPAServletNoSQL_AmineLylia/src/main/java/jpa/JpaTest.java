package jpa;

import domain.ElectronicDevice;
import domain.Heater;
import domain.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class JpaTest {
    private EntityManager manager;
    public JpaTest(EntityManager manager) {
        this.manager = manager;
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		try {
			create(manager);
		} catch (Exception e) {
			e.printStackTrace();
		}

		tx.commit();

		manager.close();
		factory.close();
    }
    
	private static void create(EntityManager manager) {
		Long nbPersonne = (Long) manager.createQuery("select count(e) FROM Person e").getSingleResult();
		
		if(nbPersonne == 0) {
			List<ElectronicDevice> electronicsP1 = new ArrayList<ElectronicDevice>();
			List<ElectronicDevice> electronicsP2 = new ArrayList<ElectronicDevice>();
			List<ElectronicDevice> electronicsP3 = new ArrayList<ElectronicDevice>();
			
			Person p1 = new Person("Saker", "Amine", "amine.saker@hotmail.fr");
			Person p2 = new Person("Rabia", "Lylia", "lylia.rabia@hotmail.fr");
			
			ElectronicDevice ed1 = new ElectronicDevice("Smartphone", 1, p2);
			ElectronicDevice ed2 = new ElectronicDevice("Television", 1, p1);
			ElectronicDevice ed3 = new ElectronicDevice("Ordinateur", 2, p1);

			ElectronicDevice ed4 = new ElectronicDevice("Smartphone", 1, p2);
			ElectronicDevice ed5 = new ElectronicDevice("Ordinateur-portable", 3, p2);

			electronicsP1.add(ed1);
			electronicsP1.add(ed2);

			electronicsP2.add(ed3);
			electronicsP2.add(ed4);
			electronicsP2.add(ed5);

			p1.setDevices(electronicsP1);
			p2.setDevices(electronicsP2);

			Collection<Person> ownersD1 = new ArrayList<Person>();
			Collection<Person> ownersD2 = new ArrayList<Person>();

			Collection<Heater> heaterP1 = new ArrayList<Heater>();
			Collection<Heater> heaterP2 = new ArrayList<Heater>();

			Heater h1 = new Heater("Cuisine", 6);
			Heater h2 = new Heater("Salle de bain", 5);

			heaterP1.add(h1);
			heaterP1.add(h2);

			heaterP2.add(h1);
			heaterP2.add(h2);

			ownersD1.add(p1);
			ownersD1.add(p1);

			/**
			Department department1 = new Department((long) 51.00, 1, heaterP1, ownersD1);
			Department department2 = new Department((long) 35.00, 2, heaterP2, ownersD2);
			departments1.add(department1);
			departments2.add(department2);

            d1.setDepartment(department1);
            d2.setDepartment(department1);
			 **/

			Collection<Person> friendsP1 = new ArrayList<Person>();
			Collection<Person> friendsP2 = new ArrayList<Person>();

			friendsP1.add(p1);

			friendsP2.add(p1);
			friendsP2.add(p2);

			p1.setFriends(friendsP1);
			p2.setFriends(friendsP2);

			/**
			p1.setDepartments(department2);
			p2.setDepartments(department1);

			department1.setOwners(ownersD1);
			department2.setOwners(ownersD2);
			*/

			manager.persist(p1);
			manager.persist(p2);
			manager.persist(ed1);
			manager.persist(ed2);
			manager.persist(ed3);
			manager.persist(ed4);
			manager.persist(ed5);
			manager.persist(h1);
			manager.persist(h2);
		}
	}


	private static void listPersons(EntityManager manager) {
		Collection<Person> resultList = manager.createQuery( "Select p from Person p", Person.class).getResultList();

		System.out.println("Nombre de personnes : " + resultList.size());

		for (Person next : resultList) {
			System.out.println("Personne : " + next.toString());
		}
	}

	public static void listPersonsCriteria(EntityManager manager) {
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();

		CriteriaQuery<Object> query = criteriaBuilder.createQuery(Object.class);
		Root<Person> from = query.from(Person.class);

		query.select(from.get("nom"));

		System.out.println(manager.createQuery(query).getResultList());
	}

}

