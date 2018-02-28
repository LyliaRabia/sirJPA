package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestDao {

    public TestDao() {
    }


    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
    private EntityManager entityManager = this.entityManagerFactory.createEntityManager();
    private EntityTransaction transaction = this.entityManager.getTransaction();


    public void create(Object... t) {
        this.transaction.begin();
        for (Object anO : t) {
            this.entityManager.persist(anO);
        }
        this.transaction.commit();
    }

    public Object read(int id) {
        return null;
    }

    public void update(Object... t) {
        this.transaction.begin();
        for (Object in : t) {
            this.entityManager.merge(in);
        }
        this.transaction.commit();
    }

    public void delete(Object... t) {
        this.transaction.begin();
        for (Object in : t) {
            this.entityManager.remove(in);
        }
        entityManager.flush();
        entityManager.clear();
        this.transaction.commit();
    }
}
