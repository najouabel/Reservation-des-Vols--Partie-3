package Dao.Imple;

import Dao.BaseDao;
import Entity.Clients;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Optional;

public class ClientDao implements BaseDao<Clients> {

    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    EntityTransaction entityTransaction;

    public ClientDao(){
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
        entityTransaction = entityManager.getTransaction();
    }

    @Override
    public Optional<Clients> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Clients.class, id));
    }

    @Override
    public Clients save(Clients clients) {
        try {
            entityTransaction.begin();
            if(clients == null){
                entityManager.persist(null);
            }
            entityManager.merge(clients);
            entityTransaction.commit();
            return clients;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public List<Clients> all() {
        return entityManager.createQuery("from Clients ", Clients.class).getResultList();
    }

    @Override
    public Boolean update(Long id, Clients admin) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        try{
            entityTransaction.begin();
            Optional<Clients> clients = findById(id);
            clients.ifPresent(a -> entityManager.remove(a));
            entityTransaction.commit();
        }catch (Exception e){
            entityTransaction.rollback();
            return false;
        } finally {
            entityManager.close();
        }
        return true;
    }
}
