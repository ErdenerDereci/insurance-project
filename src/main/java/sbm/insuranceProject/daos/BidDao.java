package sbm.insuranceProject.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sbm.insuranceProject.models.Bid;

@Repository
public interface BidDao extends JpaRepository<Bid, Integer> {

}
