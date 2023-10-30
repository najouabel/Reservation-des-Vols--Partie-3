package Services;

import Dao.Imple.VolsDao;
import Entity.Vols;

import java.util.List;
import java.util.Optional;

public class VolService {

    private VolsDao volsDao;

    public VolService() {
        this.volsDao = new VolsDao();
    }

    public Optional<Vols> getVolById(Long id) {
        return volsDao.findById(id);
    }

    public List<Vols> getAllVols() {
        return volsDao.all();
    }

    public boolean updateVol(Long id, Vols vol) {
        return volsDao.update(id, vol);
    }

    public boolean deleteVol(Long id) {
        return volsDao.delete(id);
    }


}
