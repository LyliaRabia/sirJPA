import domain.ElectronicDevice;
import domain.Department;
import domain.Heater;
import domain.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import test.testjpa.domain.Employee;
import test.testjpa.domain.Department;
public class JpaTest {
    private EntityManager manager;
    public JpaTest(EntityManager manager) {
        this.manager = manager;
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        EntityManagerFactory factory =   
              Persistence.createEntityManagerFactory("example");
        EntityManager manager = factory.createEntityManager();
        JpaTest test = new JpaTest(manager);
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
            test.createEmployees();
        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();
        test.listEmployees();
            
        manager.close();
        System.out.println(".. done");
    }
    
	private static void create(EntityManager manager) {
		Long nbPersonne = (Long) manager.createQuery("select count(p) FROM Employee e").getSingleResult();
		
		if(nbPersonne == 0) {
			Collection<ElectronicDevice> electronicsP1 = new ArrayList<ElectronicDevice>();
			Collection<ElectronicDevice> electronicsP2 = new ArrayList<ElectronicDevice>();
			Collection<ElectronicDevice> electronicsP3 = new ArrayList<ElectronicDevice>();
			
			Person e1 = new Person("Saker", "Amine", "amine.saker@hotmail.fr");
			Person e2 = new Person("Rabia", "Lylia", "lylia.rabia@hotmail.fr");
			
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
			
			e1.setDevices(electronicsP1);
			e2.setDevices(electronicsP2);

			Collection<Department> departments1 = new ArrayList<Department>();
			Collection<Department> departments2 = new ArrayList<Department>();
			
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
			
			ownersD1.add(e1);
			ownersD1.add(e2);
			
			Department department1 = new Department((long) 51.00, 1, heaterP1, ownersD1);
			Department department2 = new Department((long) 35.00, 2, heaterP2, ownersD2);
			departments1.add(department1);
			departments2.add(department2);

            d1.setDepartment(department1);
            d2.setDepartment(department1);
            
			
			Collection<Person> friendsP1 = new ArrayList<Person>();
			Collection<Person> friendsP2 = new ArrayList<Person>();
			
			friendsP1.add(e2);
			
			friendsP2.add(p1);
			friendsP2.add(p2);
			
			p1.setFriends(friendsP1);
			p2.setFriends(friendsP2);
			
			p1.setDepartments(department2);
			p2.setDepartments(department1);
			
			department1.setOwners(ownersD1);
			department2.setOwners(ownersD2);
			
			manager.persist(e1);
			manager.persist(e2);
		}
	}
	
    private void createEmployees() {
        int numOfEmployees = manager.createQuery("Select a From Employee a", Person.class).getResultList().size();
        if (numOfEmployees == 0) {
            Department department = new Department("java");
            manager.persist(department);
            manager.persist(new Person("Jakab Gipsz",department));
            manager.persist(new Person("Captain Nemo",department));
        }
    }
    private void listEmployees() {
        List<Person> resultList = manager.createQuery("Select a From Employee a", Person.class).getResultList();
        System.out.println("num of employess:" + resultList.size());
        for (Person next : resultList) {
            System.out.println("next employee: " + next);
        }
    }
}

