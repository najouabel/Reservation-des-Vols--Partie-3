package Dao.Imple;

import Dao.BaseDao;
import Entity.Societe;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.List;
import java.util.Optional;

public class SocieteDao implements BaseDao<Societe> {

    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    EntityTransaction entityTransaction;

    public SocieteDao(){
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
        entityTransaction = entityManager.getTransaction();
    }

    @Override
    public Optional<Societe> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Societe.class, id));
    }

    @Override
    public Societe save(Societe societe) {
        try {
            entityTransaction.begin();
            if (societe == null) {
                entityManager.persist(null);
            }
            entityManager.merge(societe);
            entityTransaction.commit();
            return societe;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public  List<Societe> all() {
        return entityManager.createQuery("from Societe", Societe.class).getResultList();
    }

    @Override
    public Boolean update(Long id, Societe societe) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        try {
            entityTransaction.begin();
            Optional<Societe> societe = findById(id);
            societe.ifPresent(s -> entityManager.remove(s));
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
            return false;
        } finally {
            entityManager.close();
        }
        return true;
    }
}
