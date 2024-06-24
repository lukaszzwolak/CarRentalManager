package pl.lukasz.CarRentalManager.services;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import pl.lukasz.CarRentalManager.entities.*;
import pl.lukasz.CarRentalManager.repositories.*;

import java.util.List;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    public Invoice getInvoiceById(Long id) {
        return invoiceRepository.findById(id).orElse(null);
    }

    public Invoice saveInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    public void deleteInvoiceById(Long id) {
        invoiceRepository.deleteById(id);
    }
}
