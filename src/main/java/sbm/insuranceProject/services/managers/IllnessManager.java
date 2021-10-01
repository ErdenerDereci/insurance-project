package sbm.insuranceProject.services.managers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbm.insuranceProject.daos.IllnessDao;
import sbm.insuranceProject.models.Illness;
import sbm.insuranceProject.results.Result;
import sbm.insuranceProject.services.IllnessService;

import java.util.List;
import java.util.Optional;

@Service
public class IllnessManager implements IllnessService {

    @Autowired
    private IllnessDao illnessDao;

    @Override
    public Result add(Illness entity) {
        return null;
    }

    @Override
    public List<Illness> getAll() {
        return illnessDao.findAll();
    }

    @Override
    public void delete(Illness entity) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Result update(Illness entity) {
        return null;
    }

    @Override
    public Illness getById(int id) {
        return null;
    }

    @Override
    public Optional<Illness> findById(int id) {
       return illnessDao.findById(id);
    }
}
