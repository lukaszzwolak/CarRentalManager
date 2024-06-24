package pl.lukasz.CarRentalManager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.lukasz.CarRentalManager.entities.*;
import pl.lukasz.CarRentalManager.services.*;

@Controller
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    private InvoiceService service;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("invoices", service.getAllInvoices());
        return "invoiceDirectory/invoice-list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("invoice", new Invoice());
        return "invoiceDirectory/invoice-add";
    }

    @PostMapping("/add")
    public String add(Invoice invoice) {
        service.saveInvoice(invoice);
        return "redirect:/invoice/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Invoice invoice = service.getInvoiceById(id);
        model.addAttribute("invoice", invoice);
        return "invoiceDirectory/invoice-edit";
    }

    @PostMapping("/edit")
    public String edit(Invoice invoice) {
        service.saveInvoice(invoice);
        return "redirect:/invoice/list";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Long id, Model model) {
        Invoice invoice = service.getInvoiceById(id);
        model.addAttribute("invoice", invoice);
        return "invoiceDirectory/invoice-remove";
    }

    @PostMapping("/remove")
    public String remove(Invoice invoice) {
        service.deleteInvoiceById(invoice.getId());
        return "redirect:/invoice/list";
    }
}
