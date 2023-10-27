package Dao.Imple;

import Dao.BaseDao;
import Entity.Reservations;

import java.util.List;
import java.util.Optional;

public class ReservationDao implements BaseDao<Reservations> {

    @Override
    public Optional<Reservations> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Reservations save(Reservations reservations) {
        return null;
    }

    @Override
    public List<Reservations> all() {
        return null;
    }

    @Override
    public Boolean update(Long id, Reservations reservations) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }
}
