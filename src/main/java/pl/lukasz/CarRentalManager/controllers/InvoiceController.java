package pl.lukasz.CarRentalManager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.lukasz.CarRentalManager.entities.Invoice;
import pl.lukasz.CarRentalManager.services.InvoiceService;

import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    // Get all invoices
    @GetMapping
    public List<Invoice> getAllInvoices() {
        return invoiceService.getAllInvoices();
    }

    // Get invoice by ID
    @GetMapping("/{id}")
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable Long id) {
        Invoice invoice = invoiceService.getInvoiceById(id);
        if (invoice != null) {
            return ResponseEntity.ok(invoice);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Create a new invoice
    @PostMapping
    public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice) {
        Invoice savedInvoice = invoiceService.saveInvoice(invoice);
        return ResponseEntity.ok(savedInvoice);
    }

    // Update an invoice
    @PutMapping("/{id}")
    public ResponseEntity<Invoice> updateInvoice(@PathVariable Long id, @RequestBody Invoice invoice) {
        Invoice existingInvoice = invoiceService.getInvoiceById(id);
        if (existingInvoice != null) {
            existingInvoice.setClient(invoice.getClient());
            existingInvoice.setCar(invoice.getCar());
            existingInvoice.setAmount(invoice.getAmount());
            Invoice updatedInvoice = invoiceService.saveInvoice(existingInvoice);
            return ResponseEntity.ok(updatedInvoice);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete an invoice
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable Long id) {
        Invoice existingInvoice = invoiceService.getInvoiceById(id);
        if (existingInvoice != null) {
            invoiceService.deleteInvoiceById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
