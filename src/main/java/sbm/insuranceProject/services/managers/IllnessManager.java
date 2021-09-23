package sbm.insuranceProject.services.managers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbm.insuranceProject.daos.IllnessDao;
import sbm.insuranceProject.models.Illness;
import sbm.insuranceProject.results.Result;
import sbm.insuranceProject.services.IllnessService;

import java.util.List;

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
    public void update(Illness entity) {

    }

    @Override
    public Illness getById(int id) {
        return null;
    }
}
