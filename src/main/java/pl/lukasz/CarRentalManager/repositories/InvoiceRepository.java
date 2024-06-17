package pl.lukasz.CarRentalManager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.lukasz.CarRentalManager.entities.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}
