package pl.lukasz.CarRentalManager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.lukasz.CarRentalManager.entities.Invoice;
import pl.lukasz.CarRentalManager.services.ClientService;
import pl.lukasz.CarRentalManager.services.CarService;
import pl.lukasz.CarRentalManager.services.InvoiceService;

@Controller
@RequestMapping("/invoice")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private CarService carService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("invoices", invoiceService.getAllInvoices());
        return "invoiceDirectory/invoice-list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("invoice", new Invoice());
        model.addAttribute("clients", clientService.getAllClients());
        model.addAttribute("cars", carService.getAllCars());
        return "invoiceDirectory/invoice-add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Invoice invoice) {
        invoiceService.saveInvoice(invoice);
        return "redirect:/invoice/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Invoice invoice = invoiceService.getInvoiceById(id);
        model.addAttribute("invoice", invoice);
        model.addAttribute("clients", clientService.getAllClients());
        model.addAttribute("cars", carService.getAllCars());
        return "invoiceDirectory/invoice-edit";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Long id, Model model) {
        Invoice invoice = invoiceService.getInvoiceById(id);
        model.addAttribute("invoice", invoice);
        return "invoiceDirectory/invoice-remove";
    }

    @PostMapping("/remove")
    public String remove(@ModelAttribute Invoice invoice) {
        invoiceService.deleteInvoiceById(invoice.getId());
        return "redirect:/invoice/list";
    }
}
