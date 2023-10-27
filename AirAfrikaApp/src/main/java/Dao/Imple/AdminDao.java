package Dao.Imple;

import Dao.BaseDao;
import Entity.Admins;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.List;
import java.util.Optional;

public class AdminDao implements BaseDao<Admins> {

    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    EntityTransaction entityTransaction;

    public AdminDao(){
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
        entityTransaction = entityManager.getTransaction();
    }

    @Override
    public Optional<Admins> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Admins.class, id));
    }

    @Override
    public Admins save(Admins admin) {
        try {
            entityTransaction.begin();
            if(admin == null){
                entityManager.persist(null);
            }
            entityManager.merge(admin);
            entityTransaction.commit();
            return admin;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public List<Admins> all() {
        return entityManager.createQuery("from Admins ", Admins.class).getResultList();
    }

    @Override
    public Boolean update(Long id, Admins admin) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        try{
            entityTransaction.begin();
            Optional<Admins> admin = findById(id);
            admin.ifPresent(a -> entityManager.remove(a));
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
