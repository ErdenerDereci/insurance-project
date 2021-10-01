package sbm.insuranceProject.services;

import sbm.insuranceProject.models.Illness;

import java.util.Optional;

public interface IllnessService extends ServiceBase<Illness> {
    Optional<Illness> findById(int id);
}
