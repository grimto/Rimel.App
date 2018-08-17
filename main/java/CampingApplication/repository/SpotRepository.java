package CampingApplication.repository;

import CampingApplication.Entites.Spot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpotRepository extends JpaRepository<Spot, Long> {

    Spot save(Spot emp);
}
