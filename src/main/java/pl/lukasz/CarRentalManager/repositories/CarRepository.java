package pl.lukasz.CarRentalManager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.lukasz.CarRentalManager.entities.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}
