package Controllers;

import Dao.Imple.AdminDao;
import Dao.Imple.SocieteDao;
import Entity.Societe;
import Services.jpa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class SocieteController {
    private final jpa jpaInstance = jpa.getInstance();

    public boolean createSociete(Societe societe) {
        EntityManagerFactory emf = jpaInstance.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(societe);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }


}
