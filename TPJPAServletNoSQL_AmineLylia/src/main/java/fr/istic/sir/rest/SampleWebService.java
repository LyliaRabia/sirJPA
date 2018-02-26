package fr.istic.sir.rest;

import domain.ElectronicDevice;
import domain.Heater;
import domain.Home;
import domain.Person;

import javax.persistence.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("/API")
public class SampleWebService {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String welcomeMessage() {
        String res = "Hello, welcome to our API service. Here the next word to add to the current url to get infos :" +
                "\n\t - person " +
                "\n\t - device" +
                "\n\t - heater" +
                "\n\t - home";

        return res;
    }

    @GET @Path("/person")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Person> getPerson() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("example");
        EntityManager manager = factory.createEntityManager();

        Collection<Person> resultList = manager.createQuery("Select p from Person p", Person.class).getResultList();

        manager.close();
        factory.close();

        return resultList;
    }

    @GET @Path("/home")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Home> getHome() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("example");
        EntityManager manager = factory.createEntityManager();

        Collection<Home> resultList = manager.createQuery("Select h from Home h", Home.class).getResultList();

        manager.close();
        factory.close();

        return resultList;
    }

    @GET @Path("/device")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<ElectronicDevice> getDevice() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("example");
        EntityManager manager = factory.createEntityManager();

        Collection<ElectronicDevice> resultList = manager.createQuery("Select ed from ElectronicDevice ed", ElectronicDevice.class).getResultList();

        manager.close();
        factory.close();

        return resultList;
    }

    @GET @Path("/heater")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Heater> getHeater() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("example");
        EntityManager manager = factory.createEntityManager();

        Collection<Heater> resultList = manager.createQuery("Select h from Heater h", Heater.class).getResultList();

        manager.close();
        factory.close();

        return resultList;
    }

    @POST
    @Path("/person")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPerson(@QueryParam("fName") String name, @QueryParam("lName") String lastName, @QueryParam("email") String email){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("example");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();

        Person p = new Person(name, lastName, email);

        tx.begin();
        manager.persist(p);
        tx.commit();

        manager.close();
        factory.close();

        String result = "Last name : " + lastName + "; First name : " + name + "; Email : " + email;
        return Response.status(200).entity(result).build();
    }

    @POST
    @Path("/heater")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createHeater(@QueryParam("name") String name, @QueryParam("conso") int conso, @QueryParam("home") long homeId) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("example");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();

        //On récupère la maison par l'ID
        Home home = manager.createQuery("Select h from Home h where h.id = :idHome", Home.class).setParameter("idHome", homeId).getSingleResult();

        Heater h = new Heater(name, conso, home);

        tx.begin();
        manager.persist(h);
        tx.commit();

        manager.close();
        factory.close();

        String result = "Name : " + name + "; Consommation : " + conso + "; Home ID : " + homeId;
        return Response.status(200).entity(result).build();
    }
}