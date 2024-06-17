package pl.lukasz.CarRentalManager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lukasz.CarRentalManager.entities.Invoice;
import pl.lukasz.CarRentalManager.repositories.InvoiceRepository;

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

    public void saveInvoice(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    public void deleteInvoiceById(Long id) {
        invoiceRepository.deleteById(id);
    }
}
