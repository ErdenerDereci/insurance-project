package sbm.insuranceProject.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sbm.insuranceProject.models.Illness;

@Repository
public interface IllnessDao extends JpaRepository<Illness,Integer> {
}
