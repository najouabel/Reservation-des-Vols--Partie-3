package Dao.Imple;

import Dao.BaseDao;
import Entity.Vols;
import jakarta.persistence.*;

import java.util.List;
import java.util.Optional;

public class VolsDao implements BaseDao<Vols> {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    public VolsDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
        entityTransaction = entityManager.getTransaction();
    }

    @Override
    public Optional<Vols> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Vols.class, id));
    }

    @Override
    public Vols save(Vols vol) {
        try {
            entityTransaction.begin();
            if (vol.getId() == 0) {
                entityManager.persist(vol);
            } else {
                vol = entityManager.merge(vol);
            }
            entityTransaction.commit();
            return vol;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public List<Vols> all() {
        return entityManager.createQuery("from Vols", Vols.class).getResultList();
    }

    @Override
    public Boolean update(Long id, Vols vol) {
        try {
            entityTransaction.begin();
            vol.setId(id.intValue());
            entityManager.merge(vol);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
            return false;
        } finally {
            entityManager.close();
        }
    }
    @Override
    public Boolean delete(Long id) {
        try {
            entityTransaction.begin();
            Vols vol = entityManager.find(Vols.class, id);
            if (vol != null) {
                entityManager.remove(vol);
            }
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
