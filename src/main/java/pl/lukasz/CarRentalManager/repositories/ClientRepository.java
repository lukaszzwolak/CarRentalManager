package pl.lukasz.CarRentalManager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.lukasz.CarRentalManager.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
