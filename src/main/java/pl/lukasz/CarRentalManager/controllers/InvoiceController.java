package pl.lukasz.CarRentalManager.controllers;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import pl.lukasz.CarRentalManager.entities.*;
import pl.lukasz.CarRentalManager.services.*;

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

    @PostMapping("/add")
    public String add(Invoice invoice) {
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

    @PostMapping("/edit")
    public String edit(Invoice invoice) {
        invoiceService.saveInvoice(invoice);
        return "redirect:/invoice/list";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Long id) {
        invoiceService.deleteInvoiceById(id);
        return "redirect:/invoice/list";
    }
}